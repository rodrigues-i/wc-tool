import java.io.File;


public class Tool {
    public static void main(String[] args) {
        if(args.length == 0)
            return;
        String command = args[0];
        String fileName = args[1];
        switch(command) {
            case "-c":
                File file = new File(fileName);
                long fileSize = file.length();
                String outputMsg = fileSize + " " + fileName;
                System.out.println(outputMsg);

        }
    }
}