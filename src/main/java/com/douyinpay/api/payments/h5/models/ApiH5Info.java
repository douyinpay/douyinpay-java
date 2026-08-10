package com.douyinpay.api.payments.h5.models;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiH5Info {

    /**
     * 字段含义：场景类型。
     * 格式规则：字符串。
     * 业务规则：用于区分 H5 拉起支付的场景类型。
     * 示例：iOS。
     */
    @SerializedName("type")
    private String type;
    /**
     * 字段含义：应用名称。
     * 格式规则：字符串。
     * 业务规则：用于标识发起 H5 支付的应用名称。
     * 示例：测试应用名称
     */
    @SerializedName("app_name")
    private String appName;
    /**
     * 字段含义：网站 URL。
     * 格式规则：URL。
     * 业务规则：用于标识发起 H5 支付的网站地址。
     * 示例：https://www.mock.com/
     */
    @SerializedName("app_url")
    private String appUrl;
    /**
     * 字段含义：iOS 平台 Bundle ID。
     * 格式规则：字符串。
     * 业务规则：用于标识 iOS 应用。
     */
    @SerializedName("bundle_id")
    private String bundleId;
    /**
     * 字段含义：Android 平台 PackageName。
     * 格式规则：字符串。
     * 业务规则：用于标识 Android 应用包名。
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
