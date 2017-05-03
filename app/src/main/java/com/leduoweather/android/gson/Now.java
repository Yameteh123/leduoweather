package com.leduoweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yangz on 2017/5/2.
 */

public class Now {

    @SerializedName("tmp")
    public String temprature;

    @SerializedName("cond")
    public More more;

    public class More {

        public String code;

        @SerializedName("txt")
        public String weatherInfo;
    }
}
