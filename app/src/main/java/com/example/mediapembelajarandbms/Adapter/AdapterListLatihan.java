package com.example.mediapembelajarandbms.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.DataLatihan.ItemDataLatihan;
import com.example.mediapembelajarandbms.Latihan.TampilLatihan;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class AdapterListLatihan extends RecyclerView.Adapter<AdapterListLatihan.ListViewHolder> {
    private ArrayList<ItemDataLatihan> listLatihan;

    public AdapterListLatihan(ArrayList<ItemDataLatihan> list) {
        this.listLatihan = list;
    }

    @NonNull
    @Override
    public AdapterListLatihan.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_latihan, parent, false);
        return new AdapterListLatihan.ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterListLatihan.ListViewHolder holder, final int position) {
        final ItemDataLatihan itemDataLatihan = listLatihan.get(position);
        holder.JudulLatihan.setText(itemDataLatihan.getJudul());
    }

    @Override
    public int getItemCount() {
        return listLatihan.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView JudulLatihan;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            JudulLatihan = itemView.findViewById(R.id.tvJudul);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            ItemDataLatihan itemDataLatihan = listLatihan.get(position);
            Intent intent = new Intent(itemView.getContext(), TampilLatihan.class);
//            itemView.getContext().startActivity(intent);
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
