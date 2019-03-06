package com.example.akash.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class gmaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng sunderlal = new LatLng(25.2764,82.9996);
    private static final LatLng shivganga = new LatLng(25.2538,82.9964);
    private static final LatLng satkriti = new LatLng(25.2836,82.9991);
    private static final LatLng alaknanda = new LatLng(25.2880,83.0012);
    private static final LatLng popular = new LatLng(25.2927, 82.9704);
    private LocationManager locationManager;
    private LocationListener locationListener;
    FusedLocationProviderClient mFusedLocationProviderClient;


    private Marker msunderlal;
    private Marker mshivganga;
    private Marker msatkriti;
    private Marker malaknanda;
    private Marker mpopular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaps);
        Log.e("TAG","Activity bni");


        // Construct a PlaceDetectionClient.


        // Construct a FusedLocationProviderClient.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
         SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
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


        Log.e("TAG","function called");

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setBuildingsEnabled(true);
        mMap.setMinZoomPreference(13.0f);
        mMap.setMaxZoomPreference(24.0f);


        List<Marker> markerList = new ArrayList<>();

        msunderlal=mMap.addMarker(new MarkerOptions().position(sunderlal).title("Marker in sunderlal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        msunderlal.setTag(0);
        markerList.add(msunderlal);
        msatkriti=mMap.addMarker(new MarkerOptions().position(satkriti).title("Marker in satkriti").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        msatkriti.setTag(0);
        markerList.add(msatkriti);
        mshivganga=mMap.addMarker(new MarkerOptions().position(shivganga).title("Marker in shivganga").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        mshivganga.setTag(0);
        markerList.add(mshivganga);
        malaknanda=mMap.addMarker(new MarkerOptions().position(alaknanda).title("Marker in alaknanda").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        malaknanda.setTag(0);
        markerList.add(malaknanda);
        mpopular=mMap.addMarker(new MarkerOptions().position(popular).title("Marker in popular").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        mpopular.setTag(0);
        markerList.add(mpopular);
        // Add a marker in Sydney and move the camera


        for (Marker m : markerList){
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,2));
            Log.e("TAGG",m.getTitle());

        }
    }




    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status)
            return true;
        else {
            if (googleApiAvailability.isUserResolvableError(status))
                Toast.makeText(this, "Please Install google play services to use this application", Toast.LENGTH_LONG).show();
        }
        return false;

    }

}