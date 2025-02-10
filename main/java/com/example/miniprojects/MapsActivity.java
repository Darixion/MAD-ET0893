package com.example.miniprojects;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.miniprojects.databinding.ActivityMapsBinding;
import android.annotation.SuppressLint;
import android.location.Location;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Location currentLocation;
    FusedLocationProviderClient fusedClient;


    class MyLocationLayerActivity extends AppCompatActivity
            implements GoogleMap.OnMyLocationButtonClickListener,
            GoogleMap.OnMyLocationClickListener,
            OnMapReadyCallback {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);

            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }

        @SuppressLint("MissingPermission")
        @Override
        public void onMapReady(GoogleMap map) {
            // TODO: Before enabling the My Location layer, you must request
            // location permission from the user. This sample does not include
            // a request for location permission.
            map.setMyLocationEnabled(true);
            map.setOnMyLocationButtonClickListener(this);
            map.setOnMyLocationClickListener(this);
        }

        @Override
        public void onMyLocationClick(@NonNull Location location) {
            Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG)
                    .show();
        }

        @Override
        public boolean onMyLocationButtonClick() {
            Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT)
                    .show();
            // Return false so that we don't consume the event and the default behavior still occurs
            // (the camera animates to the user's current position).
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
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
        mMap = googleMap;

        // Set default location (e.g., your current location or a city)
        LatLng defaultLocation = new LatLng(1.3098, 103.7775); // Example: Jakarta
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 14));
        // Fetch and display nearby clinics/hospitals
        showNearbyClinicsAndHospitals();
    }



    private void showNearbyClinicsAndHospitals() {
        // Sample data: Fetch from Places API or use mock data
        LatLng clinic1 = new LatLng(1.31000, 103.76880); // Example coordinates
        LatLng hospital1 = new LatLng(1.29385, 103.78310);

        // Add markers
        mMap.addMarker(new MarkerOptions()
                .position(clinic1)
                .title("Nearby Clinic")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))); // Fixed chaining

        mMap.addMarker(new MarkerOptions()
                .position(hospital1)
                .title("Nearby Hospital")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))); // Added icon color
    }
}
