package hospital.management;
import java.util.*;

public class Hospital {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
    }

    public void showDoctors() {
        for (Person p : people) {
            if (p instanceof Doctor) {
                System.out.println(p);
            }
        }
    }

    public Person findById(int id) {
        for (Person p : people) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void sortByName() {
        people.sort(Comparator.comparing(Person::getName));
    }

    public void showAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
