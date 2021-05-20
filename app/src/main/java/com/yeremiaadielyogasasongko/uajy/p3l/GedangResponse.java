package com.yeremiaadielyogasasongko.uajy.p3l;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GedangResponse {

    @SerializedName("data")
    @Expose
    private WongDao wongDao = null;

    @SerializedName("message")
    @Expose
    private String message;

    public WongDao getWongDao() {
        return wongDao;
    }

    public void setWongDao(WongDao wongDao) {
        this.wongDao = wongDao;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
