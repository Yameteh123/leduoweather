package com.leduoweather.android.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.leduoweather.android.db.City;
import com.leduoweather.android.db.County;
import com.leduoweather.android.db.Province;
import com.leduoweather.android.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yangz on 2017/5/2.
 */

public class Utility {

    private static final String TAG = "Utility";

    public static boolean handleProvinceResonse(String response){
        Log.d(TAG, "response: " + response);
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allDatas = new JSONArray(response);
                for (int i = 0; i < allDatas.length(); i++) {
                    JSONObject object = allDatas.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(object.getString("name"));
                    province.setProvinceCode(object.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResonse(String response, int provinceId){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allDatas = new JSONArray(response);
                for (int i = 0; i < allDatas.length(); i++) {
                    JSONObject object = allDatas.getJSONObject(i);
                    City city = new City();
                    city.setCityName(object.getString("name"));
                    city.setCityCode(object.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResonse(String response, int cityId){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allDatas = new JSONArray(response);
                for (int i = 0; i < allDatas.length(); i++) {
                    JSONObject object = allDatas.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(object.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(object.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return  new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
