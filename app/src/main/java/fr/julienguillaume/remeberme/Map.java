package fr.julienguillaume.remeberme;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

import java.util.List;

import fr.julienguillaume.remeberme.notes.DialogFragment;
import fr.julienguillaume.remeberme.notes.Note;

public class Map extends Activity {

    private static final String TAG = "Map" ;
    protected MapView mapView;
    android.app.FragmentManager fm = getFragmentManager();
    DialogFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.setStyleUrl(Style.MAPBOX_STREETS);
        mapView.setLatLng(new LatLng(46.6756, 4.3727));
        mapView.setZoom(4);
        mapView.onCreate(savedInstanceState);
        RefreshMap();
        mapView.setOnMapLongClickListener(new MapView.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng point) {
                frag = DialogFragment.newInstance(point, "map");
                frag.show(fm, "Add new");
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
        Intent mainIntent = new Intent(Map.this, MainActivity.class);
        Map.this.startActivity(mainIntent);
        this.finish();
    }

    /**
     * Place les marqueur sur la map
     */
    public void  RefreshMap(){
        List<Note> notes = Note.listAll(Note.class);
            if(!notes.isEmpty()){
            for (Note note: notes) {
                mapView.addMarker(new MarkerOptions()
                        .position(new LatLng(note.getLat(),note.getLog()))
                        .title(note.getText()));
            }
        }
    }
}
