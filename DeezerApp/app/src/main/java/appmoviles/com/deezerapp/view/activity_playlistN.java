package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.PlaylistController;

public class activity_playlistN extends AppCompatActivity {

    private ImageView image_playlistV;
    private TextView namePlaylistTV;
    private TextView descriptionTV;
    private TextView infoPlaylistTV;
    private ListView tracksLV;

    private PlaylistController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_n);

        image_playlistV = findViewById(R.id.image_playlistV);
        namePlaylistTV = findViewById(R.id.namePlaylistTV);
        descriptionTV = findViewById(R.id.descriptionTV);
        infoPlaylistTV = findViewById(R.id.infoPlaylistTV);
        tracksLV = findViewById(R.id.tracksLV);

        controller = new PlaylistController(this);
    }

    public ImageView getImage_playlistV() {
        return image_playlistV;
    }

    public void setImage_playlistV(ImageView image_playlistV) {
        this.image_playlistV = image_playlistV;
    }

    public TextView getNamePlaylistTV() {
        return namePlaylistTV;
    }

    public void setNamePlaylistTV(TextView namePlaylistTV) {
        this.namePlaylistTV = namePlaylistTV;
    }

    public TextView getDescriptionTV() {
        return descriptionTV;
    }

    public void setDescriptionTV(TextView descriptionTV) {
        this.descriptionTV = descriptionTV;
    }

    public TextView getInfoPlaylistTV() {
        return infoPlaylistTV;
    }

    public void setInfoPlaylistTV(TextView infoPlaylistTV) {
        this.infoPlaylistTV = infoPlaylistTV;
    }

    public ListView getTracksLV() {
        return tracksLV;
    }

    public void setTracksLV(ListView tracksLV) {
        this.tracksLV = tracksLV;
    }
}
