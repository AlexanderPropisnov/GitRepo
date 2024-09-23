import java.util.Scanner;

class SelectionContext {

    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
        return this.algorithm.select(persons);
    }
}

interface PersonSelectionAlgorithm {

    Person[] select(Person[] persons);
}

class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {

    private final int k;

    public TakePersonsWithStepAlgorithm(int step) {
        this.k = step;
    }

    @Override
    public Person[] select(Person[] persons) {
        // Calculate the size of the resulting array
        int resultSize = (persons.length + k - 1) / k; // This ensures we round up any fractional part

        // Create a new array to store the selected persons
        Person[] result = new Person[resultSize];

        // Select every nth person
        for (int i = 0, j = 0; i < persons.length; i++) {
            if (i % k == 0) {
                result[j++] = persons[i];
            }
        }

        // Return the new array containing the selected persons
        return result;
    }
}


class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {

    private final int k;

    public TakeLastPersonsAlgorithm(int count) {
        this.k = count;
    }

    @Override
    public Person[] select(Person[] persons) {
        int startIndex = persons.length - k;

        // Create a new array to store the last n persons
        Person[] result = new Person[k];

        // Copy the last n persons into the new array
        for (int i = 0; i < k; i++) {
            result[i] = persons[startIndex + i];
        }

        // Return the new array containing the last n persons
        return result;
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine());
        final Person[] persons = new Person[count];

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine());
        }

        final String[] configs = scanner.nextLine().split("\\s+");

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1]));
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg);

        final Person[] selected = ctx.selectPersons(persons);
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}