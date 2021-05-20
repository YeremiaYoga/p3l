package com.yeremiaadielyogasasongko.uajy.p3l;

import com.google.gson.annotations.SerializedName;

public class WongDao {

    @SerializedName("id")
    private String id;

    @SerializedName("id_reservasi")
    private String id_reservasi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_reservasi() {
        return id_reservasi;
    }

    public void setId_reservasi(String id_reservasi) {
        this.id_reservasi = id_reservasi;
    }
}
