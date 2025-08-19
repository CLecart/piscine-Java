import java.io.FileOutputStream;
import java.io.IOException;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Error");
            return;
        }
        System.in.transferTo(new FileOutputStream(args[0]));
    }
}