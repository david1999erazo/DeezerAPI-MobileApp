package appmoviles.com.deezerapp.model;

public class Main {

    private PlayList[] data;

    public Main() {
    }

    public Main(PlayList[] data) {
        this.data = data;
    }

    public PlayList[] getData() {
        return data;
    }

    public void setData(PlayList[] data) {
        this.data = data;
    }
}
