package com.douyinpay.api.payments.contractorder.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;
public class ApiH5Info {

    /**
     * 字段含义：场景类型。
     * 格式规则：字符串。
     * 业务规则：当前接口文档未明确说明 type 字段的取值和使用规则，暂保留该字段以兼容现有模型。
     * 示例：
     */
    @SerializedName("type")
    private String type;
    /**
     * 字段含义：应用名称。
     * 格式规则：字符串。
     * 业务规则：当前接口文档未明确说明 app_name 字段的使用规则，暂保留该字段以兼容现有模型。
     * 示例：
     */
    @SerializedName("app_name")
    private String appName;
    /**
     * 字段含义：网站URL。
     * 格式规则：URL 字符串。
     * 业务规则：当前接口文档未明确说明 app_url 字段的使用规则，暂保留该字段以兼容现有模型。
     * 示例：
     */
    @SerializedName("app_url")
    private String appUrl;
    /**
     * 字段含义：iOS 平台 Bundle ID。
     * 格式规则：字符串。
     * 业务规则：当前接口文档未明确说明 bundle_id 字段的使用规则，暂保留该字段以兼容现有模型。
     * 示例：
     */
    @SerializedName("bundle_id")
    private String bundleId;
    /**
     * 字段含义：Android 平台 Package Name。
     * 格式规则：字符串。
     * 业务规则：当前接口文档未明确说明 package_name 字段的使用规则，暂保留该字段以兼容现有模型。
     * 示例：
     */
    @SerializedName("package_name")
    private String packageName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class H5Info {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    appName: ").append(toIndentedString(appName)).append("\n");
        sb.append("    appUrl: ").append(toIndentedString(appUrl)).append("\n");
        sb.append("    bundleId: ").append(toIndentedString(bundleId)).append("\n");
        sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
