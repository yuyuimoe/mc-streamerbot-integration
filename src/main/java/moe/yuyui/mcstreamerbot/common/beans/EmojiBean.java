package moe.yuyui.mcstreamerbot.common.beans;

import com.google.gson.annotations.SerializedName;

public class EmojiBean {

    @SerializedName("Emoji")
    private final String _emoji;
    @SerializedName("Text")
    private final String _text;
    @SerializedName("Image")
    private final String _imagePath;
    @SerializedName("StartIndex")
    private final int _startIndex;
    @SerializedName("EndIndex")
    private final int _endIndex;

    public EmojiBean(String emoji, String text, String imagePath, int startIndex, int endIndex) {
        this._emoji = emoji;
        this._text = text;
        this._imagePath = imagePath;
        this._startIndex = startIndex;
        this._endIndex = endIndex;
    }

    public String getEmoji() {
        return this._emoji;
    }

    public String getText() {
        return this._text;
    }

    public String getImagePath() {
        return this._imagePath;
    }

    public int getStartIndex() {
        return this._startIndex;
    }

    public int getEndIndex() {
        return this._endIndex;
    }
}
