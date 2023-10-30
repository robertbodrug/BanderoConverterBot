package Services.SettingsService;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class SettingsSaver {
    public static void SaveSettings(Long chatId,Settings s) throws IOException {
        Gson gson = new Gson();
        HashMap<Long, Settings> allSettings = SettingsReader.getAllSettings();
        FileWriter file = new FileWriter(".\\src\\main\\java\\Services\\SettingsService\\settingsBase.json");

        allSettings.put(chatId,s);
        file.write(gson.toJson(allSettings));
        file.close();

    }
    }

