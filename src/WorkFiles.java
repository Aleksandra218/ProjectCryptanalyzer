import java.io.*;

public class WorkFiles {

    String src = "C:\\Users\\79833\\Downloads\\Development\\NewProject\\ProjectCryptanalyzer\\src\\encryption.txt";
    String dest = "C:\\Users\\79833\\Downloads\\Development\\NewProject\\ProjectCryptanalyzer\\src\\decoding.txt";

    public void encryption() {

        try(FileReader reader = new FileReader(src); //
            FileWriter writer = new FileWriter(dest))
        {
            while (reader.ready()) {
                char real = (char) reader.read();
                String cript = CaesarCipher.convertLetter(String.valueOf(real));
                writer.write(cript);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


