package com.example.vo;

import lombok.Data;

import java.util.HashMap;

@Data
public class PieDataVO {
    private HashMap<String, String> data;

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
}
