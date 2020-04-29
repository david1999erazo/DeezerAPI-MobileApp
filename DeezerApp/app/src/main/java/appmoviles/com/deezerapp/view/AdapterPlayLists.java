package appmoviles.com.deezerapp.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import appmoviles.com.deezerapp.R;
import appmoviles.com.deezerapp.model.PlayList;

public class AdapterPlayLists extends RecyclerView.Adapter<AdapterPlayLists.ViewHolderPlayLists> {


    ArrayList<PlayList> listOfplaylists;

    public AdapterPlayLists(ArrayList<PlayList> listOfplaylists) {
        this.listOfplaylists = listOfplaylists;

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

        PlayList playList = listOfplaylists.get(position);

        TextView nameList = holder.namePlayListTV;
        TextView nameCreator = holder.nameCreatorTV;
        TextView numberTracks = holder.numberOfsongsTV;
        ImageView imageView = holder.imageIV;



        holder.namePlayListTV.setText(listOfplaylists.get(position).getTitle());
        holder.nameCreatorTV.setText(listOfplaylists.get(position).getUser().getName());
        holder.numberOfsongsTV.setText(listOfplaylists.get(position).getNb_tracks()+"");


        nameList.setText(playList.getTitle());
        nameCreator.setText(playList.getUser().getName());
        numberTracks.setText(playList.getNb_tracks()+"");

        Glide.with(holder.itemView).load(playList.getPicture_small()).centerCrop().into(imageView);


        //Metodo para abrar playList
        holder.itemView.setOnClickListener(
                (v)->{
                    //Intent i = new Intent(holder.itemView.getContext(), )
                    //holder.itemView.getContext().startActivity(i);
                }

        );


    }

    @Override
    public int getItemCount() {

        return listOfplaylists.size();
    }

    public class ViewHolderPlayLists extends RecyclerView.ViewHolder {

        public TextView namePlayListTV, nameCreatorTV, numberOfsongsTV;
        public ImageView imageIV;

        public ViewHolderPlayLists(View itemView) {
            super(itemView);
            //Hacer referencia a los componentes que tengamos
            namePlayListTV = (TextView) itemView.findViewById(R.id.namePlaylistTV);
            nameCreatorTV = (TextView) itemView.findViewById(R.id.nameCreatorTV);
            numberOfsongsTV = (TextView) itemView.findViewById(R.id.numberOfsongsTV);
            imageIV = itemView.findViewById(R.id.imageIV);

        }

    }

    public ArrayList<PlayList> getListOfplaylists() {
        return listOfplaylists;
    }

    public void setListOfplaylists(ArrayList<PlayList> listOfplaylists) {
        this.listOfplaylists = listOfplaylists;
    }
}
