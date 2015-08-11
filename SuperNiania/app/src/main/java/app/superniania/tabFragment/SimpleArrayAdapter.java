package app.superniania.tabFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import app.superniania.superniania.R;


/**
 * Created by Łukasz on 2015-05-28.
 */
public class SimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private CheckBox chooseDayCheckbox;

    public SimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.row_list_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_list_layout, parent, false);
        //TextView textView = (TextView) rowView.findViewById(R.id.label);
      //  ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
      //  textView.setText(values[position]);

        chooseDayCheckbox = (CheckBox) rowView.findViewById(R.id.listOfDayCheckBox);
        chooseDayCheckbox.setText(values[position]);
  /*       chooseDayCheckbox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              // TODO Auto-generated method stub
                if(chooseDayCheckbox.isChecked()) {
                    System.out.println(chooseDayCheckbox.getText()+" -Checked");
                }
            }
        });*/

        // Change the icon for Windows and iPhone
      /*  String s = values[position];
        if (s.startsWith("Poniedziałek") || s.startsWith("Wtorek")
                || s.startsWith("Sroda")) {
            imageView.setImageResource(R.drawable.abc_btn_check_material);
        } else {
        //   imageView.setImageResource(R.drawable.abc_btn_check_material);
        }*/

        return rowView;
    }
}
