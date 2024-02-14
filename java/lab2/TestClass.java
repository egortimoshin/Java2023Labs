package lab2;

public class TestClass {
    //public TestClass() {}
    @MyAnnotation(value = 5)
    public void run(String name) {
        System.out.println(name + " is runnning..");
    }

    @MyAnnotation(value = 6)
    public void jump(String name) {
        System.out.println(name + " is jumping..");
    }

    public void climb(String name) {
        System.out.println(name + " is climbing..");
    }

    @MyAnnotation(value = 3)
    protected void sleep(String name) {
        System.out.println(name + " is sleeping..");
    }

    @MyAnnotation(value = 4)
    protected void exercise(String name) {
        System.out.println(name + " is exercising..");
    }

    protected void swim(String name) {
        System.out.println(name + " is swimming..");
    }

    @MyAnnotation(value = 1)
    private void write(String name) {
        System.out.println(name + " is writing..");
    }

    @MyAnnotation(value = 2)
    private void read(String name) {
        System.out.println(name + " is reading..");
    }

    private void explore(String name) {
        System.out.println(name + "is exploring..");
    }
}
