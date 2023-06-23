import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipher {
    static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    private static int step = 5;

    public static String convertLetter(String letter) { // конвертируем букву
        String converted = letter; //

        int index = alphabet.indexOf(letter.toLowerCase()); //

        if (index >= 0) { //
            index = index + step; //
            if (index > alphabet.length()) { //
                index = index - alphabet.length(); //
            }
            converted = String.valueOf(alphabet.charAt(index)); //
        }
        return converted; //
    }
}
