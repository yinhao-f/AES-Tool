package utility;

import javax.crypto.SecretKey;
import java.io.File;

public class PasswordGenerator {

    public static String generate(String keyFilePath, String message) {
        // Get key from file
        File keyFile = new File(keyFilePath);
        SecretKey secretKey = AESUtil.keyRetriever(keyFile);

        // Encrypt message
        byte[] bytes = AESUtil.encodeToBytes(message, secretKey);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte item :
                bytes) {
            int value = (item + 128) % 94 + 33;
            stringBuilder.append((char) value);
        }
        return stringBuilder.toString();
    }
}
