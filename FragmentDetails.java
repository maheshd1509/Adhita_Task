package in.mahesh.adhita_task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mahesh on 6/11/17.
 */

public class FragmentDetails extends Fragment {

    private TextView mTxt_CountryName,mTxt_CityName,mTxt_Temperature,mTxt_Description;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_details,null);

        mTxt_CountryName= (TextView) view.findViewById(R.id.txt_CountryName);
        mTxt_CityName= (TextView) view.findViewById(R.id.txt_CityName);
        mTxt_Temperature= (TextView) view.findViewById(R.id.txt_Tempertaure);
        mTxt_Description= (TextView) view.findViewById(R.id.txt_Description);


        Bundle bundle=getArguments();
        Country country= (Country) bundle.getSerializable("Data");

        mTxt_CountryName.setText(country.getmCountry());
        mTxt_CityName.setText(country.getmName());

        for (Temperature temperature:country.getmTemperatureList()){

            mTxt_Temperature.append("\n" + "Temp :" + temperature.getmTemperature() + "\n" +
                    "Temp_Min :" + temperature.getmTemperature_Min() + "\n" +
                    "Temp_Max" + temperature.getmTemperature_Max());
        }

        for (Weather weather:country.getmWeatherList()){

            mTxt_Description.setText("Main :" + weather.getmMain() + "\n" + "Description :" + weather.getmDescription());
        }


        return view;
    }
}
