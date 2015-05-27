package app.superniania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public static Auta parseAuta(InputStream json) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(json));
        StringBuilder sb = new StringBuilder();

        try {
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            reader.close();
        }
        JSONArray jsonReply = new JSONArray(sb.toString());
       Auta auta = new Auta();
        JSONObject jsonAuta = jsonReply.getJSONObject(0);
        auta.setId(jsonAuta.getInt("id"));
        auta.setMarka(jsonAuta.getString("marka"));

        return auta;
    }
}
