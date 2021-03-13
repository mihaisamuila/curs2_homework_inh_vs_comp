package InheritanceVsComposition.Inheiretance;


import InheritanceVsComposition.Person;

import java.util.List;

public class InMemoryPersonReportGeneratorI extends ReportGeneratorI {


    @Override
    protected List<Person> readPersons() {
        return List.of(
                new Person("George", "Georgescu", 101),
                new Person("Vasile", "Vasilescu", 95),
                new Person("Gigel", "Batman", 15)


        );
    }
}
