package lab6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

class AbstractProgram implements Runnable {
    private ProgramState state;
    private final Object lock;

    public AbstractProgram(Object lock) {
        state = ProgramState.UNKNOWN;
        System.out.println("UNKNOWN");
        this.lock = lock;
    }

    public void setUnknown() {
        state = ProgramState.UNKNOWN;
        System.out.println("UNKNOWN");
    }

    public void setRunning() {
        state = ProgramState.RUNNING;
        System.out.println("RUNNING");
    }

    public void setStopping() {
        state = ProgramState.STOPPING;
        System.out.println("STOPPING");
    }

    public void setFatalError() {
        state = ProgramState.FATAL_ERROR;
        System.out.println("FATAL_ERROR");
    }

    public ProgramState getState() {
        return state;
    }

    @Override
    public void run() {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    Random random = new Random();
                    int number = random.nextInt(6);
                    switch (number) {
                        case 0, 1 -> setStopping();
                        case 2, 3, 4 -> setRunning();
                        case 5 -> setFatalError();
                    }
                    lock.notify(); // Уведомляет другой поток
                    try {
                        Thread.sleep(500);
                        lock.wait(); // Ожидает уведомления от другого потока
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}