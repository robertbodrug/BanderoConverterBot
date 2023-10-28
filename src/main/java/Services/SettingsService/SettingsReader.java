package Services.SettingsService;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SettingsReader {
    public static Settings getSettings(Long chatId) throws IOException {
        Gson gson = new Gson();
        Settings set = getAllSettings().get(chatId);
        return Objects.nonNull(set)?set:new Settings();
    }
    public static HashMap<Long,Settings> getAllSettings() throws FileNotFoundException {
        Gson gson = new Gson();
        TypeToken<HashMap<Long,Settings>> token = new TypeToken<>(){};
        HashMap<Long,Settings> s =gson.fromJson(new JsonReader(new FileReader("C:\\Users\\agrte\\IdeaProjects\\BanderoConverterBot\\src\\main\\java\\Services\\SettingsService\\settingsBase.json")), token);

        return s!=null?s:new HashMap<Long,Settings>();

    }
}
