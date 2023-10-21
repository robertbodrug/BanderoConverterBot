package Services.SettingsService;

//Класс для зберігання змінних налаштувань
public class Settings {
    private int decimalPlaces;
    public Settings() {
        decimalPlaces = 2;
    }
    public Settings(byte decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }


}
