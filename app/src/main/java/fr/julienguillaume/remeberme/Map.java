package fr.julienguillaume.remeberme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

public class Map extends Activity {

    protected MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.setStyleUrl(Style.MAPBOX_STREETS);
        mapView.setLatLng(new LatLng(46.6756, 4.3727));
        mapView.setZoom(11);
        mapView.onCreate(savedInstanceState);
        mapView.setOnMapLongClickListener(new MapView.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng point) {
                
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    @Override
    public void onBackPressed() {
        Map.this.finish();
    }
}
