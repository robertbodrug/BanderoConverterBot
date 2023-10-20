package org.example;

public enum Commands {
    Start,
    Settings
    ;


    @Override
    public String toString() {
        return switch (this) {
            case Start -> "/start";
            case Settings -> "/settings";
        };
    }
}
