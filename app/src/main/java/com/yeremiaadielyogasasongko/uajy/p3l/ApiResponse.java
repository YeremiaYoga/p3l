package com.yeremiaadielyogasasongko.uajy.p3l;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("data")
    @Expose
    private List<MenuDao> menuDaoList =null;

    @SerializedName("message")
    @Expose
    private String message;


    public List<MenuDao> getMenuDaoList() {
        return menuDaoList;
    }

    public void setMenuDaoList(List<MenuDao> menuDaoList) {
        this.menuDaoList = menuDaoList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
