import utility.FileIO;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
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

        // Generate file name for the key
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = simpleDateFormat.format(currentDate) + ".key";
        File file = new File(fileName);

        // Encode byte array to string using Base64
        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Write key to file
        FileIO.writeToFile(file, keyString);

        System.out.println("Generated key in " + file.getAbsolutePath());
    }
}
