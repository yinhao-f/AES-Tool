import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class GenerateKeyToFile {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        // Generate secret key
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey secretKey = generator.generateKey();

        // Save the key to a file
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = simpleDateFormat.format(currentDate) + ".key";

        OutputStream f = new FileOutputStream(fileName);
        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        f.write(keyString.getBytes(StandardCharsets.UTF_8));
        f.flush();
        f.close();

        // Read the secret key
//        InputStream inputStream = new FileInputStream("SecretKey.txt");
//        StringBuilder stringBuilder = new StringBuilder();
//        while (inputStream.available() > 0) {
//            stringBuilder.append((char) inputStream.read());
//        }
//        String keyRead = stringBuilder.toString();
//        System.out.println(keyRead);
    }
}
