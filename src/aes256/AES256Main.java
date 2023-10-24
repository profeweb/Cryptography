package aes256;

public class AES256Main {

    public static void main(String[] args) {
        String originalString = "howtodoinjava.com";

        String encryptedString = AES256Util.encrypt(originalString);
        String decryptedString = AES256Util.decrypt(encryptedString);

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
