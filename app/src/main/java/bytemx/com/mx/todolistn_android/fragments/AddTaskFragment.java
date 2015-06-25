package bytemx.com.mx.todolistn_android.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

import bytemx.com.mx.todolistn_android.R;




public class AddTaskFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private Button btSave;
    private Spinner spinner;
    private EditText eTxtTitle;
    private EditText eTxtDesc;


    private Object prioritySelected;
    public static AddTaskFragment newInstance(String param1, String param2) {
        AddTaskFragment fragment = new AddTaskFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_task, container, false);
        btSave= (Button) view.findViewById(R.id.btSave);
        eTxtTitle = (EditText) view.findViewById(R.id.eTxtTitle);
        eTxtDesc = (EditText) view.findViewById(R.id.eTxtDesc);
        spinner = (Spinner) view.findViewById(R.id.spiPriority);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.item_priority_spinner,getActivity().getResources().getStringArray(R.array.priority_array));
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prioritySelected= parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v("TITLE", String.valueOf(eTxtTitle.getText()));
                Log.v("DESC", String.valueOf(eTxtDesc.getText()));
                Log.v("PRIORIDAD", String.valueOf(prioritySelected));

            }
                });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
