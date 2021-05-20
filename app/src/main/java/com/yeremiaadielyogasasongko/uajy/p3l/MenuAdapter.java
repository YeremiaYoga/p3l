package com.yeremiaadielyogasasongko.uajy.p3l;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter <MenuAdapter.MenuViewHolder> {
    private List<MenuDao> dataList;
    private List<MenuDao> filteredDataList;

    public MenuAdapter(List<MenuDao> dataList) {
        this.dataList = dataList;
        this.filteredDataList = dataList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_menu, parent, false);
        return new MenuViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        final MenuDao brg = filteredDataList.get(position);
        holder.twNama.setText(brg.getNama_menu());
        holder.twDeskripsi.setText(brg.getDeskripsi_menu());
        holder.twHarga.setText(brg.getHarga());
        Log.d("string", "onBindViewHolder: " + brg.getNama_menu());



    }

    @Override
    public int getItemCount() {
        return  filteredDataList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private TextView twNama, twDeskripsi,twHarga;


        public MenuViewHolder(@NonNull View itemView){
            super(itemView);
            twNama = itemView.findViewById(R.id.judulmenu);
            twDeskripsi = itemView.findViewById(R.id.deskripsimenu);
            twHarga =itemView.findViewById(R.id.harga);

        }
    }
}
