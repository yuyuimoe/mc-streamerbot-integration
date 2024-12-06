# Minecraft Streamer.Bot Integration
![Minecraft 1.7.10](https://img.shields.io/badge/Minecraft-1.7.10-green?style=plastic)
![Forge 10.13.4.1614](https://img.shields.io/badge/Forge-10.13.4.1614-orange?style=plastic)
![Streamer.bot 0.2.6](https://img.shields.io/badge/Streamer.bot-0.2.6-blue?style=plastic&labelColor=white)
![RetroFuturaGradle 1.4.1](https://img.shields.io/badge/RetroFuturaGradle-1.4.1-yellow?style=plastic&labelColor=blue)

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/B0B216W81V)

This mods allows you to integrate Streamer.bot into minecraft. **CLIENT-SIDE ONLY**

⚠️ Currently it only supports **Youtube**, and normal messages. No super chats or subscriber events YET! ⚠️
⚠️ It is also single-player only! But this will be changed sooner than Twitch support. ⚠️
## Installation

1. Download the latest release [here](https://github.com/yuyuimoe/mc-streamerbot-integration/releases) (It's the file without `-dev`, `-sources` and `-dev-preshadow`)
2. Paste the file into your mods folder
3. Configure it through the in-game GUI or through the config file.
4. By default, it will be running in `127.0.0.1` under the port `8069`.

## Usage

1. Open up streamer.bot
2. Go into import and [add this import string](https://kdn.wtf/mcsbi.txt)
3. (Optional) if you changed the port or IP address of the websocket server, change it accordingly on the Websocket client as well.
4. Enable auto-connect and reconnect in the websocket client connection.
5. Go into your minecraft world and check if you get "New client connection" message.
6. Monitor your livestream and have fun!

## Known issues
+ Currently this mod only works for YouTube. Twitch livestreams are unsupported at the moment.
+ Currently this mod only supports normal chat messages. Superchats and other activity will not show up.
+ Emojis are not supported in minecraft.

## Credits
+ yuyui.moe (me) for developing this mod
+ [Vampurrya](https://www.youtube.com/@Vampurrya) for the idea of this mod
