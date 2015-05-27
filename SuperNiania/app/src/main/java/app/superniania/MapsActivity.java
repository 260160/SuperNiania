package app.superniania;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.os.Handler.Callback;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import app.superniania.model.Location;
import app.superniania.rest.AsyncCaller;
import app.superniania.rest.RestClient;
import app.superniania.superniania.R;

//public class MapsActivity extends FragmentActivity  implements Callback {
   public class MapsActivity extends FragmentActivity implements Callback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    private GoogleMap googleMap;
    private RestClient restClient;
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

        //new AsyncCaller2(new Handler(this)).execute();


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
        MarkerOptions marker=new MarkerOptions();
        marker.position(point);
        googleMap.addMarker(marker);
        CircleOptions circle=new CircleOptions();
        circle.center(point).fillColor(Color.LTGRAY).radius(4);
        googleMap.addCircle(circle);

        Location clickedLocation = new Location();
        clickedLocation.setLatitude(point.latitude );
        clickedLocation.setLongitude(point.longitude );
        restClient =new RestClient();
        restClient.execute(clickedLocation);
       //restClient= new RestClient(new Handler(this));
        //restClient.execute();
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
}