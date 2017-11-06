package in.mahesh.adhita_task;

import java.io.Serializable;

/**
 * Created by mahesh on 6/11/17.
 */

public class Temperature implements Serializable {

    String mTemperature,mTemperature_Min,mTemperature_Max;

    public Temperature(String mTemperature, String mTemperature_Min, String mTemperature_Max) {
        this.mTemperature = mTemperature;
        this.mTemperature_Min = mTemperature_Min;
        this.mTemperature_Max = mTemperature_Max;
    }

    public String getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmTemperature_Min() {
        return mTemperature_Min;
    }

    public void setmTemperature_Min(String mTemperature_Min) {
        this.mTemperature_Min = mTemperature_Min;
    }

    public String getmTemperature_Max() {
        return mTemperature_Max;
    }

    public void setmTemperature_Max(String mTemperature_Max) {
        this.mTemperature_Max = mTemperature_Max;
    }
}
