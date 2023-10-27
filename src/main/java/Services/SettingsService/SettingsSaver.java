package Services.SettingsService;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class SettingsSaver {
    public static void SaveSettings(Settings s) throws IOException {
        Gson gson = new Gson();
        FileWriter file = new FileWriter(".\\settingsBase.json");
        file.write(gson.toJson(s));
        file.close();System.out.println("saved");

    }
}
