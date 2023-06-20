import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipher {
    private static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    private static int step = 5;


    public static String makeCezar(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            String letter = String.valueOf(text.charAt(i));
            result = result + convertLetter(letter);
        }
        return result;
    }

    public static String convertLetter(String letter) {
        String converted = letter;
        int index = alphabet.indexOf(letter.toLowerCase());

        if (index >= 0) {
            index = index + step;
            if (index > alphabet.length()) {
                index = index - alphabet.length();
            }
            converted = String.valueOf(alphabet.charAt(index));
        }
        return converted;
    }
}
