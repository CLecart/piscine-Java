import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException, IOException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        Path path = Paths.get(fileName);
        Files.write(path, content.getBytes());
    }

    public static String getContentFile(String fileName) throws IOException {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        Path path = Paths.get(fileName);
        if
        (!Files.exists(path)) {
            throw new IOException("File does not exist: " + fileName);
        }
        return Files.readString(path);
    }

    public static void deleteFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.err.println("Error deleting file: " + e.getMessage());
            }
        } else {
            System.err.println("File does not exist: " + fileName);
        }
    }
}
