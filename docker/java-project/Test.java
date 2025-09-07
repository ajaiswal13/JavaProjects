import java.util.Properties;

public class Test {

    public static void printSystemProperties() {
        System.out.println("Printing system properties");
        Properties properties = System.getProperties();
        System.out.println(properties);
    }

    public static void main(String[] args) {
        System.out.println("Java program started");
        printSystemProperties();
    }
}