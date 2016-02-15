package fr.julienguillaume.remeberme.notes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.julienguillaume.remeberme.R;
import fr.julienguillaume.remeberme.dummy.DummyContent;
import fr.julienguillaume.remeberme.dummy.DummyContent.DummyItem;


public class NoteFragment extends Fragment {

    private MyNoteRecyclerViewAdapter mNotesAdapter;

    public NoteFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        final List<Note> notes = Note.listAll(Note.class);


        mNotesAdapter = new MyNoteRecyclerViewAdapter(notes);

        mNotesAdapter.setNoteClickListener(new MyNoteRecyclerViewAdapter.NoteClickListener() {
            @Override
            public void onClick(int position, View v) {
                Note note = notes.get(position);
            }
        });

        recyclerView.setAdapter(new MyNoteRecyclerViewAdapter(notes));

        return view;
    }


}
