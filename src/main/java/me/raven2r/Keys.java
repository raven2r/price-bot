package me.raven2r;

import java.io.IOException;
import java.util.Properties;

// REWRITE, must be singleton
public final class Keys {
    private final Properties keys = new Properties();
    private static boolean instantiated = false;

    protected Keys() {
        try {
            keys.load(getClass().getResourceAsStream("keys.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Keys instantiate() {
        if(!instantiated) {
            instantiated = true;
            return new Keys();
        }
        else
            throw new IllegalStateException("Keys instance already exists");
    }

    public String getBinanceKey() {
        return keys.getProperty("binance.key");
    }

    public String getTelegramBotKey() {
        return keys.getProperty("telegram.key");
    }
}

