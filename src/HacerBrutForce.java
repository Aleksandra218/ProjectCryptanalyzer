public class HacerBrutForce {

    static String decoding(String letter, int step) { // расшифровываем ( бувка, шаг)

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
