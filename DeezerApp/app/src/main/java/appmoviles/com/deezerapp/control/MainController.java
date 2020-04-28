package appmoviles.com.deezerapp.control;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.model.Main;
import appmoviles.com.deezerapp.util.Constants;
import appmoviles.com.deezerapp.util.HTTPSWebUtilDomi;
import appmoviles.com.deezerapp.view.MainActivityList;

public class MainController implements View.OnClickListener,HTTPSWebUtilDomi.OnResponseListener{

    private MainActivityList activityList;
    private HTTPSWebUtilDomi utilDomi;

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
                //PlayList playList = gson.fromJson(response,PlayList.class);
                Main main = gson.fromJson(response, Main.class);

                Log.e(">>>",""+main.getData()[3].getTitle());

                /*
                for(int i=0; i<20; i++){
                    Log.e(">>>",""+main.getData()[i].getId());
                }*/

                //Log.e(">>>",""+data.getListOfPlayLists()[0].getTitle());
                //Log.e(">>>",response);
        }

    }


}
