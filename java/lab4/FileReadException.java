package lab4;

import java.io.FileNotFoundException;
import java.io.IOException;

class FileReadException extends IOException {
    public void printMessage(String message) {
        System.out.println(message);
    }
}