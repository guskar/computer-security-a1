package computer.security.a1;

import java.util.Scanner;

public class Mainapp {
  MyFileReader myFileReader = new MyFileReader();
  MyFileWriter myFileWriter = new MyFileWriter();
  Encrypter e = new Encrypter();
  Decrypter d = new Decrypter();

  public void run() {

    Scanner reader = new Scanner(System.in, "UTF-8");
    String userinput;

    do {
      System.out.println("Welcome to my awesome encrypter/decrypter");
      System.out.println("Please choose an option");
      System.out.println("A: Encrypt B: Decrypt C: Close");

      userinput = reader.next();

      switch (userinput) {
        case "A":
          System.out.println("Please choose a method");
          System.out.println("A:substitution B:transposition");
          String userInputEncryptionMethod = reader.next();

          if (userInputEncryptionMethod.equals("A")) {
            System.out.println("Enter a key");
            int userInputEncryptKey = reader.nextInt();
            System.out.println("Enter a path");
            String userEncryptionPath = reader.next();
            String text = myFileReader
                .readFromFile(userEncryptionPath);

            String encryptedText = e.encryptBySubstitution(text, userInputEncryptKey);
            myFileWriter.writeToFile(encryptedText);
            System.out.println(encryptedText);
          }

          if (userInputEncryptionMethod.equals("B")) {
            System.out.println("Enter a path");
            String userEncryptionPath = reader.next();
            String text = myFileReader
                .readFromFile(userEncryptionPath);

            String transposedWord = e.encryptByTransposition(text);
            myFileWriter.writeToFile(transposedWord);
            System.out.println(transposedWord);
          }

          break;

        case "B":

          System.out.println("Please choose a method");
          System.out.println("A:substitution B:transposition");
          String userInputDecryptionMethod = reader.next();

          if (userInputDecryptionMethod.equals("A")) {
            System.out.println("Enter a key");
            int userInputDecryptKey = reader.nextInt();
            System.out.println("Enter a path");
            String userDecryptionPath = reader.next();
            String encryptedFromfile = myFileReader
                .readFromFile(userDecryptionPath);
            String decryptedWord = d.decryptBySubstitution(encryptedFromfile, userInputDecryptKey);
            System.out.println(decryptedWord);

          }

          if (userInputDecryptionMethod.equals("B")) {

            System.out.println("Enter a path");
            String userDecryptionPath = reader.next();
            String encryptedFromfile = myFileReader
                .readFromFile(userDecryptionPath);
            String decryptedWord = d.decryptByTransposition(encryptedFromfile);
            System.out.println(decryptedWord);
          }

          break;
          
        case "C":
          System.exit(0);

          break;

        default:
          break;
      }

    } while (!userinput.equals("C"));

    reader.close();

  }

}
