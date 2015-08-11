package app.superniania;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import app.superniania.superniania.R;
import app.superniania.tabControl.ControlTabActivity;

public class MapsFragment extends Fragment implements GoogleMap.OnMapClickListener{
    private MapView map;
    private GoogleMap googleMap;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        map = (MapView) rootView.findViewById(R.id.mapView);
        map.onCreate(savedInstanceState);

        map.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = map.getMap();
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(13.2f));
        googleMap.setMyLocationEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setOnMapClickListener(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {

        super.onPause();
        map.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }

    @Override
    public void onMapClick(LatLng point) {
        googleMap.clear();
        MarkerOptions marker = new MarkerOptions();
        marker.position(point);
        googleMap.addMarker(marker);
        CircleOptions circle=new CircleOptions();
        circle.center(point).fillColor(Color.LTGRAY).radius(4);
        googleMap.addCircle(circle);
        ControlTabActivity.location.setLatitude(point.latitude);
        ControlTabActivity.location.setLongitude(point.longitude);
        TextView textLatitude= (TextView) rootView.findViewById(R.id.textLongitude);
        textLatitude.setText(new BigDecimal(point.latitude).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
        TextView textLongitude = (TextView) rootView.findViewById(R.id.textLatitude);
        textLongitude.setText(new BigDecimal(point.longitude).round(new MathContext(6, RoundingMode.HALF_UP)).toString());
    }
}