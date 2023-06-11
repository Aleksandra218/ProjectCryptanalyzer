public class Main {

    static String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    static String textTest = "Я решительно замялся, не сказал ни слова больше и " +
            "чувствовал, что ежели этот злодей-учитель хоть год целый будет молчать" +
            " и вопросительно смотреть на меня, я все-таки не в состоянии буду произнести" +
            " более ни одного звука».";

    static int step = 5;


    public static void main(String[] args) {

        System.out.println(textTest);
        String res = makeCezar(textTest);
        System.out.println(res);

        String resDec = methodBrutforce(res);
        //System.out.println(resDec);

    }

    private static String makeCezar(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            String letter = String.valueOf(text.charAt(i));
            result = result + convertLetter(letter);
        }
        return result;
    }

    static String convertLetter(String letter) {
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
    private static String methodBrutforce(String encrypted) {
        String resultat = "";

        int stepb = 1;
        while (stepb <= alphabet.length()) {
            String res = "";
            for (int i = 0; i < encrypted.length(); i++) {
                String letter = String.valueOf(encrypted.charAt(i));
                res = res + decoding(letter, stepb);
            }


            resultat = res + "\n\n";
            System.out.println(stepb + " " + res);
            stepb++;
        }
        return resultat;
    }
    static String decoding(String letter, int stepl) {
        String converted = letter;
        int index = alphabet.indexOf(letter);

        if (index >= 0) {
            index = index - stepl;
            if (index < 0) {
                index = index + alphabet.length();
            }
            converted = String.valueOf(alphabet.charAt(index));
        }
        return converted;
    }
}