package app.superniania.rest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.json.JSONObject;

import app.superniania.Auta;
import app.superniania.model.Location;


/**
 * Created by Łukasz on 2015-05-26.
 */
public class RestClient extends AsyncTask<Location, Void,String> {
    private static String url="";
  //  public Handler handler;

   // public RestClient(Handler handler) {
   //     this.handler=handler;
   // }

    @Override
    protected String doInBackground(Location... locations) {
        System.out.println("Jestem tutaj "+locations[0].getLatitude());
        url="http://192.168.1.101:8084/SupernianiaServer/db/saveLocation";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("longitude", locations[0].getLongitude());
            jsonObject.accumulate("latitude", locations[0].getLatitude());
            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            httpPost.setEntity(se);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpclient.execute(httpPost);

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return "cos";
    }

   /* @Override
    protected void onPostExecute(String string) {
        Message message = new Message();
        Bundle data  = new Bundle();
        data.putString("text","pozytywnie zapisano lokalizacje");
        message.setData(data);
        handler.sendMessage(message);
    }*/
}
