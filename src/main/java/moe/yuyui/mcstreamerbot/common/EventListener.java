package moe.yuyui.mcstreamerbot.common;

import moe.yuyui.mcstreamerbot.MCStreamerBot;

public class EventListener extends Thread {

    private final WSServer _websocketServer;

    public EventListener(WSServer websocketServer) {
        this._websocketServer = websocketServer;
        start();
    }

    @Override
    public void run() {
        try {
            MCStreamerBot.LOG.info("Event Listener starting...");
            this._websocketServer.run();
        } catch (NullPointerException e) {
            MCStreamerBot.LOG.error("Event Listener has failed. Websocket issue.", e);
        }
    }

    public void end() throws InterruptedException {
        MCStreamerBot.LOG.info("Event listener stopping");
        this._websocketServer.getConnections()
            .forEach((connection) -> connection.closeConnection(1, "Server closed"));
        this._websocketServer.stop();
        MCStreamerBot.LOG.info("Event listener stopped");
    }
}
