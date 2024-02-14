package lab6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Supervisor implements Runnable {
    private AbstractProgram program;
    private Thread abstractThread;
    private final Object lock;

    public Supervisor(Object lock) {
        this.lock = lock;
        this.program = new AbstractProgram(lock);
    }

    public void startAbstractThread() {
        abstractThread = new Thread(program);
        abstractThread.start();
    }

    public void restart() {
        System.out.println("The abstractProgram is restarted from supervisor");
        program.setUnknown();
    }

    public void stop() {
        System.out.println("The abstractProgram is finished from supervisor");
        abstractThread.interrupt();
    }

    @Override
    public void run() {
        startAbstractThread();
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(500);
                    lock.wait(); // Ожидает уведомления от другого потока
                    ProgramState tempState = program.getState();
                    if (tempState == ProgramState.STOPPING) {
                        restart();
                    } else if (tempState == ProgramState.FATAL_ERROR) {
                        stop();
                        return;
                    }
                    lock.notify(); // Уведомляет другой поток
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
