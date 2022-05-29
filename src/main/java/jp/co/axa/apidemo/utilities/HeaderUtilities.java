package jp.co.axa.apidemo.utilities;

import org.springframework.http.HttpHeaders;

public class HeaderUtilities {
    public static HttpHeaders commonHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return headers;
    }

    public static HttpHeaders createdHeaders(String locationValue){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, locationValue);
        return headers;
    }
}
