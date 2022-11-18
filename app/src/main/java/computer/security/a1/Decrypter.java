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

  public String decryptByTransposition(String word, int numberOfColumns) {
    int numberOfRows = (int) Math.ceil(word.length() * 1.0 / numberOfColumns);

    char[][] container = new char[numberOfRows][numberOfColumns];
    int counter = 0;
    for (int i = 0; i < numberOfColumns; i++) {
      for (int j = 0; j < numberOfRows; j++, counter++) {
        if (word.length() > counter) {
          container[j][i] = word.charAt(counter);
        }
      }
    }

    String output = "";
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumns; j++) {
        output += container[i][j];
      }
    }
    return output;
  }
  // String lowerCaseWord = word.toLowerCase();
  // String encryptedWord = "";
  // for (int i = lowerCaseWord.length() - 1; i >= 0; i--) {
  // char currentChar = lowerCaseWord.charAt(i);
  // encryptedWord += currentChar;
  // }
  // return encryptedWord;
  // }

}
