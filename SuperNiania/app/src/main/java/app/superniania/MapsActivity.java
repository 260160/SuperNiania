package app.superniania;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import app.superniania.tabFragment.FrequencyFragment;
import app.superniania.tabControl.ControlTabActivity;
import app.superniania.model.Location;
import app.superniania.rest.RestClient;
import app.superniania.superniania.R;

public class MapsActivity extends FragmentActivity
        implements Callback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    private GoogleMap googleMap;
    private RestClient restClient;
    private RadioButton correctLoc;
    private RadioButton failLoc;
    private Location clickedLocation = new Location();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        googleMap.moveCamera( CameraUpdateFactory.zoomTo(13.2f));
        googleMap.setMyLocationEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setOnMapClickListener(this);
        googleMap.setOnMapLongClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

   /* @Override
    public boolean handleMessage(Message msg) {
        String updateNotice = msg.getData().getString("text");
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Nowe funkcje");
        dialog.setMessage(updateNotice);
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.show();
        return false;
    }*/

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (googleMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (googleMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
      /*  CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(0,0)).radius(1000);
        googleMap.addCircle(new CircleOptions()
                .center(new LatLng(100, 100))
                .radius(10000)
                .strokeColor(Color.RED)
                .fillColor(Color.YELLOW));
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));*/
    }

    @Override
    public void onMapClick(LatLng point) {
        googleMap.clear();
        MarkerOptions marker=new MarkerOptions();
        marker.position(point);
        googleMap.addMarker(marker);
        CircleOptions circle=new CircleOptions();
        circle.center(point).fillColor(Color.LTGRAY).radius(4);
        googleMap.addCircle(circle);
        clickedLocation.setLatitude(point.latitude);
        clickedLocation.setLongitude(point.longitude);
        TextView textLatitude= (TextView) findViewById(R.id.textView2);
        textLatitude.setText(new BigDecimal(point.latitude).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
        TextView textLongitude = (TextView) findViewById(R.id.textView3);
        textLongitude.setText(new BigDecimal(point.longitude).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
    }

    @Override
    public void onMapLongClick(LatLng point) {
        googleMap.clear();
    }

    @Override
    public boolean handleMessage(Message message) {
       // String updateNotice = msg.getData().getString("text");
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Dodawanie nowej lokalizacji");
        dialog.setMessage("OK");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.show();
        return false;
    }

    public void addLocation(View view) {
        correctLoc = (RadioButton) findViewById(R.id.radioButton);
        failLoc = (RadioButton) findViewById(R.id.radioButton2);

        if( (correctLoc.isChecked() && !failLoc.isChecked() ) || (!correctLoc.isChecked() && failLoc.isChecked()) )    {
            if(correctLoc.isChecked()) {
                clickedLocation.setType((String) correctLoc.getText());
            } else {
                clickedLocation.setType((String) failLoc.getText());
            }
            Intent intent = new Intent(this, FrequencyFragment.class);

            intent.putExtra("intentLoc", clickedLocation);
            startActivity(intent);
         //   restClient = new RestClient();
         //   restClient.execute(clickedLocation);
        }  else {
            Toast.makeText(MapsActivity.this, "Proszę wybrać jeden z typów lokalizacji", Toast.LENGTH_LONG).show();
        }
    }

    public void newTab(View view) {
        Intent intent = new Intent(this, ControlTabActivity.class);
        startActivity(intent);
    }

    public void sprDane(View view) {
    }
}