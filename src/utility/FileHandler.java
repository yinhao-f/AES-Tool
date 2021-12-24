package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {

    public static String readFromFile(String filePath) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            StringBuilder stringBuilder = new StringBuilder();

            while (fis.available() > 0) {
                stringBuilder.append((char) fis.read());
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToFile(String filePath, String content) throws IOException {
        // Prevent overwriting key files
        File file = new File(filePath);
        if (file.exists()) {
            throw new IOException("File already exists. Please try another file.");
        }
        try {
            // Open file stream
            FileOutputStream fos = new FileOutputStream(file);

            // Write byte array to file
            fos.write(content.getBytes(StandardCharsets.UTF_8));
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fileNameGenerator(String extension) {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd-HH''mm''ss");

        return simpleDateFormat.format(currentDate) + "." + extension;
    }
}
