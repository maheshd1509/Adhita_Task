package in.mahesh.adhita_task;

import java.io.Serializable;

/**
 * Created by mahesh on 6/11/17.
 */

public class Weather implements Serializable {

    String mMain,mDescription;

    public Weather(String mMain, String mDescription) {
        this.mMain = mMain;
        this.mDescription = mDescription;
    }

    public String getmMain() {
        return mMain;
    }

    public void setmMain(String mMain) {
        this.mMain = mMain;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
