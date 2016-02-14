package fr.julienguillaume.remeberme.notes;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.orm.SugarRecord;

/**
 * Created by William on 14/02/2016.
 */
public class Note extends SugarRecord {
    LatLng point;
    String text;

    public Note() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LatLng getPoint() {
        return point;
    }

    public void setPoint(LatLng point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Point :"+getPoint().toString()+" text : "+getText().toString();
    }
}
