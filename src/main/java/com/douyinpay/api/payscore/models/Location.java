package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 位置信息
public class Location {
    // 字段含义：服务开始地点。
    // 格式规则：string[1,50]。
    // 示例：美味餐厅。
    @SerializedName("start_location")
    private String startLocation;
    // 字段含义：服务结束地点。
    // 格式规则：string[1,50]。
    // 示例：美味餐厅。
    @SerializedName("end_location")
    private String endLocation;

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "startLocation='" + startLocation + '\'' +
                ", endLocation='" + endLocation + '\'' +
                '}';
    }
}
