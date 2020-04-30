package appmoviles.com.deezerapp.model;

import java.io.Serializable;

public class SongObject implements Serializable {

    private String id, title,duration,link,time_add;
    private Artist artist;
    private Album album;


    public SongObject(String id, String title, String duration, String link, String time_add, Artist artist, Album album) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.link = link;
        this.time_add = time_add;
        this.artist = artist;
        this.album = album;
    }

    public SongObject() {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime_add() {
        return time_add;
    }

    public void setTime_add(String time_add) {
        this.time_add = time_add;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
