package hospital.management;
import java.util.*;

public class Hospital {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
    }

    public void showAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }

}
