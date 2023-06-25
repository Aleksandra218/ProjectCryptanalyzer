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

                var file1 = new FileReader(pathOriginalFile);
                var origFirstLetter = (char) file1.read();

                var decipheredText = new FileReader(pathDecodingFile);
                var decipheredFirstLetter = (char) decipheredText.read();


                if (String.valueOf(origFirstLetter).equalsIgnoreCase(String.valueOf(decipheredFirstLetter))) {
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
