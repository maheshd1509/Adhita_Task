package in.mahesh.adhita_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText mEdtZipCode,mEdtCountryCode;
    private Button mBtnSubmit;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CountryAdapter mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtZipCode= (EditText) findViewById(R.id.edtZipCode);
        mEdtCountryCode= (EditText) findViewById(R.id.edtCountryCode);
        mBtnSubmit= (Button) findViewById(R.id.btnSubmit);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);



        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String zipCode=mEdtZipCode.getText().toString();
                String countryCode=mEdtCountryCode.getText().toString();

                String url="http://api.openweathermap.org/data/2.5/forecast?zip="+zipCode+","+countryCode+"&appid=89cfa1bf368ea27faf9e459eaaa0bff3";

                Log.d("Test","URL :" + url.toString());

                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, new JSONObject(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("Test","Response :" + response.toString());


                        try {

                            ArrayList<Temperature> mTemperatureList=new ArrayList<Temperature>();
                            JSONArray jList=response.getJSONArray("list");

                            for (int i=0;i<jList.length();i++)
                            {
                                JSONObject jsonObject=jList.getJSONObject(i);
                                JSONObject jMain=jsonObject.getJSONObject("main");
                                String Temp=jMain.getString("temp");
                                String Temp_Min=jMain.getString("temp_min");
                                String Temp_Max=jMain.getString("temp_max");
                                Temperature temperature=new Temperature(Temp,Temp_Min,Temp_Max);
                                mTemperatureList.add(temperature);


                                ArrayList<Weather> mWeatherList=new ArrayList<Weather>();
                                JSONArray jWeather=jsonObject.getJSONArray("weather");
                                for (int j=0;j<jWeather.length();j++)
                                {
                                    JSONObject jObject=jWeather.getJSONObject(j);
                                    String Main=jObject.getString("main");
                                    String Description=jObject.getString("description");
                                    Weather weather=new Weather(Main,Description);
                                    mWeatherList.add(weather);

                                }

                                ArrayList<Country> mCountryList=new ArrayList<Country>();
                                JSONObject jCity=response.getJSONObject("city");
                                String Name=jCity.getString("name");
                                String Country=jCity.getString("country");

                                Country country=new Country(Name,Country);
                                country.setmTemperatureList(mTemperatureList);
                                country.setmWeatherList(mWeatherList);
                                mCountryList.add(country);
                                mCountryAdapter=new CountryAdapter(MainActivity.this,mCountryList);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mRecyclerView.setAdapter(mCountryAdapter);
                        mCountryAdapter.notifyDataSetChanged();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this,"Error while fetching data",Toast.LENGTH_LONG).show();

                        Log.d("Test","Error :" + error.toString());

                    }
                });
                requestQueue.add(jsonObjectRequest);




            }
        });

    }
}
