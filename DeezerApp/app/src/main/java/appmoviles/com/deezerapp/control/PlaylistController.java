package appmoviles.com.deezerapp.control;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

import appmoviles.com.deezerapp.model.PlayList;
import appmoviles.com.deezerapp.util.Constants;
import appmoviles.com.deezerapp.util.HTTPSWebUtilDomi;
import appmoviles.com.deezerapp.view.AdapterPlayList;
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
                         //utilDomi.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/playlist/908622995");
                          Log.e("VERFICACION LLEGA ID",""+id);
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
                //Log.e(">>>",""+result.getTitle());



        }
    }
}
