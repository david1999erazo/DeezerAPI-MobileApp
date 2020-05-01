package appmoviles.com.deezerapp.control;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import appmoviles.com.deezerapp.model.SongObject;
import appmoviles.com.deezerapp.util.Constants;
import appmoviles.com.deezerapp.util.HTTPSWebUtilDomi;
import appmoviles.com.deezerapp.view.activity_trackN;

public class TrackController implements HTTPSWebUtilDomi.OnResponseListener {

    private activity_trackN activity;
    private HTTPSWebUtilDomi utilDomi;

    public TrackController(activity_trackN activity)  {
        this.activity = activity;

        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

        String id = this.activity.getIntent().getExtras().getString("id");
        new Thread(
                ()->{
                    utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/track/"+id);
                    Log.e(">>>Id Track que llega: ",""+id);
                }
        ).start();

       /*
        activity.getListenBtn().setOnClickListener(
                V->{
                    try{
                        String uri = "deezer://www.deezer.com/track/"+result.getLink();
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        activity.startActivity(intent);
                    }catch (Exception e){
                        /*
                        Integer intent = new Integer(activity, Play.class);
                        intent.putExtra("url",result.getLink());
                        activity.startActivity(intent);
                    }

                }

        );*/


    }

    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID){
            case Constants.SEARCH_CALLBACK:

                Gson gson = new Gson();
                SongObject result = gson.fromJson(response, SongObject.class);
                Log.e(">>>>Nombre canción",""+result.getTitle());

                activity.runOnUiThread(

                        ()->{
                            activity.getNameTrackTV().setText(result.getTitle());
                            activity.getAlbumTV().setText(result.getAlbum().getTitle());
                            activity.getArtistTrackTV().setText(result.getArtist().getName());
                            activity.getTimeTrackTV().setText(result.getDuration());

                            Glide.with(activity).load(
                                    result.getAlbum().getCover_medium()
                            ).centerCrop().into(activity.getImageTrack());
                        }
                );


            break;
        }




    }
}
