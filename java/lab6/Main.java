package lab6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main() {
        Object lock = new Object();
        Supervisor supervisor = new Supervisor(lock);
        Thread superThread = new Thread(supervisor);
        superThread.start();
    }
}
