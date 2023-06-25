import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HacerBrutForce {

    String pathOriginalFile;
    String pathEncodingFile;
    String pathDecodingFile;

    public HacerBrutForce(String pathOriginalFile, String pathEncodingFile, String pathDecodingFile) {
        this.pathOriginalFile = pathOriginalFile;
        this.pathEncodingFile = pathEncodingFile;
        this.pathDecodingFile = pathDecodingFile;
    }

    public void deciphered() {
        String origFirstLetter = "";
        try {
            var file1 = new FileReader(pathOriginalFile);
            char letter = (char) file1.read();
            origFirstLetter = String.valueOf(letter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean decodeCompleted = true;
        int brutforceStep = 1;
        while (decodeCompleted) {
            try (FileReader reader = new FileReader(pathEncodingFile);
                 FileWriter writer = new FileWriter(pathDecodingFile)) {


                while (reader.ready()) {
                    char symbol = (char) reader.read();


                    String encrypt = CaesarCipher.decodingLetterByStep(String.valueOf(symbol), brutforceStep);
                    writer.write(encrypt);
                }

                var decipheredText = new FileReader(pathDecodingFile);
                var decipheredFirstLetter = (char) decipheredText.read();

                if (origFirstLetter.equalsIgnoreCase(String.valueOf(decipheredFirstLetter))) {
                    decodeCompleted = false;
                    System.out.println("Найденный ключ=" + brutforceStep);
                }

                brutforceStep++;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
