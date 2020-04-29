package appmoviles.com.deezerapp.model;

import java.io.Serializable;

public class PlayListObject implements Serializable {

    private long id;
    private String title; //Nombre de la lista
    private long nb_tracks; //Cantidad de canciones
    private String picture_small; //Imagen de la lista
    private User user; //Creador de la lista


    public PlayListObject() {
    }

    public PlayListObject(long id, String title, long nb_tracks, String picture_small, User user) {
        this.id = id;
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.picture_small = picture_small;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(long nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }
}
