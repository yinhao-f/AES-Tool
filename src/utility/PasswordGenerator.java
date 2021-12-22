package utility;

import javax.crypto.SecretKey;
import java.io.File;

public class PasswordGenerator {
    public static String generate(String keyFilePath, String message) {
        // Get key from file
        File keyFile = new File(keyFilePath);
        SecretKey secretKey = Encryption.keyRetriever(keyFile);

        // Encrypt message
        return Encryption.encode(message, secretKey);
    }

    public static String decodePassword(String keyFileName, String message) {
        File keyFile = new File(keyFileName);
        SecretKey secretKey = Encryption.keyRetriever(keyFile);

        return Encryption.decode(message, secretKey);
    }
}
