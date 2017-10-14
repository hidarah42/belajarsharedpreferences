package com.example.hidarah42.gugelmapsarraylist;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng Jakarta= new LatLng(-6.1751,106.8650);
    private static final LatLng Palembang = new LatLng(-2.990934,104.756554);
    private static final LatLng Penang = new LatLng(5.4163,100.3328);
    private static final LatLng Zurich = new LatLng(47.3769,8.5417);
    private String Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Arraylist
        ArrayList<LatLng>Arraynya = new ArrayList<>();
        Arraynya.add(Jakarta);
        Arraynya.add(Palembang);
        Arraynya.add(Penang);
        Arraynya.add(Zurich);

        //Jakarta
        mMap.addMarker(new MarkerOptions().position(Jakarta).title("Jakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Jakarta));

        //Palembang
        mMap.addMarker(new MarkerOptions().position(Palembang).title("Palembang"));

        //Palembang
        mMap.addMarker(new MarkerOptions().position(Penang).title("Penang"));

        //Penang
        //Palembang
        mMap.addMarker(new MarkerOptions().position(Zurich).title("Zurich"));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker != null && marker.getTitle().equals("Jakarta")){
                    Data = "Jakarta";
                    Intent i =new Intent(MapsActivity.this,Detail.class);
                    i.putExtra("Data",Data);
                    startActivity(i);
                }

                if(marker != null && marker.getTitle().equals("Palembang")){
                    Data = "Palembang";
                    Intent i =new Intent(MapsActivity.this,Detail.class);
                    i.putExtra("Data",Data);
                    startActivity(i);
                }

                if(marker != null && marker.getTitle().equals("Penang")){
                    Data = "Penang";
                    Intent i =new Intent(MapsActivity.this,Detail.class);
                    i.putExtra("Data",Data);
                    startActivity(i);
                }

                if(marker != null && marker.getTitle().equals("Zurich")){
                    Data = "Zurich";
                    Intent i =new Intent(MapsActivity.this,Detail.class);
                    i.putExtra("Data",Data);
                    startActivity(i);
                }
            }
        });
    }
}
