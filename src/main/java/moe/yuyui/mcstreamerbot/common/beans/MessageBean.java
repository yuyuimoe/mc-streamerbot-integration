package moe.yuyui.mcstreamerbot.common.beans;

import javax.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class MessageBean {

    @SerializedName("Text")
    private final String _text;
    @SerializedName("Emoji")
    private final EmojiBean _emoji;

    public MessageBean(String text, @Nullable EmojiBean emoji) {
        this._text = text;
        this._emoji = emoji;
    }

    public String getText() {
        return this._text;
    }

    public EmojiBean getEmoji() {
        return this._emoji;
    }
}
