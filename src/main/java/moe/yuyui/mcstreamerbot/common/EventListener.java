package moe.yuyui.mcstreamerbot.common;

public class EventListener extends Thread {

    private final WSServer _websocketServer;

    public EventListener(WSServer websocketServer) {
        this._websocketServer = websocketServer;
        start();
    }

    @Override
    public void run() {
        try {
            this._websocketServer.run();
            System.out.println("Event Listener started");
        } catch (NullPointerException e) {
            System.out.println("Event Listener stopped. Websocket has failed.");
        }
    }

    public void end() throws InterruptedException {
        this._websocketServer.getConnections()
            .forEach((connection) -> connection.closeConnection(1, "Server closed"));
        this._websocketServer.stop();
    }
}
