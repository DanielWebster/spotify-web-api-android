package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class TrackContext implements Parcelable{
    public String uri;
    public String href;
    public Map<String, String> external_urls;
    public String type;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uri);
        dest.writeString(this.href);
        dest.writeMap(this.external_urls);
        dest.writeString(this.type);
    }

    public TrackContext() {
    }

    protected TrackContext(Parcel in) {
        this.href = in.readString();
        this.uri = in.readString();
        this.external_urls = in.readHashMap(Map.class.getClassLoader());
        this.type = in.readString();
    }

    public static final Parcelable.Creator<TrackContext> CREATOR = new Parcelable.Creator<TrackContext>() {
        public TrackContext createFromParcel(Parcel source) {
            return new TrackContext(source);
        }

        public TrackContext[] newArray(int size) {
            return new TrackContext[size];
        }
    };
}
