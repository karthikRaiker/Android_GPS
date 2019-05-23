package com.example.b6gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView td;
    Button gps;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        td=findViewById(R.id.location);
        gps=findViewById(R.id.gps);

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindLocation();
            }
        });
    }

    public void FindLocation()
    {
        try {
            locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,this);

        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        td.setText("Current Location Lattitude is"+location.getLatitude()+ " , Longitude is  "+location.getLongitude() );
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this,"enable permission",Toast.LENGTH_SHORT).show();
    }


}
