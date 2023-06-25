import java.io.*;

public class WorkFilesCryption {

    public static String pathOriginalFile;
    public static String pathEncodingFile;
    public static String pathDecodingFile;

    /**
     * шифрует файл методом цезаря
     */
    public void encryption() {


        try (FileReader reader = new FileReader(pathOriginalFile); //
             FileWriter writer = new FileWriter(pathEncodingFile)) {

            while (reader.ready()) {
                char real = (char) reader.read();
                String crypt = CaesarCipher.encodingLetter(String.valueOf(real));
                writer.write(crypt);
            }

            System.out.println("Encoding path=" + pathEncodingFile);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * дешифрует файл методом цезаря
     */
    public void decoding()
    {
        System.out.println("Encoding path=" + pathEncodingFile);

        try (FileReader reader = new FileReader(pathEncodingFile); //
             FileWriter writer = new FileWriter(pathDecodingFile)) {

            while (reader.ready()) {
                char real = (char) reader.read();
                String crypt = CaesarCipher.decodingLetter(String.valueOf(real));
                writer.write(crypt);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * возвращает имя файла без пути и расширения
     * @param fileName полный путь к файлу
     * @return имя файла без расширения(например .txt)
     */
    public static String getFileNameWithOutExtension(String fileName) {
        if (fileName.indexOf(".") > 0) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return fileName;
        }
    }
}



