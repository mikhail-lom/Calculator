import file_controller.TypeOS;

import java.io.IOException;

public interface Logger {
    String getFileName();
    String getFilePath(String fileName, TypeOS typeOS);
    void log(String message);
}
