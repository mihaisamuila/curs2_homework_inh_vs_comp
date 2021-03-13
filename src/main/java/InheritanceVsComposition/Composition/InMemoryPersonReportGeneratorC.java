package InheritanceVsComposition.Composition;


import InheritanceVsComposition.Person;

import java.util.List;

public class InMemoryPersonReportGeneratorC implements PersonProvider {


    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Ion", "Ionescu", 70),
                new Person("Gherorghe", "Miselescu", 30),
                new Person("Fernando", "Superman", 20)


        );
    }


}
