public class Main {

    public static void main(String[] args) {

   ///     System.out.println(textTest);
      //  String res = CaesarCipher.makeCezar(textTest);
      //  System.out.println(res);
        var reader = new WorkFiles();
        reader.encryption();
    }

//        String resDec = methodBrutforce(res);
        //System.out.println(resDec);




//    private static String methodBrutforce(String encrypted) {
//        String resultat = "";
//
//        int stepb = 1;
//        while (stepb <= alphabet.length()) {
//            String res = "";
//            for (int i = 0; i < encrypted.length(); i++) {
//                String letter = String.valueOf(encrypted.charAt(i));
//                res = res + decoding(letter, stepb);
//            }
//
//            resultat = res + "\n\n";
//           // if(res.equals(makeCezar(textTest))) {
//                System.out.println(stepb + " " + res);
//            }
//            stepb++;
//        }
//        return resultat;
//    }
//    static String decoding(String letter, int stepl) {
//        String converted = letter;
//        int index = alphabet.indexOf(letter);
//
//        if (index >= 0) {
//            index = index - stepl;
//            if (index < 0) {
//                index = index + alphabet.length();
//            }
//            converted = String.valueOf(alphabet.charAt(index));
//        }
//        return converted;
//    }
}