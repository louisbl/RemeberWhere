package fr.julienguillaume.remeberme.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.julienguillaume.remeberme.R;


import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private static NoteClickListener mListener;

    private List<Note> mNotes;

    public MyNoteRecyclerViewAdapter(List<Note> notes) {
        mNotes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_note, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = mNotes.get(position);

        holder.getNoteText().setText(note.getText());
        holder.getNotePosition().setText(note.getPosition().toString());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void setNoteClickListener(NoteClickListener mListener) {
        MyNoteRecyclerViewAdapter.mListener = mListener;
    }

    public void Add(Note note) {
        mNotes.add(note);
    }

    public interface NoteClickListener {
        void onClick(int position, View v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mNoteText;
        private final TextView mNotePosition;
        private ArrayBlockingQueue<Note> mNote;

        public ViewHolder(View itemView) {
            super(itemView);

            mNoteText = (TextView) itemView.findViewById(R.id.noteText);
            mNotePosition = (TextView) itemView.findViewById(R.id.notePostion);

            itemView.setOnClickListener(this);
        }

        public TextView getNoteText() {
            return mNoteText;
        }

        public TextView getNotePosition() {
            return mNotePosition;
        }

        @Override
        public void onClick(View v) {
            if (mListener == null) {
                return;
            }

            mListener.onClick(getAdapterPosition(), v);
        }
    }
}
