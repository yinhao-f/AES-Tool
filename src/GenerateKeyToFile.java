import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
        File f = new File(fileName);

        // Prevent overwriting key files
        if (f.exists()) {
            throw new IOException("Key just generated. Please try again later.");
        }

        FileOutputStream fos = new FileOutputStream(f);
        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        fos.write(keyString.getBytes(StandardCharsets.UTF_8));
        fos.flush();
        fos.close();

        System.out.println("Generated key in " + f.getAbsolutePath());
    }
}
