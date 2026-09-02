package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

/**
 * 门店信息（预留字段）。
 */
public class StoreInfo {
    // 字段含义：门店编号。
    // 格式规则：string[1,32]。
    // 示例：1089。
    @SerializedName("id")
    private String id;
    // 字段含义：门店名称。
    // 格式规则：string[1,256]。
    // 示例：辉煌购物中心店。
    @SerializedName("name")
    private String name;
    // 字段含义：地区编码。
    // 格式规则：string[1,32]。
    // 示例：100089。
    @SerializedName("area_code")
    private String areaCode;
    // 字段含义：详细地址。
    // 格式规则：string[1,512]。
    // 示例：北京市海淀区辉煌购物中心5层505。
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
