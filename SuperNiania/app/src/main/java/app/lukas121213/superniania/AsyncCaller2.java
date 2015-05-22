package app.lukas121213.superniania;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;


import java.net.URL;


public class AsyncCaller2 extends AsyncTask<Void, Void,String> {
    private static final String url="http://192.168.1.104:8084/SpringMVC/movie/mazda";

    public Handler handler;

    public AsyncCaller2(Handler handler) {
        this.handler=handler;
    }


    @Override
    protected String doInBackground(Void... params) {
        InputStream inputStream = null;
        String result = "";
        try {
            Auta auta = new Auta();
            auta.setId(43);
            auta.setMarka("honda43");

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", auta.getId());
            jsonObject.accumulate("marka", auta.getMarka());

            json = jsonObject.toString();

            StringEntity se = new StringEntity(json);

            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }



    @Override
    protected void onPostExecute(String string) {
        Message message = new Message();
        Bundle data  = new Bundle();
        //   String updateNotice = auta.toString();
        data.putString("text","udalo sie");
       // System.out.println("Oto wynik "+updateNotice);
        message.setData(data);
        handler.sendMessage(message);
    }
}
