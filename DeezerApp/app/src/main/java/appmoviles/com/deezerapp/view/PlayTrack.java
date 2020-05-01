package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.PlayTrackController;

public class PlayTrack extends AppCompatActivity {

    private WebView webV;
    private PlayTrackController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webV = findViewById(R.id.webV);
        controller = new PlayTrackController(this);

    }

    public WebView getWebV() {
        return webV;
    }

    public void setWebV(WebView webV) {
        this.webV = webV;
    }
}
