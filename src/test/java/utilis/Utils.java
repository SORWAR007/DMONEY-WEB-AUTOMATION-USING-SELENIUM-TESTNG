package utilis;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Utils {

    public static int generaterandomnumber(int max, int min) {
        double randomid = Math.random() * (max - min) * min;
        return (int) randomid;
    }

    @SuppressWarnings("unchecked")
    public static void saveinfojson(String filepath, JSONObject js) throws IOException, ParseException {


        JSONParser pa= new JSONParser();
        JSONArray Ja= (JSONArray)pa.parse(new FileReader(filepath));
        Ja.add(js);
        FileWriter fl= new FileWriter(filepath);
        fl.write(Ja.toString());
        fl.flush();
        fl.close();
    }

}