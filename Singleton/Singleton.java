classDiagram
class Excalibur{
    -String name
    -Excalibur INSTANCE$
    -Excalibur(String name)
    +getName() String
    +getInstance()$ Excalibur
}
Excalibur <-- Excalibur

public class Excalibur {
    private String name;
    private static Excalibur INSTANCE;
    private Excalibur(String name);

    public String getName() {
        return name;
    }
    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Excalibur");
        }
        return INSTANCE;
    }
}






















































































