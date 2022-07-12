package UtilityClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public String getValueFromJson (String dataType, String valueName, String jsonFilePath) {
        String value;
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        JSONObject dataSet = new JSONObject();

        try (FileReader reader = new FileReader(jsonFilePath)){

            json = (JSONObject) parser.parse(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataSet = (JSONObject) json.get(dataType);
        value = (String) dataSet.get(valueName);
        return value;
    }
}

