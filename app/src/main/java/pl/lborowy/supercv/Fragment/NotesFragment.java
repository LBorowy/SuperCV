package pl.lborowy.supercv.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.supercv.R;

public class NotesFragment extends Fragment {


    public static final String NOTE_KEY = "notatka";

    @BindView(R.id.notesEditText)
    EditText notesEditText;

    private SharedPreferences sharedPreferences;

    public static final String TAG = NotesFragment.class.getSimpleName();

    public static NotesFragment newInstance() {

        NotesFragment fragment = new NotesFragment();
        return fragment;
    }

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("notatki", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        // odczytywanie
        notesEditText.setText(getNoteFromSharedPreferences());
    }

    @NonNull
    private String getNoteFromSharedPreferences() {
        return sharedPreferences.getString(NOTE_KEY, "");
    }

    @Override
    public void onPause() {
        super.onPause();
        // zapisywanie
        String notesToSave = getTextFromEditText();
        saveToSharedPreferences(notesToSave);
    }

    @NonNull
    private String getTextFromEditText() {
        return notesEditText.getText().toString();
    }

    private void saveToSharedPreferences(String notesToSave) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("notatki", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NOTE_KEY, notesToSave);
        editor.apply(); // zapisz zmiany asynchronicznie - lepsze dla wolnych telefonów (tworzy się
        // drugi wątek podczas zapisywania Stringa)
//        editor.commit(); // zapisz zmiany (synchronicznie)
    }

}
