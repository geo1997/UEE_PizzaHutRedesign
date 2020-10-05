package com.example.pizzahut;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MAP ACTIVITY";
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationProviderClient;

    private Boolean mLocationPermissionsGranted = false;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;




    ArrayList<LatLng>arrayList = new ArrayList<>();
    LatLng Kalutara = new LatLng(6.585395, 79.960739);
    LatLng Kandy = new LatLng(7.290572, 80.633728);
    LatLng Hambantota = new LatLng(6.124593, 81.101074);
    LatLng Trincomalee = new LatLng(8.592200, 81.196793);
    LatLng Negombo = new LatLng(7.189464, 79.858734);
    LatLng Colombo = new LatLng(6.927079, 79.861244);


    private void getDeviceLocation(){
        Log.d(TAG,"getDeviceLocation:getting the devices current location");


        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(mLocationPermissionsGranted){

                final Task location = fusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();
                            Toast.makeText(MapsActivity.this, " current location", Toast.LENGTH_SHORT).show();

                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM,"Current Location");

                        }else{
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }

    }

    private void moveCamera(LatLng latLng, float zoom,String title){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom),5000,null);

        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title(title);
        mMap.addMarker(options);
    }


    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;

            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        arrayList.add(Kalutara);
        arrayList.add(Kandy);
        arrayList.add(Hambantota);
        arrayList.add(Trincomalee);
        arrayList.add(Negombo);
        arrayList.add(Colombo);
        getLocationPermission();

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

        if (mLocationPermissionsGranted) {

            LatLng Kalutara = new LatLng(6.585395, 79.960739);
            LatLng Kandy = new LatLng(7.290572, 80.633728);
            LatLng Hambantota = new LatLng(6.124593, 81.101074);
            LatLng Trincomalee = new LatLng(8.592200, 81.196793);
            LatLng Negombo = new LatLng(7.189464, 79.858734);
            LatLng Colombo = new LatLng(6.927079, 79.861244);

            mMap.addMarker(new MarkerOptions().position(Kalutara).title("Welcome To Kalutara Pizza Hut"));
            mMap.addMarker(new MarkerOptions().position(Kandy).title("Welcome To Kandy Pizza Hut"));
            mMap.addMarker(new MarkerOptions().position(Hambantota).title("Welcome To Hambantota Pizza Hut"));
            mMap.addMarker(new MarkerOptions().position(Trincomalee).title("Welcome To  Trincomalee Pizza Hut"));
            mMap.addMarker(new MarkerOptions().position(Negombo).title("Welcome To Negombo Pizza Hut"));
            mMap.addMarker(new MarkerOptions().position(Colombo).title("Welcome To Colombo Pizza Hut"));


//            for(int i=0;i<arrayList.size();i++){
//
//
//
//                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(arrayList.get(i).toString()));
//                mMap.animateCamera(CameraUpdateFactory.zoomTo(16.0f));
//
//                mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
//
//            }

            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setMyLocationButtonEnabled(false);

        }
        // Add a marker in Sydney and move the camera







    }
}