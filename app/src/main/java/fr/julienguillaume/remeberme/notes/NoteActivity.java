package fr.julienguillaume.remeberme.notes;

import android.Manifest;
import android.app.FragmentManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.mapbox.mapboxsdk.geometry.LatLng;

import fr.julienguillaume.remeberme.R;

public class NoteActivity extends AppCompatActivity  implements GoogleApiClient.ConnectionCallbacks , LocationListener{

    private DialogFragment frag;
    FragmentManager fm = getFragmentManager();
    private GoogleApiClient mGoogleApiClient;
    private boolean mTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        View fragment = findViewById(R.id.noteFragment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        final LatLng point = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag = DialogFragment.newInstance(point, "map");
                frag.show(fm, "Add new");
            }
        });
    }
    @Override
    public void onConnected(Bundle bundle) {
            setTracking(true);
    }
    private void setTracking(boolean tracking) {

        if (mTracking == tracking) {
            return;
        }
        mTracking = tracking;
        if (mTracking) {
            LocationRequest locationRequest;
            locationRequest = new LocationRequest();
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            locationRequest.setInterval(1000);
            locationRequest.setFastestInterval(1000);
            locationRequest.setSmallestDisplacement(5);
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) NoteActivity.this);

        } else {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (com.google.android.gms.location.LocationListener) NoteActivity.this);

        }
    }
    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
