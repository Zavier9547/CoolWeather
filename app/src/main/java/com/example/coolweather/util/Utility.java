package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 11070545 on 2017/9/25.
 */

public class Utility {

    /**
     * The method is used to handle the response data of provinces.
     *
     * @param response The JSON data from server.
     * @return Success or not.
     */
    public static boolean handleProvinceResponse(String response) {

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * The method is used to handle the response data of one specified province's cities.
     *
     * @param response   The JSON data from server.
     * @param provinceId ID of the specified province.
     * @return Success or not.
     */
    public static boolean handleCityResponse(String response, int provinceId) {

        if (!TextUtils.isEmpty(responcse)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
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

    /**
     * The method is used to handle the response data of one specified city's counties.
     *
     * @param response   The JSON data from server.
     * @param cityId     ID of the specified city.
     * @return Success or not.
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<=allCounties.length();i++) {
                    JSONObject countyObject = new JSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getInt("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
