package com.leduoweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yangz on 2017/5/2.
 */

public class Suggestion {

    public Air air;

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public Drsg drsg;

    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    public class Sport {
        @SerializedName("txt")
        public String info;
    }

    public class Air{

        @SerializedName("brf")
        public String airQua;

        @SerializedName("txt")
        public String info;
    }

    public class Drsg{

        @SerializedName("brf")
        public String drsgQua;

        @SerializedName("txt")
        public String info;
    }
}
