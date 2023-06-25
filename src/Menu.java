import java.nio.file.Path;
import java.util.Scanner;

public class Menu {

    public static void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите один из пунктов меню (введите 1 или 2): ");
        System.out.println("1. Шифрование / расшифровка шифром Цезаря");
        System.out.println("2. Криптоанализ методом brute force");

        int mode = sc.nextInt();

        if (mode == 1)
        {
            startCaesar();
        }
        else if (mode == 2)
        {
            startBrutForce();
        }


    }

    public static void startCaesar() {

        System.out.println("Запуск работы с шифром Цезаря.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        WorkFilesCryption.pathOriginalFile = sc.nextLine();

        Path p = Path.of(WorkFilesCryption.pathOriginalFile);
        String parentPath = p.getParent().toString() + "\\";

        String fileNameWithOutExtension = p.getFileName().toString();
        fileNameWithOutExtension = WorkFilesCryption.getFileNameWithOutExtension(fileNameWithOutExtension);
        WorkFilesCryption.pathEncodingFile = parentPath + fileNameWithOutExtension + "_encoding.txt";
        WorkFilesCryption.pathDecodingFile = parentPath + fileNameWithOutExtension + "_decoding.txt";

        System.out.println("Введите ключ для шифрования текста: ");
        CaesarCipher.key = sc.nextInt();

        var reader = new WorkFilesCryption();
        reader.encryption();
        reader.decoding();
    }

    public static void startBrutForce() {
        System.out.println("Запуск работы криптоанализа методом brute force.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к файлу с оригинальным текстом: ");
        var pathOriginalFile = sc.nextLine();

        System.out.println("Введите путь к файлу с зашифрованным текстом: ");
        var pathEncodingFile = sc.nextLine();

        Path p = Path.of(pathOriginalFile);
        String parentPath = p.getParent().toString() + "\\";

        String fileNameWithOutExtension = p.getFileName().toString();
        fileNameWithOutExtension = WorkFilesCryption.getFileNameWithOutExtension(fileNameWithOutExtension);
        var pathDecodingFile = parentPath + fileNameWithOutExtension + "_decoding.txt";

        var hac = new HacerBrutForce(pathOriginalFile, pathEncodingFile, pathDecodingFile);
        hac.deciphered();
    }
}
