package appmoviles.com.deezerapp.control;

import android.util.Log;
import android.view.View;

import appmoviles.com.deezerapp.R;
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
                            utilDomi.GETrequest(Constants.SEARCH_CALLBACK,"https://api.deezer.com/search/playlist?q=eminem");
                        }

                ).start();

                break;
        }
    }


    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
                Log.e(">>>",response);
        }

    }


}
