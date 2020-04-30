package appmoviles.com.deezerapp.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Date;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.model.SongObject;

public class AdapterPlayList extends BaseAdapter {

    private ArrayList<SongObject> listOfSongs;

    public AdapterPlayList() {
        this.listOfSongs = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return listOfSongs.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfSongs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addSong(SongObject song ){
        listOfSongs.add(song);
        notifyDataSetChanged();
    }

    public void clear(){
        listOfSongs.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.item_playlist_track,null,false);

        TextView nameTrack = item.findViewById(R.id.nameTrackTV);
        TextView nameArtist = item.findViewById(R.id.namePlaylistTV);
        TextView yearTrack = item.findViewById(R.id.yearTV);
        ImageView imageTrack = item.findViewById(R.id.imageTrackV);

        nameTrack.setText(listOfSongs.get(position).getTitle());
        nameArtist.setText(listOfSongs.get(position).getArtist().getName());
        yearTrack.setText(new Date(Long.parseLong(listOfSongs.get(position).getTime_add())).toString());

        Glide.with(item).load(
                listOfSongs.get(position).getAlbum().getCover_small()
        ).centerCrop().into(imageTrack);


        item.setOnClickListener(
                (v)->{
                    Intent i = new Intent(item.getContext(), activity_trackN.class);

                    item.getContext().startActivity(i);
                }
        );


        return item;
    }
}
