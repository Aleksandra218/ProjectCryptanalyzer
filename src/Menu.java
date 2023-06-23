import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Menu {
    static int key;

//        static String consoleText = "Введите путь к файлу: ";
//    static String consoleText2 = "Введите ключ для шифрования текста: ";
    public static void name() {
        try (InputStream stream = System.in;
             Scanner sc = new Scanner(stream)) {
            System.out.println("Введите путь к файлу: ");
            String path = sc.nextLine();

            System.out.println("Введите ключ для шифрования текста: ");
            key = sc.nextInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        try (InputStream stream = System.in;
//             Scanner console = new Scanner(stream);) {
//            System.out.println(consoleText + console.nextLine());
//            System.out.println(consoleText2 + console.nextInt());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//
//        }
    }
}
