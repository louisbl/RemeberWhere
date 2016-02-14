package fr.julienguillaume.remeberme.notes;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.List;

import fr.julienguillaume.remeberme.Map;
import fr.julienguillaume.remeberme.R;

/**
 * Created by William on 14/02/2016.
 */
public class DialogFragment extends android.app.DialogFragment {
    private static final String TAG = "DF";
    EditText mEdit;


    public static DialogFragment newInstance(LatLng point, String type) {

        Bundle args = new Bundle();

        DialogFragment fragment = new DialogFragment();
        args.putDouble("long", point.getLongitude());
        args.putDouble("lat", point.getLatitude());
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dialog, container, false);
        getDialog().setTitle("Ajouter une nouvelle note");
        Button saveBtn = (Button) rootView.findViewById(R.id.saveNote);
        mEdit   = (EditText) rootView.findViewById(R.id.editText);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note myNewNote = new Note();
                myNewNote.setLat(getArguments().getDouble("lat"));
                myNewNote.setLog(getArguments().getDouble("long"));
                myNewNote.setText(mEdit.getText().toString());
                myNewNote.save();
                if (getArguments().getString("type") == "map"){
                    ((Map)getActivity()).RefreshMap();
                }
                getDialog().dismiss();
            }
        });
        return rootView;
    }

}
