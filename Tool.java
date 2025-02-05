import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;


public class Tool {
    public static void main(String[] args) {
        
        process_command(args);
    }

    private static void process_command(String[] args) {
        if(args.length == 0)
            return;
        if(args.length > 2) {
            System.out.println("Invalid number of arguments passed.\nExpected 2 arguments, but %d were passed.".formatted(args.length));
            return;
        }

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
                    break;
                }
                catch(FileNotFoundException ex) {
                    printFileNotFound(fileName);
                    break;
                }
                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            case "-w":
                try {
                    String line;
                    BufferedReader br = new BufferedReader(new FileReader(fileName));
                    long wordCount = 0;
                    while((line = br.readLine()) != null) {
                        String currentLine = line.trim();
                        if(currentLine.equals(""))
                            continue;
                        String[] wordArray = currentLine.split(" ");
                        int numberWordCurrentLine = wordArray.length;
                        wordCount += numberWordCurrentLine;

                    }
                    System.out.println(wordCount + " " + fileName);
                    br.close();
                    break;
                }
                catch(FileNotFoundException ex) {
                    printFileNotFound(fileName);
                    break;
                }
                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }

            }
        }

    private static void printFileSize(File file, String fileName) {
        if(!file.exists()) {
            printFileNotFound(fileName);
            return;
        }
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

    private static void printFileNotFound(String fileName) {
        System.out.println("File %s not found".formatted(fileName));
    }
}