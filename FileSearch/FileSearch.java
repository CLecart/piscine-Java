import java.io.File;

public class FileSearch {

    public static String searchFile(String fileName) {
        File root = new File("documents");
        return searchRecursive(root, fileName);
    }

    private static String searchRecursive(File folder, String fileName) {
        if (folder == null || !folder.exists()) {
            return null;
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().equals(fileName)) {
                    return f.getPath();
                } else if (f.isDirectory()) {
                    String result = searchRecursive(f, fileName);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        return null;
    }
}