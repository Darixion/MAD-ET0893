package com.example.miniprojects;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.miniprojects.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

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
        LatLng defaultLocation = new LatLng(-6.2088, 106.8456); // Example: Jakarta
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 15));

        // Fetch and display nearby clinics/hospitals
        showNearbyClinicsAndHospitals();
    }

    private void showNearbyClinicsAndHospitals() {
        // Sample data: Fetch from Places API or use mock data
        LatLng clinic1 = new LatLng(-6.2088, 106.8456); // Example coordinates
        LatLng hospital1 = new LatLng(-6.2078, 106.8489);

        // Add markers
        mMap.addMarker(new MarkerOptions()
                .position(clinic1)
                .title("Nearby Clinic"));
        mMap.addMarker(new MarkerOptions()
                .position(hospital1)
                .title("Nearby Hospital"));
    }
}