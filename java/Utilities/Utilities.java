package Utilities;

import java.util.Map;
import java.util.Random;

public class Utilities {
    public static int random(int max, int min) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static int random(int length) {
        int seed = (int) Math.pow(10, length - 1);
        return seed + new Random().nextInt(9 * seed);
    }

    public static Map<String, String> getData(Class<?> dataClass, String method) {
        try {
            return (Map<String, String>) dataClass.getMethod(method).invoke(null);
        } catch (Exception e) {
            return null;
        }
    }
}
