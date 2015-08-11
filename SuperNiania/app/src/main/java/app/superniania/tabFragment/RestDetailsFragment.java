package app.superniania.tabFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.List;

import app.superniania.superniania.R;
import app.superniania.tabControl.ControlTabActivity;

/**
 * Created by Łukasz on 2015-05-27.
 */
public class RestDetailsFragment extends Fragment  {
     private EditText dateFrom;
     private EditText dateTo;
     private RadioButton correctLoc;
     private RadioButton failLoc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rest_details, container, false);
        dateFrom = (EditText) view.findViewById(R.id.dateFrom);
        dateTo= (EditText) view.findViewById(R.id.dateTo);
        correctLoc = (RadioButton) view.findViewById(R.id.correctRadiobutton);
        failLoc = (RadioButton) view.findViewById(R.id.failRadiobutton);
        dateFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                     ControlTabActivity.location.setDateFrom(s.toString());
            }
        });

        dateTo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                ControlTabActivity.location.setDateTo(s.toString());
            }
        });

        correctLoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                //handle the boolean flag here.
                if(arg1==true)
                    System.out.println("Wcisnalem radio");

                else
                    System.out.println("Odkliknalem radio");

            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
