package dsagenerator;

import java.io.*;
import java.security.*;
import java.util.Scanner;

class DSAGenerator {

    public static void main(String[] a) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter KEY SIZE: ");  //1024, 2048
        int keySize = input.nextInt();

        System.out.print("Enter OUTPUT: ");
        String output = input.next();

        String algorithm = "DSA";

        try {
            genKeyPair(keySize,output,algorithm);
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
    }
    private static void genKeyPair(int keySize, String output, String algorithm) throws Exception {

        KeyPairGenerator kg = KeyPairGenerator.getInstance(algorithm);
        kg.initialize(keySize);
        System.out.println();
        System.out.println("KeyPairGenerator Object Info: ");
        System.out.println("Algorithm = "+kg.getAlgorithm());
        System.out.println("Provider = "+kg.getProvider());
        System.out.println("Key Size = "+keySize);
        System.out.println("toString = "+kg.toString());

        KeyPair pair = kg.generateKeyPair();
        PrivateKey priKey = pair.getPrivate();
        PublicKey pubKey = pair.getPublic();
        String fl = output+".pri";
        FileOutputStream out = new FileOutputStream(fl);
        byte[] ky = priKey.getEncoded();
        out.write(ky);
        out.close();
        System.out.println();
        System.out.println("Private Key Info: ");
        System.out.println("Algorithm = "+priKey.getAlgorithm());
        System.out.println("Saved File = "+fl);
        System.out.println("Size = "+ky.length);
        System.out.println("Format = "+priKey.getFormat());
        System.out.println("toString = "+priKey.toString());
        fl = output+".pub";
        out = new FileOutputStream(fl);
        ky = pubKey.getEncoded();
        out.write(ky);
        out.close();
        System.out.println();
        System.out.println("Public Key Info: ");
        System.out.println("Algorithm = "+pubKey.getAlgorithm());
        System.out.println("Saved File = "+fl);
        System.out.println("Size = "+ky.length);
        System.out.println("Format = "+pubKey.getFormat());
        System.out.println("toString = "+pubKey.toString());
    }
}
