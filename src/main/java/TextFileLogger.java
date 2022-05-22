import file_controller.TypeOS;

import java.io.*;

public class TextFileLogger implements Logger {
    String fileName;
    String filePath;
    TypeOS typeOS;

    TextFileLogger(String fName) {
        fileName = fName;

    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getFilePath(String fileName, TypeOS typeOS) {

        if (typeOS == TypeOS.WINDOWS) {
            filePath = fileName.toLowerCase();
            return filePath;
        } else {
            filePath = "Illegal OS Type!";
        }
        filePath = fileName.toUpperCase();
        return filePath;
    }

    @Override
    public void log(String message) {
        String buffer = message.concat("\n");
        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter(fileName, true);
            out = new BufferedWriter(fstream);
            out.write(buffer);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
