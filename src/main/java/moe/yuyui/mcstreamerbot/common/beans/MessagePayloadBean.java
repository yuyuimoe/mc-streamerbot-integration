package moe.yuyui.mcstreamerbot.common.beans;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MessagePayloadBean {

    @SerializedName("Type")
    private final short _type;
    @SerializedName("BearerToken")
    private final String _token;
    @SerializedName("UserInformation")
    private final UserBean _user;
    @SerializedName("Parts")
    private final List<MessageBean> _parts;
    @SerializedName("Timestamp")
    private final long _timestamp;

    public MessagePayloadBean(short type, String token, UserBean user, List<MessageBean> parts, long timestamp) {
        this._type = type;
        this._token = token;
        this._user = user;
        this._parts = parts;
        this._timestamp = timestamp;
    }

    public short getType() {
        return this._type;
    }

    public String getToken() {
        return this._token;
    }

    public UserBean getUser() {
        return this._user;
    }

    public List<MessageBean> getParts() {
        return this._parts;
    }

    public long getTimestamp() {
        return this._timestamp;
    }

}
