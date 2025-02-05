import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Tool {
    public static void main(String[] args) {
        
        process_command(args);
    }

    private static void process_command(String[] args) {
        if(args.length == 0)
            return;
        String command = args[0];
        String fileName = args[1];
        File file = new File(fileName);
        switch(command) {
            case "-c":
                printFileSize(file, fileName);
                break;
            case "-l":
                try {
                    printNumberLines(fileName);
                }
                catch(FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
        }
    }

    private static void printFileSize(File file, String fileName) {
        long fileSize = file.length();
        String outputMsg = fileSize + " " + fileName;
        System.out.println(outputMsg);
    }

    private static void printNumberLines(String fileName)
    throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        long numberLines = br.lines().count();
        String outputM = "%d %s".formatted(numberLines, fileName);
        System.out.println(outputM);
        br.close();
    }
}