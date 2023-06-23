import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaesarCipher {
    static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";


    public static String convertLetter(String letter) { // конвертируем букву
        String converted = letter; //

        int index = alphabet.indexOf(letter.toLowerCase()); //

        if (index >= 0) { //
            index = index + Menu.key; //
            if (index > alphabet.length()) { //
                index = index - alphabet.length(); //
            }
            converted = String.valueOf(alphabet.charAt(index)); //
        }
        return converted; //
    }
}
