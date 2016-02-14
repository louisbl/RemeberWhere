package fr.julienguillaume.remeberme.notes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mapbox.mapboxsdk.geometry.LatLng;

import fr.julienguillaume.remeberme.R;

/**
 * Created by William on 14/02/2016.
 */
public class DialogFragment extends android.app.DialogFragment {
    private static final String TAG = "DF";
    EditText mEdit;

    public static DialogFragment newInstance(LatLng point) {

        Bundle args = new Bundle();
        
        DialogFragment fragment = new DialogFragment();
        args.putDouble("long", point.getLongitude());
        args.putDouble("lat", point.getLatitude());
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
                myNewNote.setPoint(new LatLng(getArguments().getDouble("lat"),getArguments().getDouble("long")));
                myNewNote.setText(mEdit.getText().toString());
                myNewNote.save();
            }
        });
        return rootView;
    }

}
