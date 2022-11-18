package computer.security.a1;

public class Encrypter {

  private String letters = "abcdefghijklmnopqrstuvwxyz";

  public String encryptBySubstitution(String word, int key) {
    String lowerCaseWord = word.toLowerCase();
    String encryptedWord = "";
    for (int i = 0; i < lowerCaseWord.length(); i++) {
      char currentChar = lowerCaseWord.charAt(i);

      if (!letters.contains(String.valueOf(currentChar))) {
        encryptedWord += currentChar;

      } else {
        int index = (letters.indexOf(currentChar) + key) % letters.length();
        encryptedWord += letters.charAt(index);
      }
    }
    return encryptedWord;

  }

  public String encryptByTransposition(String word, int numberOfColumns) {
    String output = "";
    int numberOfRows = (int) Math.ceil(word.length() * 1.0 / numberOfColumns);
    System.out.println(numberOfRows);
    char[][] container = new char[numberOfRows][numberOfColumns];
    int counter = 0;

    for (int i = 0; i < numberOfRows; i++) {
      for (int j = 0; j < numberOfColumns; j++, counter++) {
        if (word.length() > counter) {
            container[i][j] = word.charAt(counter);
        }
      }
    }

    for (int j = 0; j < numberOfColumns; j++) {
      for (int i = 0; i < numberOfRows; i++) {
        output += container[i][j];
      }
    }
    return output;

    // String lowerCaseWord = word.toLowerCase();
    // String encryptedWord = "";
    // for (int i = lowerCaseWord.length() - 1; i >= 0; i--) {
    // char currentChar = lowerCaseWord.charAt(i);
    // encryptedWord += currentChar;
    // }
    // return encryptedWord;
  }

}
