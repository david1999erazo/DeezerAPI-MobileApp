package appmoviles.com.deezerapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.model.PlayListObject;
import appmoviles.com.deezerapp.view.activity_playlistN;

public class AdapterPlayLists extends RecyclerView.Adapter<AdapterPlayLists.ViewHolderPlayLists> {


    ArrayList<PlayListObject> listObjectOfplaylists;

    public AdapterPlayLists(ArrayList<PlayListObject> listObjectOfplaylists) {
        this.listObjectOfplaylists = listObjectOfplaylists;
       }

    @Override
    public ViewHolderPlayLists onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_playlist_main, parent, false);
        ViewHolderPlayLists viewGViewHolderPlayLists = new ViewHolderPlayLists(contactView);
        return viewGViewHolderPlayLists;
    }

    @Override
    public void onBindViewHolder(AdapterPlayLists.ViewHolderPlayLists holder, int position) {

        PlayListObject playListObject = listObjectOfplaylists.get(position);

        /*
        TextView nameList = holder.namePlayListTV;
        TextView nameCreator = holder.nameCreatorTV;
        TextView numberTracks = holder.numberOfsongsTV;
        ImageView imageView = holder.imageIV;
        */


        holder.namePlayListTV.setText(listObjectOfplaylists.get(position).getTitle());
        holder.nameCreatorTV.setText(listObjectOfplaylists.get(position).getUser().getName());
        holder.numberOfsongsTV.setText(listObjectOfplaylists.get(position).getNb_tracks()+"");
        Glide.with(holder.itemView).load(playListObject.getPicture_small()).centerCrop().into(holder.imageIV);


        /*
        nameList.setText(playListObject.getTitle());
        nameCreator.setText(playListObject.getUser().getName());
        numberTracks.setText(playListObject.getNb_tracks()+"");

        */

        //Log.e(">>>",""+listObjectOfplaylists.get(position).getTitle());

        //Metodo para abrar playListObject
        holder.itemView.setOnClickListener(
                (v)->{
                    Intent i = new Intent ( holder.itemView.getContext(), activity_playlistN.class);
                    i.putExtra("id", listObjectOfplaylists.get(position).getId()+"");
                    //Log.e("ADAPTER id lista",""+listObjectOfplaylists.get(position).getId());
                    holder.itemView.getContext().startActivity(i);
                }

        );


    }

    @Override
    public int getItemCount() {

        return listObjectOfplaylists.size();
    }


    public class ViewHolderPlayLists extends RecyclerView.ViewHolder {

        public TextView namePlayListTV, nameCreatorTV, numberOfsongsTV;
        public ImageView imageIV;

        public ViewHolderPlayLists(View itemView) {
            super(itemView);
            //Hacer referencia a los componentes que tengamos

            namePlayListTV = (TextView) itemView.findViewById(R.id.namePlaylistTV);
            nameCreatorTV = (TextView) itemView.findViewById(R.id.nameTrackTV);
            numberOfsongsTV = (TextView) itemView.findViewById(R.id.yearTV);
            imageIV = itemView.findViewById(R.id.imageTrackV);


        }

    }

}
