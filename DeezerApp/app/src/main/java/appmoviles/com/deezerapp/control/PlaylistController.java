package appmoviles.com.deezerapp.control;

import android.util.Log;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import appmoviles.com.deezerapp.model.PlayList;
import appmoviles.com.deezerapp.util.Constants;
import appmoviles.com.deezerapp.util.HTTPSWebUtilDomi;
import appmoviles.com.deezerapp.adapter.AdapterPlayList;
import appmoviles.com.deezerapp.view.activity_playlistN;

public class PlaylistController implements HTTPSWebUtilDomi.OnResponseListener {

    private HTTPSWebUtilDomi utilDomi;
    private activity_playlistN activity;
    private AdapterPlayList adapter;


    public PlaylistController(activity_playlistN activity) {
        this.activity = activity;

        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

        adapter = new AdapterPlayList();
        activity.getTracksLV().setAdapter(adapter);

        String id = this.activity.getIntent().getExtras().getString("id");
        new Thread(
                ()->{
                         utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/playlist/"+id);
                }
        ).start();

    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch(callbackID){
            case Constants.SEARCH_CALLBACK:
                adapter.clear();
                Gson gson = new Gson();
                PlayList result = gson.fromJson(response, PlayList.class);

                activity.runOnUiThread(
                        ()->{
                            activity.getNamePlaylistTV().setText(result.getTitle());
                            activity.getDescriptionTV().setText(result.getDescription());
                            activity.getInfoPlaylistTV().setText(result.getNb_tracks()+" canciones");
                            adapter.getListOfSongs().addAll(result.getTracks().getData());
                            adapter.notifyDataSetChanged();
                            Glide.with(activity).load(
                                    result.getPicture_medium()
                            ).centerCrop().into(activity.getImage_playlistV());
                        }

                );



        }
    }
}
