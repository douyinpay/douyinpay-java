package com.douyinpay.api;

import com.douyinpay.component.http.HttpMethod;
import java.util.Map;

/** Multipart request whose meta JSON is the signed request body. */
public class DouyinpayMultipartRequest extends DouyinpayRequest {
    private final String meta;
    private final String fileName;
    private final String fileType;
    private final byte[] file;

    public DouyinpayMultipartRequest(String url, String path, Map<String, String> headers,
                                     String meta, String fileName, String fileType, byte[] file) {
        super(HttpMethod.POST, url, path, headers, meta);
        this.meta = meta;
        this.fileName = fileName;
        this.fileType = fileType;
        this.file = file;
    }
    public String getMeta() { return meta; }
    public String getFileName() { return fileName; }
    public String getFileType() { return fileType; }
    public byte[] getFile() { return file; }
}
