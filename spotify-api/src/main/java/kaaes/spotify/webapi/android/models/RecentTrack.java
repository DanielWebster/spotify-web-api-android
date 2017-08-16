package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RecentTrack implements Parcelable {

    public Track track;
    public TrackContext context;
    public String played_at;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.track, 0);
        dest.writeParcelable(this.context, 0);
        dest.writeString(this.played_at);
    }

    public RecentTrack() {
    }

    protected RecentTrack(Parcel in) {
        this.track = in.readParcelable(Track.class.getClassLoader());
        this.context = in.readParcelable(TrackContext.class.getClassLoader());
        this.played_at = in.readString();
    }

    public static final Parcelable.Creator<RecentTrack> CREATOR = new Parcelable.Creator<RecentTrack>() {
        public RecentTrack createFromParcel(Parcel source) {
            return new RecentTrack(source);
        }

        public RecentTrack[] newArray(int size) {
            return new RecentTrack[size];
        }
    };
}
