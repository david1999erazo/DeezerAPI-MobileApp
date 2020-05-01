package appmoviles.com.deezerapp.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Track {

    private ArrayList<SongObject> data;

    public Track(ArrayList<SongObject> data) {
        this.data = data;
    }

    public Track() {
    }

    public ArrayList<SongObject> getData() {
        return data;
    }

    public void setData(ArrayList<SongObject> data) {
        this.data = data;
    }
}
