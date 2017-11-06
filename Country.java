package in.mahesh.adhita_task;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mahesh on 6/11/17.
 */

public class Country implements Serializable{

    String mName,mCountry;
    ArrayList<Temperature> mTemperatureList;
    ArrayList<Weather> mWeatherList;

    public Country(String mName, String mCountry) {
        this.mName = mName;
        this.mCountry = mCountry;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public ArrayList<Temperature> getmTemperatureList() {
        return mTemperatureList;
    }

    public void setmTemperatureList(ArrayList<Temperature> mTemperatureList) {
        this.mTemperatureList = mTemperatureList;
    }

    public ArrayList<Weather> getmWeatherList() {
        return mWeatherList;
    }

    public void setmWeatherList(ArrayList<Weather> mWeatherList) {
        this.mWeatherList = mWeatherList;
    }
}
