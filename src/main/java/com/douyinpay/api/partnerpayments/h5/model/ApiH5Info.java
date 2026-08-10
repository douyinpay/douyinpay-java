package com.douyinpay.api.partnerpayments.h5.model;

import com.google.gson.annotations.SerializedName;

import static com.douyinpay.util.StringUtil.toIndentedString;

public class ApiH5Info {

    /**
     * 字段含义：场景类型。
     * 格式规则：字符串。
     * 业务规则：开放文档示例包含 iOS、Android、Wap、HarmonyOS。
     * 示例：Wap
     */
    @SerializedName("type")
    private String type;
    /**
     * 字段含义：应用名称。
     * 格式规则：字符串。
     * 业务规则：用于标识 H5 场景下的应用名称。
     * 示例：抖音
     */
    @SerializedName("app_name")
    private String appName;
    /**
     * 字段含义：网站URL。
     * 格式规则：HTTPS 外网可访问地址，且不能携带查询串。
     * 业务规则：用于标识 H5 场景下的网站地址。
     * 示例：https://douyinpay.com/
     */
    @SerializedName("app_url")
    private String appUrl;
    /**
     * 字段含义：iOS平台BundleID。
     * 格式规则：字符串。
     * 业务规则：用于标识 iOS 平台应用包信息。
     * 示例：com.test.testiOS
     */
    @SerializedName("bundle_id")
    private String bundleId;
    /**
     * 字段含义：Android平台PackageName。
     * 格式规则：字符串。
     * 业务规则：用于标识 Android 平台应用包名。
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
