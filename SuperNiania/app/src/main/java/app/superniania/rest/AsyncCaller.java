package app.superniania.rest;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.codehaus.jackson.map.ObjectMapper;

import app.superniania.Auta;


public class AsyncCaller extends AsyncTask<Void, Void,String> {
    private static final String url="http://192.168.1.104:8084/SpringMVC/movie/mazda";

    public Handler handler;

    public AsyncCaller(Handler handler) {
        this.handler=handler;
    }


    @Override
    protected String doInBackground(Void... params) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        HttpResponse response;
        String result = null;
        try {
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();
                ObjectMapper mapper = new ObjectMapper();
                Auta auta = null;
                        auta= mapper.readValue(instream, Auta.class);
                result=auta.toString();
                //result= convertStreamToString(instream);
                instream.close();

            }
            return result;

        } catch (Exception e) {return null;}

    }

    private static String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
      protected void onPostExecute(String updateNotice) {
        Message message = new Message();
        Bundle data  = new Bundle();
     //   String updateNotice = auta.toString();
        data.putString("text",updateNotice);
        System.out.println("Oto wynik "+updateNotice);
        message.setData(data);
        handler.sendMessage(message);
    }
}