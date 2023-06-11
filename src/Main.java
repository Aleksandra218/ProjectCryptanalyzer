public class Main {

    static  String alphabet= "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,””:-!? ";
    static String textTest = "— сказал он, покачиваясь на стуле и задумчиво глядя себе под ноги. — Сначала вы мне скажете о причинах, побудивших короля французского взять крест, — сказал он, поднимая брови и указывая пальцем на чернильницу, — ";

    static int step = 5;


    public static void main(String[] args) {

        System.out.println(textTest);
        String res = makeCezar(textTest);
        System.out.println(res);

    }

    private static String makeCezar(String text) {
        String result = "";


        for (int i = 0; i < text.length(); i++) {
            String letter = String.valueOf(text.charAt(i));

            result = result + convertLetter(letter);

        }

        return result;
    }

    static String convertLetter(String letter)
    {
        String converted = letter;

        int index = alphabet.indexOf(letter.toLowerCase());

        if (index >= 0)
        {
            index=index+step;
            if (index > alphabet.length()) {
                index = index - alphabet.length();
            }

            converted = String.valueOf(alphabet.charAt(index));
        }

        return converted;
    }
}