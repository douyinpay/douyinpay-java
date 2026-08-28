package com.douyinpay.api.payscore.models;

import com.google.gson.annotations.SerializedName;

// 服务时间段
public class TimeRange {
    // 字段含义：服务开始时间。
    // 格式规则：string[14]，格式为：yyyyMMddHHmmss。
    // 业务规则：用户下单时确认的服务开始时间（比如用户今天下单，明天开始接受服务，这里指的是明天的服务开始时间）。
    // 示例：20220208060910。
    @SerializedName("start_time")
    private String startTime;
    // 字段含义：服务开始时间备注。
    // 格式规则：string[1,20]。
    // 业务规则：服务开始时间有填时，可填写服务开始时间备注。
    // 示例：开始租借日期。
    @SerializedName("start_time_remark")
    private String startTimeRemark;
    // 字段含义：服务结束时间。
    // 格式规则：string[14]，格式为：yyyyMMddHHmmss。
    // 业务规则：用户享受服务的完成时间。
    // 示例：20220208060910。
    @SerializedName("end_time")
    private String endTime;
    // 字段含义：服务结束时间备注。
    // 格式规则：string[1,20]。
    // 业务规则：服务结束时间有填时，可填写服务结束时间备注。
    // 示例：结束租借日期。
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
