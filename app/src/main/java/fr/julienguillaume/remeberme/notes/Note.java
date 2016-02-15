package fr.julienguillaume.remeberme.notes;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.orm.SugarRecord;

/**
 * Created by William on 14/02/2016.
 */
public class Note extends SugarRecord {
    double lat , log;
    String text;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    public Note() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LatLng getPosition(){
        return new LatLng(lat, log);
    }
    @Override
    public String toString() {
        return "Point :"+ getLat()+" "+ getLog() +" text : " + getText().toString();
    }
}
