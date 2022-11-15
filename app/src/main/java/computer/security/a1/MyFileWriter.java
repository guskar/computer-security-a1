package computer.security.a1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MyFileWriter {

  public void writeToFile(String decrypted) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/gustavkarlberg/kurser/1dv700/computer-security-a1/encryptedText.txt"));
      writer.write(decrypted);
      writer.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
}
