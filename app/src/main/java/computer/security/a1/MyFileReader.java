package computer.security.a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MyFileReader {

  private String text;

  public String readFromFile(String path) {
    
    try {
      BufferedReader filereader = new BufferedReader(new FileReader(path));
      String line;
      this.text = "";
      while ((line = filereader.readLine()) != null) {
        text += line + "\n";
      }
      filereader.close();
      
    } catch (IOException e) {
      System.out.println(e.toString());
    }
    
    return this.text;
  }

  
}
