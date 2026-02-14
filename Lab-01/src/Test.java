import java.util.ArrayList;
import java.util.List;

public class Test {

    record Person(String name, int age, List<String> grades){
        public double length() {
            System.out.println("Age is " + age);
            return age;
        }
    }

    public static void main(String[] args) {
        Person p = new Person("Manish", 20, new ArrayList<>());
        System.out.println(p.name);
        System.out.println(p.age);
        p.grades.add("B");
        p.grades.add("F");
        System.out.println("Grades are: " + p.grades);
        p.length();
        
    }
}
