package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.MainController;
import appmoviles.com.deezerapp.model.PlayList;

public class MainActivityList extends AppCompatActivity {



    private AdapterPlayLists adapterPlayLists;
    private TextView searchListET;
    private ImageButton btnSearch;
    private ArrayList<PlayList> listOfplaylists;
    private RecyclerView recyclerViewPlaylists;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listOfplaylists = new ArrayList<>();
        recyclerViewPlaylists = (RecyclerView) findViewById(R.id.listOfplayList);
        recyclerViewPlaylists.setLayoutManager(new LinearLayoutManager(this));

        adapterPlayLists = new AdapterPlayLists(listOfplaylists);
        recyclerViewPlaylists.setAdapter(adapterPlayLists);
        adapterPlayLists.notifyDataSetChanged();


        searchListET = findViewById(R.id.searchListET);
        btnSearch = findViewById(R.id.btnSearch);

        controller = new MainController(this);

    }

    public ArrayList<PlayList> getListOfplaylists() {
        return listOfplaylists;
    }

    public void setListOfplaylists(ArrayList<PlayList> listOfplaylists) {
        this.listOfplaylists = listOfplaylists;
    }

    public TextView getSearchListET() {
        return searchListET;
    }

    public ImageButton getBtnSearch() {
        return btnSearch;
    }
}
