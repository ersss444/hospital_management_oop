package hospital.management;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public abstract String getRole();

    @Override
    public String toString() {
        return "ID=" + id + ", Name='" + name + "', Role=" + getRole();
    }

    @Override
    public boolean equals(Object O) {
        if(this == O) return true;
        if(!(O instanceof Person)) return false;
        Person p = (Person) O;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
