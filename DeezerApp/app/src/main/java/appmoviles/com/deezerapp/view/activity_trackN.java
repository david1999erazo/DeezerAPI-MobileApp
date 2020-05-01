package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.TrackController;

public class activity_trackN extends AppCompatActivity {


    private ImageView imageTrack;
    private TextView nameTrackTV;
    private TextView artistTrackTV;
    private TextView albumTV;
    private TextView timeTrackTV;
    private Button listenBtn;

    private TrackController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_n);

        imageTrack = findViewById(R.id.imageTrackV);
        nameTrackTV = findViewById(R.id.nameTrackTV);
        artistTrackTV = findViewById(R.id.artistTrackTV);
        albumTV = findViewById(R.id.albumTV);
        timeTrackTV = findViewById(R.id.timeTrackTV);
        listenBtn = findViewById(R.id.listenBtn);

        controller = new TrackController(this);

    }

    public ImageView getImageTrack() {
        return imageTrack;
    }

    public void setImageTrack(ImageView imageTrack) {
        this.imageTrack = imageTrack;
    }

    public TextView getNameTrackTV() {
        return nameTrackTV;
    }

    public void setNameTrackTV(TextView nameTrackTV) {
        this.nameTrackTV = nameTrackTV;
    }

    public TextView getArtistTrackTV() {
        return artistTrackTV;
    }

    public void setArtistTrackTV(TextView artistTrackTV) {
        this.artistTrackTV = artistTrackTV;
    }

    public TextView getAlbumTV() {
        return albumTV;
    }

    public void setAlbumTV(TextView albumTV) {
        this.albumTV = albumTV;
    }

    public TextView getTimeTrackTV() {
        return timeTrackTV;
    }

    public void setTimeTrackTV(TextView timeTrackTV) {
        this.timeTrackTV = timeTrackTV;
    }

    public Button getListenBtn() {
        return listenBtn;
    }

    public void setListenBtn(Button listenBtn) {
        this.listenBtn = listenBtn;
    }
}
