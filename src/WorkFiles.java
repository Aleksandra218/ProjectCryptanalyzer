import java.io.*;

public class WorkFiles {

    String src = "C:\\Users\\79833\\Downloads\\Development\\NewProject\\ProjectCryptanalyzer\\src\\encryption.txt";
    String dest = "C:\\Users\\79833\\Downloads\\Development\\NewProject\\ProjectCryptanalyzer\\src\\decoding.txt";
    String text = "C:\\Users\\79833\\Downloads\\Development\\NewProject\\ProjectCryptanalyzer\\src\\decipheredText.txt";

    private char origFirstLetter;
    private char decipheredFirstLetter;

    public void encryption() {

        try (FileReader reader = new FileReader(src); //
             FileWriter writer = new FileWriter(dest)) {

//            System.out.println(origFirstLetter);

            while (reader.ready()) {
                char real = (char) reader.read();
                String crypt = CaesarCipher.convertLetter(String.valueOf(real));
                writer.write(crypt);

            }

            var file1 = new FileReader(src);
            origFirstLetter = (char) file1.read();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deciphered() {
        boolean decodeCompleted = true;
        int brutforceStep = 1;
        while (decodeCompleted) {
            try (FileReader reader = new FileReader(dest);
                 FileWriter writer = new FileWriter(text)) {

//                System.out.println("Step = " + brutforceStep);

                while (reader.ready()) {
                    char symbol = (char) reader.read();
                    //0System.out.print(symbol);

                    String encrypt = HacerBrutForce.decoding(String.valueOf(symbol), brutforceStep);
                    writer.write(encrypt);
                }

                var decipheredText = new FileReader(text);
                decipheredFirstLetter = (char) decipheredText.read();

//                System.out.println("origFirstLetter=" + origFirstLetter + ", decipheredFirstLetter=" + decipheredFirstLetter);

                if (String.valueOf(origFirstLetter).equalsIgnoreCase(String.valueOf(decipheredFirstLetter)))
                    decodeCompleted = false;

                brutforceStep++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



