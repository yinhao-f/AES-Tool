import utility.FileIO;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GenerateKeyToFile {
    private void generateKey() throws IOException, NoSuchAlgorithmException {
        // Generate secret key
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);
        SecretKey secretKey = generator.generateKey();

        // Encode byte array to string using Base64
        String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Write key to file
        File file = new File(FileIO.fileNameGenerator("key"));
        FileIO.writeToFile(file, keyString);

        System.out.println("Generated key in " + file.getAbsolutePath());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        GenerateKeyToFile keyGen = new GenerateKeyToFile();
        keyGen.generateKey();
    }
}
