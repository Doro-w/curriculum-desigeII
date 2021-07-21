package com.example.vo;

import lombok.Data;

import java.util.List;

@Data
public class PieVO {
    private List<String> pieName;
    private List<Object> DataList;

    public List<String> getPieName() {
        return pieName;
    }

    public void setPieName(List<String> pieName) {
        this.pieName = pieName;
    }


    public List<Object> getDataList() {
        return DataList;
    }

    public void setDataList(List<Object> dataList) {
        DataList = dataList;
    }
}
