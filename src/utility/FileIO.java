package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileIO {
    /**
     * Read string from file
     * @param file the file to be read from
     * @return content of file
     * @throws IOException N/A
     */
    public static String readFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();

        while (fis.available() > 0) {
            stringBuilder.append((char) fis.read());
        }

        return stringBuilder.toString();
    }

    /**
     * Write string to file
     * @param file the file to be read to
     * @param content content of file
     * @throws IOException if file exists, prevent from overwriting
     */
    public static void writeToFile(File file, String content) throws IOException {
        // Prevent overwriting key files
        if (file.exists()) {
            throw new IOException("File already exists. Please try another file.");
        }

        // Open file stream
        FileOutputStream fos = new FileOutputStream(file);

        // Write byte array to file
        fos.write(content.getBytes(StandardCharsets.UTF_8));
        fos.flush();
        fos.close();
    }
}
