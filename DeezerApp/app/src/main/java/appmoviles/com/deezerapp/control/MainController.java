package appmoviles.com.deezerapp.control;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import java.util.ArrayList;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.model.PlayListObject;
import appmoviles.com.deezerapp.model.PlaylistResult;
import appmoviles.com.deezerapp.util.Constants;
import appmoviles.com.deezerapp.util.HTTPSWebUtilDomi;
import appmoviles.com.deezerapp.adapter.AdapterPlayLists;
import appmoviles.com.deezerapp.view.MainActivityList;

public class MainController implements View.OnClickListener,HTTPSWebUtilDomi.OnResponseListener{

    private MainActivityList activityList;
    private HTTPSWebUtilDomi utilDomi;
    private AdapterPlayLists adapter;

    public MainController (MainActivityList activityList){

        this.activityList = activityList;
        this.activityList.getBtnSearch().setOnClickListener(this);
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSearch:
                String nameList = activityList.getSearchListET().getText().toString();


                new Thread(
                        ()->{
                            utilDomi.GETrequest(Constants.SEARCH_CALLBACK,"https://api.deezer.com/search/playlist?q="+nameList);
                        }

                ).start();

                break;
        }
    }


    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();

                PlaylistResult result = gson.fromJson(response, PlaylistResult.class);
                //Log.e(">>>",""+result.getData()[0].getTitle());
                //PlayListObject result = gson.fromJson(response, PlayListObject.class);
                //Mostrar información


                activityList.runOnUiThread(
                        ()-> {
                            ArrayList<PlayListObject> list = new ArrayList<>();

                            for( int i=0; i<result.getData().length;i++ ){
                                list.add(result.getData()[i]);
                            }

                            adapter = new AdapterPlayLists(list);
                            activityList.getRecyclerViewPlaylists().setAdapter(adapter);
                            activityList.getRecyclerViewPlaylists().setLayoutManager(new LinearLayoutManager(activityList));

                        }
                );
                break;

        }

    }


}
