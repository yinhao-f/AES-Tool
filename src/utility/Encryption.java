package utility;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryption {
    private static final Base64.Encoder base64Encoder = Base64.getEncoder();
    private static final Base64.Decoder base64Decoder = Base64.getDecoder();

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String encode(String content, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] byteEncode = content.getBytes(StandardCharsets.UTF_8);
            byte[] byteAES = cipher.doFinal(byteEncode);
            return base64Encoder.encodeToString(byteAES);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decode(String content, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] byteContent = base64Decoder.decode(content);
            byte[] byteDecode = cipher.doFinal(byteContent);
            return new String(byteDecode, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
