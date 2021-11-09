package epam.training.jdihomework.utils;

import epam.training.jdihomework.entities.MetalColorsEntity;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.testng.annotations.DataProvider;

public class JsonDataProvider {
    private static final String PATH_TO_JSON_DATA = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "metalColorsEntities")
    public static Iterator<Object[]> getMetalColorsEntities() {
        return JsonParser.parseReader(readJson(PATH_TO_JSON_DATA))
                .getAsJsonObject()
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .map(jsonElement -> new Gson().fromJson(jsonElement, MetalColorsEntity.class))
                .map(entry -> new Object[] {entry})
                .iterator();
    }

    private static JsonReader readJson(String filePath) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }
}
