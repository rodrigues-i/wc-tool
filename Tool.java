import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Tool {
    public static void main(String[] args) {
        String fileName = args[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}