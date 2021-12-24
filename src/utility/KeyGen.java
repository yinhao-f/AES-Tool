package utility;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyGen {
    private void keyGen() {
        // Generate secret key
        try {
            javax.crypto.KeyGenerator generator = javax.crypto.KeyGenerator.getInstance("AES");
            generator.init(128);
            SecretKey secretKey = generator.generateKey();

            // Encode byte array to string using Base64
            String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            // Write key to file
            String filePath = FileHandler.fileNameGenerator("key");
            FileHandler.writeToFile(filePath, keyString);
            System.out.println("Generated key in " + filePath);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
