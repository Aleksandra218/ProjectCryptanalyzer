public class CaesarCipher {

    public static int key;

    static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";

    /**
     *
     * @param letter конвертирует символ из алфавита
     * @return зашифрованный символ
     */
    public static String encodingLetter(String letter) { // конвертируем букву
        String converted = letter; //

        int index = alphabet.indexOf(letter.toLowerCase()); //

        if (index >= 0) { //
            index = index + key; //
            if (index >= alphabet.length()) { //
                index = index - alphabet.length(); //
            }
            converted = String.valueOf(alphabet.charAt(index)); //
        }
        return converted; //
    }

    /**
     *
     * @param letter зашифрованный символ
     * @return дешифрованный символ
     */
    public static String decodingLetter(String letter)
    {
        return decodingLetterByStep(letter, key);
    }

    /**
     * расшифровывает символ по указанному ключу
     * @param letter зашифрованный символ
     * @param step ключ шифрования
     * @return расшифрованный символ
     */
    public static String decodingLetterByStep(String letter, int step) { // расшифровываем ( бувка, шаг)

        String converted = letter; //объявляем переменную и присваиваем букву

        int index = CaesarCipher.alphabet.indexOf(letter); // обявляем переменную индекс и присваем позицию буквы в алфавите

        if (index >= 0) { //если индекс больше/равно нуля
            index = index - step; // из позиции вычитаем шаг 33-5

            if (index < 0) { // индекс меньше нуля
                index = index + CaesarCipher.alphabet.length(); // в индекс записываем индекс плюс длина алфавита
            }

            converted = String.valueOf(CaesarCipher.alphabet.charAt(index)); // конверуем букву
        }
        return converted;
    }
}
