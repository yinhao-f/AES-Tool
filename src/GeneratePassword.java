import utility.PasswordGenerator;

public class GeneratePassword {
    public static void main(String[] args) {
        String keyFile = "2021.12.23-17'23'22.key";

        String password = PasswordGenerator.generate(keyFile, "测测测测测");

        System.out.println("Generated password: " + password);
    }
}
