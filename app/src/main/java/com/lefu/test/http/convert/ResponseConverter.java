package com.lefu.test.http.convert;

import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author liufu on 2016/12/13.
 */

final class ResponseConverter implements Converter<ResponseBody, String> {
    private static final String TAG = "ResponseConverter";

    @Override
    public String convert(ResponseBody value) throws IOException {
        InputStreamReader reader = (InputStreamReader) value.charStream();
        StringBuffer sb = new StringBuffer();
        char[] buffer = new char[128];
        int len = -1;
        if ((len = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, len);
        }
        Log.d(TAG, sb.toString());
        return sb.toString();
    }
}
