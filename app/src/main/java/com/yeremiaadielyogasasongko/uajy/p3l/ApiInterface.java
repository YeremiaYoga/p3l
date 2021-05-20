package com.yeremiaadielyogasasongko.uajy.p3l;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("menu/tampil")
    Call<ApiResponse> getAllMenu();



    @POST("pesanan/tambah")
    @FormUrlEncoded
    Call<GedangResponse> createPesanan(@Field("id_reservasi") String idreservasi);







}
