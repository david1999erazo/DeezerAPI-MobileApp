package appmoviles.com.deezerapp.model;

public class PlayList {

    private String id,title,description, picture_medium;
    private int nb_tracks;
    private Track tracks;

    public PlayList(String id, String title, String description, String picture_medium, int nb_tracks, Track tracks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.picture_medium = picture_medium;
        this.nb_tracks = nb_tracks;
        this.tracks = tracks;
    }

    public PlayList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_medium() {
        return picture_medium;
    }

    public void setPicture_medium(String picture_medium) {
        this.picture_medium = picture_medium;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public Track getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }
}
