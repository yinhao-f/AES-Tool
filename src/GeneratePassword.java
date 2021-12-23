import utility.PasswordGenerator;

public class GeneratePassword {
    public static void main(String[] args) {
        String keyFile = "2021.12.23-17'23'22.key";

        String password = PasswordGenerator.generate(keyFile, "gitlab");

        System.out.println("Full length password: " + password);
        System.out.println("16-character password: " + password.substring(0,8));
    }
}
