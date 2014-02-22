package com.andy.routes.Library.network;

import com.andy.routes.Library.network.http.AsyncHttpClient;
import com.andy.routes.Library.network.http.AsyncHttpResponseHandler;
import com.andy.routes.Library.network.http.RequestParams;

public class RestClient {

    //region Constant Variables
    private static final String BASE_URL = "http://localhost:8000/api/1.0/";
    //endregion

    //region Variables
    private static AsyncHttpClient client = new AsyncHttpClient();
    //endregion

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        client.get(getFormattedUrl(url), params, handler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        client.post(getFormattedUrl(url), params, handler);
    }

    private static String getFormattedUrl(String url) {
        return BASE_URL + url;
    }
}
