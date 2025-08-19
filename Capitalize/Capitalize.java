import java.nio.file.*;

public class Capitalize {
    public static void capitalize(String[] args) {
        if (args == null || args.length <= 0)
            return;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
            String contenu = new String(bytes);

            if (contenu == null || contenu.isEmpty()) {
                return;
            }
            contenu = contenu.trim().replaceAll("\\s+", " ");

            StringBuilder result = new StringBuilder();
            for (String mot : contenu.split("\\s+")) {
                result.append(mot.substring(0, 1).toUpperCase())
                        .append(mot.substring(1).toLowerCase())
                        .append(" ");
            }
            Path path2 = Paths.get(args[1]);
            Files.write(path2, result.toString().trim().getBytes());
        } catch (Exception e) {
        }
    }
}