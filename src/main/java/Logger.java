import java.io.IOException;

public interface Logger {
    String getFileName();
    String getFilePath(String fileName);
    void log(String message) throws IOException;
}
