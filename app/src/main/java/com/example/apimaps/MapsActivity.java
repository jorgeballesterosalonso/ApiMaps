package com.example.apimaps;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner spinnerCiudades;
    private Button Actualizar;
    private LatLng ciudad = new LatLng(0,0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mylayout);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Actualizar = findViewById(R.id.Actualizar);

        String[] Ciudades = {"Madrid", "Barcelona", "Silicon Valley"};
        spinnerCiudades = findViewById(R.id.spinnerCiud);

        spinnerCiudades.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Ciudades));

        Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerCiudades.getSelectedItem().equals("Madrid")) {
                    ciudad = new LatLng(40.45720364016305, -3.687784752133242);
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(ciudad));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));

                } else if (spinnerCiudades.getSelectedItem().equals("Barcelona")) {
                    ciudad = new LatLng(41.40249488648019, 2.1710819477176955);
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(ciudad));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
                } else {
                    ciudad = new LatLng(37.43762233256193, -122.14616272521931);
                    mMap.clear();
                    mMap.addMarker(new MarkerOptions().position(ciudad));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
                }
            }
        });

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(ciudad).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ciudad));
    }
}