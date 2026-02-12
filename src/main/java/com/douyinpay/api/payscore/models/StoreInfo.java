package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/** 门店信息 （预留字段）*/
public class StoreInfo {
    /**
     * 门店id
     */
    @SerializedName("id")
    private String id;
    /**
     * 门店名称
     */
    @SerializedName("name")
    private String name;
    /**
     * 门店编码
     */
    @SerializedName("area_code")
    private String areaCode;
    /**
     * 门店地址
     */
    @SerializedName("address")
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
