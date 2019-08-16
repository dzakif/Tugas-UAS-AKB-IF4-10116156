package com.example.mypersonalapps;
/**
 * Nama : Dzaki Fakhruddin
 * NIM : 10116156
 * Kelas : AKB 4
 * Waktu Pengerjaan : 16 Agustus 2019
 */
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {
    private List<FriendModel> friends;
    private OnCallbackListener listener;

    public MainRecyclerAdapter(List<FriendModel> friends){
        this.friends=friends;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewtype){
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_friend, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        FriendModel friend=friends.get(position);
        holder.textViewNama.setText(friend.getNama());
        holder.textViewNim.setText(friend.getNim());
    }

    @Override
    public int getItemCount(){
        return friends.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener){
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewNama;
        TextView textViewNim;

        public ViewHolder (View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            textViewNama = itemView.findViewById(R.id.nama);
            textViewNim = itemView.findViewById(R.id.nimfriend);
        }

        @Override
        public void onClick(View v){
            if (listener != null){
                listener.onClick(friends.get(getAdapterPosition()));
            }
        }
    }
    public interface OnCallbackListener{
        void onClick(FriendModel user);
    }
}
