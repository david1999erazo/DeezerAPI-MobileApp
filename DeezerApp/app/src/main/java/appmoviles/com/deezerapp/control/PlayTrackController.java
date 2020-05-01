package appmoviles.com.deezerapp.control;

import appmoviles.com.deezerapp.view.PlayTrack;

public class PlayTrackController {

    private PlayTrack activity;

    public PlayTrackController(PlayTrack activity) {
        this.activity = activity;

        String url = activity.getIntent().getExtras().getString("url");
        activity.runOnUiThread(
                ()->{
                    activity.getWebV().loadUrl(url);
                    activity.finish();
                }
        );
    }
}
