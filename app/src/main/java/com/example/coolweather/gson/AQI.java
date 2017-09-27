package com.example.coolweather.gson;

/**
 * Created by 11070545 on 2017/9/27.
 */

public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
