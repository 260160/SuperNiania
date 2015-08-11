package app.superniania.tabFragment;

import app.superniania.model.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.superniania.superniania.R;
import app.superniania.tabControl.ControlTabActivity;

/**
 * Created by Łukasz on 2015-05-27.
 */
public class FrequencyFragment extends Fragment  {
    private List<String> daysLocation = new ArrayList<>();
  ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_location, container, false);
        lv = (ListView) view.findViewById(R.id.listDayView);

        ControlTabActivity.location.setType("Typ 1");

        final String[] listDaysOfWeek = new String[] { "Poniedziałek", "Wtorek", "Sroda",
                "Czwartek", "Piątek", "Sobota", "Niedziela" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_checked, listDaysOfWeek);
        // SimpleArrayAdapter adapter = new SimpleArrayAdapter(getActivity(), values);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView check = (CheckedTextView) view;
                Boolean isChecked = check.isChecked();
                check.setChecked(!check.isChecked());

                if (isChecked == false) {
                    daysLocation.add(listDaysOfWeek[position]);
                } else {
                    daysLocation.remove(listDaysOfWeek[position]);
                }
                ControlTabActivity.location.setListOfDays(daysLocation);
            }

        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
