package computer.security.a1;

public class Decrypter {

  private String letters = "abcdefghijklmnopqrstuvwxyz";

  public String decryptBySubstitution(String word, int key) {
    String lowerCaseWord = word.toLowerCase();
    String decryptedWord = "";
    for (int i = 0; i < lowerCaseWord.length(); i++) {
      char currentChar = lowerCaseWord.charAt(i);

      if (!letters.contains(String.valueOf(currentChar))) {
        decryptedWord += currentChar;

      } else {
        int index = (letters.indexOf(currentChar) - key + letters.length()) % letters.length();
        decryptedWord += letters.charAt(index);
      }
    }
    return decryptedWord;
  }

  public String decryptByTransposition(String word) {
    String lowerCaseWord = word.toLowerCase();
    String encryptedWord = "";
    for (int i = lowerCaseWord.length() - 1; i >= 0; i--) {
      char currentChar = lowerCaseWord.charAt(i);
      encryptedWord += currentChar;
    }
    return encryptedWord;
  }

}
