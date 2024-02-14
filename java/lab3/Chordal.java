package lab3;

public abstract class Chordal {

    private String name;

    public Chordal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
