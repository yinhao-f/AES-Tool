package utility;

import javax.crypto.SecretKey;

public class PwGenerator {

    public static String generate(String keyFilePath, String message) {
        // Get key from file
        SecretKey secretKey = AESUtil.keyRetriever(keyFilePath);

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
