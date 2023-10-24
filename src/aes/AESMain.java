package aes;

// https://howtodoinjava.com/java/java-security/java-aes-encryption-example/

public class AESMain {

    public static void main(String[] args){

        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "howtodoinjava.com";

        String encryptedString = AESUtil.encrypt(originalString, secretKey) ;
        String decryptedString = AESUtil.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);

    }
}
