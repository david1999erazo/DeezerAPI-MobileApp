package appmoviles.com.deezerapp.model;

import java.io.Serializable;

public class PlayList implements Serializable {

    private long id;
    private String title; //Nombre de la lista
    private long numTracks; //Cantidad de canciones
    private String imageList; //Imagen de la lista
    private User user; //Creador de la lista


    public PlayList() {
    }

    public PlayList(long id, String title, long numTracks, String imageList, User user) {
        this.id = id;
        this.title = title;
        this.numTracks = numTracks;
        this.imageList = imageList;
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

    public long getNumTracks() {
        return numTracks;
    }

    public void setNumTracks(long numTracks) {
        this.numTracks = numTracks;
    }

    public String getImageList() {
        return imageList;
    }

    public void setImageList(String imageList) {
        this.imageList = imageList;
    }
}
