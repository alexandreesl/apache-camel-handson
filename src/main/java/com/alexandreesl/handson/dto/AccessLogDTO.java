package com.alexandreesl.handson.dto;

/**
 * Created by alexandrelourenco on 30/06/17.
 */
public class AccessLogDTO {

    private String ip;

    private String url;

    private String httpMethod;

    private long duration;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(ip);
        buffer.append(",");
        buffer.append(url);
        buffer.append(",");
        buffer.append(httpMethod);
        buffer.append(",");
        buffer.append(duration);
        buffer.append("]");

        return buffer.toString();

    }
}
