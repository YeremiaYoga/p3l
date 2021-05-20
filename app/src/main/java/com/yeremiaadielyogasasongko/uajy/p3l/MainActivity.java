package com.yeremiaadielyogasasongko.uajy.p3l;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private ImageView scanbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanbtn = findViewById(R.id.ScanBtn);
        setupfragment();

        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, ScanActivity.class), 420);

            }
        });
    }
    public void setupfragment(){

        MenuFragment menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerview, menuFragment).commit();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 420) {
            if(resultCode == Activity.RESULT_OK) {
                try {

                    String _qrResult = data.getStringExtra("qrResult");
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<GedangResponse> add = apiService.createPesanan(_qrResult);


                    add.enqueue(new Callback<GedangResponse>() {
                        @Override
                        public void onResponse(Call<GedangResponse> call, Response<GedangResponse> response) {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<GedangResponse> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Kesalahan jaringan", Toast.LENGTH_SHORT).show();
                            Log.d("sangar", "onFailure: "+ t.getMessage());

                        }
                    });

                }
                catch (Exception e) {
                    Toast.makeText(this, "QR Code Tidak Valid", Toast.LENGTH_SHORT).show();


                }

            }

        }

    }
}