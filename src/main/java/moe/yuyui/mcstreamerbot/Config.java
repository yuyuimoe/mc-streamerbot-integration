package moe.yuyui.mcstreamerbot;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static final String CATEGORY_WEBSOCKET = "websocket";
    public static int portNumber = 8069;
    public static String ipAddress = "127.0.0.1";
    public static String authToken = "";
    public static boolean addTimestamp = true;
    public static Configuration configuration;

    public static void synchronizeConfiguration() {
        addTimestamp = configuration
            .getBoolean("Add timestamp", Configuration.CATEGORY_GENERAL, addTimestamp, "Add timestamp to messages");

        configuration.addCustomCategoryComment(CATEGORY_WEBSOCKET, "Configuration for the websocket");
        portNumber = configuration
            .getInt("Port", CATEGORY_WEBSOCKET, portNumber, 1024, 65535, "The Port that the websocket will listen on");
        ipAddress = configuration
            .getString("IP Address", CATEGORY_WEBSOCKET, ipAddress, "The IP Address that the websocket will listen on");
        authToken = configuration.getString(
            "Authentication Token",
            CATEGORY_WEBSOCKET,
            authToken,
            "The authentication token for the websocket. Leave empty to disable authentication.");

        if (configuration.hasChanged()) {
            MCStreamerBot.LOG.debug("Configuration saved.");
            configuration.save();
        }
    }
}
