package com.example.mediapembelajarandbms.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mediapembelajarandbms.DataLatihan.ItemSoal;
import com.example.mediapembelajarandbms.R;

import java.util.ArrayList;

public class AdapterSoal extends RecyclerView.Adapter<AdapterSoal.ListViewHolder> {
    public static ArrayList<ItemSoal> listSoal;
    private LayoutInflater inflater;


    public AdapterSoal(Context context, ArrayList<ItemSoal> list) {
        inflater = LayoutInflater.from(context);
        listSoal = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_soal, parent, false);
        return new AdapterSoal.ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        final ItemSoal ItemSoal = listSoal.get(position);
        holder.tv_soal.setText(ItemSoal.getTxtSoal());
        holder.tv_nomor.setText(ItemSoal.getTxtNo());
        holder.editText.setText(listSoal.get(position).getEditTextValue());

    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_soal;
        TextView tv_nomor;
        EditText editText;
        Button save;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            save = itemView.findViewById(R.id.btnSave);
            tv_soal = itemView.findViewById(R.id.tvSoal);
            tv_nomor = itemView.findViewById(R.id.nomor);
            editText = itemView.findViewById(R.id.edtJawaban);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    listSoal.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }
}
