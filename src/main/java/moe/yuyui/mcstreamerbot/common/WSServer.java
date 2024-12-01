package moe.yuyui.mcstreamerbot.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import moe.yuyui.mcstreamerbot.common.beans.MessagePayloadBean;
import moe.yuyui.mcstreamerbot.common.enums.MessageType;
import moe.yuyui.mcstreamerbot.events.custom.OnChatMessage;

public class WSServer extends WebSocketServer {

    private final Set<WebSocket> _authClients = new HashSet<>();
    private byte[] _authToken = null;

    public WSServer(InetSocketAddress address) {
        super(address);
    }

    public WSServer(InetSocketAddress address, String authToken) throws NoSuchAlgorithmException {
        super(address);
        this._authToken = MessageDigest.getInstance("SHA-256")
            .digest(authToken.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        if (_authToken != null) {
            conn.send("bad girl");
            return;
        }
        _authClients.add(conn);
        System.out.println("New connection");
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        _authClients.remove(conn);
        System.out.println("Connection closed");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {}

    private boolean isAuthenticated(WebSocket conn) {
        return _authClients.contains(conn);
    }

    private boolean isBearerValid(String token) {
        if (_authToken == null) {
            return true;
        }
        if (token == null) {
            return false;
        }
        return token.equals(new String(_authToken, StandardCharsets.UTF_8));
    }

    public String decompressMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(byteBuffer.array()));
            BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (ZipException e) {
            System.out.println("Message is not valid");
        } catch (IOException ignored) {}
        return null;

    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer byteBuffer) {
        String message = decompressMessage(byteBuffer);
        if (message == null) {
            return;
        }

        Gson gson = new GsonBuilder().serializeNulls()
            .create();
        MessagePayloadBean payload = gson.fromJson(message, MessagePayloadBean.class);

        if (!isAuthenticated(conn) || isBearerValid(payload.getToken())) {
            _authClients.add(conn);
        }
        switch (MessageType.valueOf(payload.getType())) {
            case CHAT: {
                OnChatMessage.sendMessage(payload.getParts(), payload.getTimestamp(), payload.getUser());
                break;
            }
            case COMMAND: {
                break;
            }
            case LISTEN: {
                break;
            }
            case IGNORE: {
                break;
            }
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        conn.close();
    }

    @Override
    public void onStart() {
        System.out.println("Server started");
    }
}
