package appmoviles.com.deezerapp.model;

public class PlaylistResult {

    private PlayListObject[] data;

    public PlaylistResult() {
    }

    public PlaylistResult(PlayListObject[] data) {
        this.data = data;
    }

    public PlayListObject[] getData() {
        return data;
    }

    public void setData(PlayListObject[] data) {
        this.data = data;
    }
}
