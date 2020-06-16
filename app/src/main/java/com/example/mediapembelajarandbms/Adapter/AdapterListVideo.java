package com.example.mediapembelajarandbms.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mediapembelajarandbms.DataMateri.ItemData;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class AdapterListVideo extends RecyclerView.Adapter<AdapterListVideo.ListViewHolder> {
    private ArrayList<ItemData> listMateri;

    public AdapterListVideo(ArrayList<ItemData> list) {
        this.listMateri = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_materi, parent, false);
        return new AdapterListVideo.ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ItemData itemData = listMateri.get(position);
        Glide.with(holder.itemView.getContext())
                .load(itemData.getFoto())
                .into(holder.fotoMateri);
        holder.JudulMateri.setText(itemData.getJudul());
    }

    @Override
    public int getItemCount() {
        return listMateri.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fotoMateri;
        TextView JudulMateri;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoMateri = itemView.findViewById(R.id.fotoMateri);
            JudulMateri = itemView.findViewById(R.id.judulMateri);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(itemView.getContext(), Tampil_Video.class);
            switch (position) {
                case 0:
                    intent.putExtra("requestCode", 0);
                    itemView.getContext().startActivity(intent);
                    break;
                case 1:
                    intent.putExtra("requestCode", 1);
                    itemView.getContext().startActivity(intent);
                    break;
                case 2:
                    intent.putExtra("requestCode", 2);
                    itemView.getContext().startActivity(intent);
                    break;
                case 3:
                    intent.putExtra("requestCode", 3);
                    itemView.getContext().startActivity(intent);
                    break;
                case 4:
                    intent.putExtra("requestCode", 4);
                    itemView.getContext().startActivity(intent);
                    break;
                case 5:
                    intent.putExtra("requestCode", 5);
                    itemView.getContext().startActivity(intent);
                    break;
                case 6:
                    intent.putExtra("requestCode", 6);
                    itemView.getContext().startActivity(intent);
                    break;
                case 7:
                    intent.putExtra("requestCode", 7);
                    itemView.getContext().startActivity(intent);
                    break;
                case 8:
                    intent.putExtra("requestCode", 8);
                    itemView.getContext().startActivity(intent);
                    break;
                case 9:
                    intent.putExtra("requestCode", 9);
                    itemView.getContext().startActivity(intent);
                    break;
                case 10:
                    intent.putExtra("requestCode", 10);
                    itemView.getContext().startActivity(intent);
                    break;
                default:
                    intent.putExtra("requestCode", 11);
                    itemView.getContext().startActivity(intent);
                    break;
            }
        }
    }
}
