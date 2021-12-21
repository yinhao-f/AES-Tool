import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncodeToFile {

    public static void main(String[] args) throws IOException {
        // Read the secret key
        InputStream inputStream = new FileInputStream("SecretKey.txt");
        StringBuilder stringBuilder = new StringBuilder();
        while (inputStream.available() > 0) {
            stringBuilder.append((char) inputStream.read());
        }

        String keyRead = stringBuilder.toString();
    }

}
