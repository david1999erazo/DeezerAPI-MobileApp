package appmoviles.com.deezerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.control.MainController;

public class MainActivityList extends AppCompatActivity {


    private TextView searchListET;
    private ImageButton btnSearch;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchListET = findViewById(R.id.searchListET);
        btnSearch = findViewById(R.id.btnSearch);

        controller = new MainController(this);

    }


    public TextView getSearchListET() {
        return searchListET;
    }

    public ImageButton getBtnSearch() {
        return btnSearch;
    }
}
