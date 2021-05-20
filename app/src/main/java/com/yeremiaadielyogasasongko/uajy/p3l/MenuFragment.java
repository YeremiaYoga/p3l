package com.yeremiaadielyogasasongko.uajy.p3l;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter menuadapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.recyclermenu);
        setupdata();
        // Inflate the layout for this fragment
        return view;
    }

    public void setupdata() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.getAllMenu();

        call.enqueue(new Callback<ApiResponse>(){
            @Override
            public void onResponse(Call<ApiResponse>call, Response<ApiResponse> response){
                menuadapter = new MenuAdapter(response.body().getMenuDaoList());
                recyclerView.setAdapter(menuadapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                Log.d("string", "onResponse: " + response.message());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("string", "onResponse: " + t.getMessage());
            }
        });
    }
}