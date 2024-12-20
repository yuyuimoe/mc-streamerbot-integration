package moe.yuyui.mcstreamerbot.common.beans;

import com.google.gson.annotations.SerializedName;

public class UserBean {

    @SerializedName("Name")
    private final String _name;
    @SerializedName("YoutubeId")
    private final String _youtubeId;
    @SerializedName("IsSubscriber")
    private final boolean _isSubscriber;
    @SerializedName("IsModerator")
    private final boolean _isModerator;
    @SerializedName("IsMember")
    private final boolean _isMember;
    @SerializedName("IsBroadcaster")
    private final boolean _isBroadcaster;

    public UserBean(String name, String youtubeId, boolean isSubscriber, boolean isModerator, boolean isMember,
        boolean isBroadcaster) {
        this._name = name;
        this._youtubeId = youtubeId;
        this._isSubscriber = isSubscriber;
        this._isModerator = isModerator;
        this._isMember = isMember;
        this._isBroadcaster = isBroadcaster;
    }

    public String getName() {
        return _name;
    }

    public String getYoutubeId() {
        return _youtubeId;
    }

    public boolean getIsSubscriber() {
        return _isSubscriber;
    }

    public boolean getIsModerator() {
        return _isModerator;
    }

    public boolean getIsMember() {
        return _isMember;
    }

    public boolean getIsBroadcaster() {
        return _isBroadcaster;
    }

}
