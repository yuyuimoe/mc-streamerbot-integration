package moe.yuyui.mcstreamerbot;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    private static final String CATEGORY_WEBSOCKET = "websocket";
    public static int portNumber = 8069;
    public static String ipAddress = "127.0.0.1";
    public static String authToken = "";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);
        configuration.addCustomCategoryComment("General", "General configuration of the bot");
        portNumber = configuration
            .getInt("port", CATEGORY_WEBSOCKET, portNumber, 1024, 65535, "The port that the websocket will listen on");
        ipAddress = configuration
            .getString("ip", CATEGORY_WEBSOCKET, ipAddress, "The ip that the websocket will listen on");
        authToken = configuration
            .getString("authToken", CATEGORY_WEBSOCKET, authToken, "The authentication token for the websocket");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
