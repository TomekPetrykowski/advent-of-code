import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// PART I ------------------------------------------------------------------ //

public class First {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    List<Integer> locations0 = new ArrayList<>();
    List<Integer> locations1 = new ArrayList<>();
    int similarity = 0;

    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream("data.txt")))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] pair = line.split("   ");
            locations0.add(Integer.valueOf(pair[0]));
            locations1.add(Integer.valueOf(pair[1]));
        }
    }

    Collections.sort(locations0);
    Collections.sort(locations1);

    for (int i = 0; i < locations0.size(); i++) {
      int locationSimScore = 0;

      for (int j = 0; j < locations1.size(); j++) {
          if (locations0.get(i).equals(locations1.get(j))) {
            locationSimScore += 1;
          }
      }

      similarity += locations0.get(i) * locationSimScore;
    }

    System.out.println(similarity);
  }
}