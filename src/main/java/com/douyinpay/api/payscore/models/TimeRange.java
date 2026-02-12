package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 服务时间段
public class TimeRange {
    // 服务开始时间
    @SerializedName("start_time")
    private String startTime;
    // 服务开始时间备注
    @SerializedName("start_time_remark")
    private String startTimeRemark;
    // 服务结束时间
    @SerializedName("end_time")
    private String endTime;
    // 服务结束时间备注
    @SerializedName("end_time_remark")
    private String endTimeRemark;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeRemark() {
        return startTimeRemark;
    }

    public void setStartTimeRemark(String startTimeRemark) {
        this.startTimeRemark = startTimeRemark;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeRemark() {
        return endTimeRemark;
    }

    public void setEndTimeRemark(String endTimeRemark) {
        this.endTimeRemark = endTimeRemark;
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "startTime='" + startTime + '\'' +
                ", startTimeRemark='" + startTimeRemark + '\'' +
                ", endTime='" + endTime + '\'' +
                ", endTimeRemark='" + endTimeRemark + '\'' +
                '}';
    }
}
