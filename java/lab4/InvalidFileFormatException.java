package lab4;

import java.io.IOException;

class InvalidFileFormatException extends IOException {
    public void printMessage(String message) {
        System.out.println(message);
    }
}