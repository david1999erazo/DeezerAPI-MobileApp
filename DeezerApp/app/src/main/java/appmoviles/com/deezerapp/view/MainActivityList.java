package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.MainController;

public class MainActivityList extends AppCompatActivity {



    private TextView searchListET;
    private ImageButton btnSearch;
    private RecyclerView recyclerViewPlaylists;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchListET = findViewById(R.id.searchListET);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerViewPlaylists = findViewById(R.id.recycleListOfplayList);
        controller = new MainController(this);

    }

    public TextView getSearchListET() {
        return searchListET;
    }

    public ImageButton getBtnSearch() {
        return btnSearch;
    }

    public RecyclerView getRecyclerViewPlaylists() {
        return recyclerViewPlaylists;
    }

    public void setRecyclerViewPlaylists(RecyclerView recyclerViewPlaylists) {
        this.recyclerViewPlaylists = recyclerViewPlaylists;
    }
}
