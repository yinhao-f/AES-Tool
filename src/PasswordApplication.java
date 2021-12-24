import utility.PwGenerator;

public class PasswordApplication {
    public static void main(String[] args) {
        String keyFile = "2021.12.23-17'23'22.key";
        String password = PwGenerator.generate(keyFile, "gitlab");
        System.out.println("Generated password: " + password);
    }
}
