package com.example.ayush.weatherapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //WEATHER textview Variable
    TextView cityField, detailsField, currentTemperatureField, humidity_field, weatherIcon, updatedField;
    //weather font initilization
    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //font initilization
        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        //weather textview initilizaion
        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);

        //weather update
        weatherFunction.placeIdTask asyncTask =new weatherFunction.placeIdTask(new weatherFunction.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                Log.i("weather",weather_city );
                cityField.setText(weather_city);
                Log.i("weather",weather_updatedOn );
                updatedField.setText(weather_updatedOn);
                Log.i("weather",weather_description );
                detailsField.setText(weather_description);
                Log.i("weather",weather_temperature );
                currentTemperatureField.setText(weather_temperature);
                Log.i("weather",weather_humidity );
                humidity_field.setText("Humidity: "+weather_humidity);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        asyncTask.execute("28.4595", "77.0266"); //  asyncTask.execute("Latitude", "Longitude")
    }
}
