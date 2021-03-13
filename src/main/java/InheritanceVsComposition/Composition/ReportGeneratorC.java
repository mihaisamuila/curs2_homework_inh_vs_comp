package InheritanceVsComposition.Composition;

import InheritanceVsComposition.AgeGroup;
import InheritanceVsComposition.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGeneratorC {


    private final PersonProvider personProvider;

    public ReportGeneratorC(PersonProvider personProvider) {
        this.personProvider = personProvider;
    }


    public void generateReport(String outputFile) throws IOException {
        List<Person> persons = personProvider.readPersons();
        writeReport(persons, outputFile);
    }

    public void writeReport(List<Person> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {


            for (AgeGroup currentAgeGroup : AgeGroup.values()) {


                if (checkIfExistPersonsInAgeGroup(currentAgeGroup, persons)) {
                    writeLine(writer, ("\n" + currentAgeGroup.getAgeGroupDescription()));
                }

                persons.stream()
                        .filter(person -> (person.getAge() <= currentAgeGroup.getUpperTreshold()) & (person.getAge() >= currentAgeGroup.getLowerTreshold()))
                        .map(person -> person.getFirstName() + " " + person.getLastName())
                        .forEach(line -> writeLine(writer, line));


            }


        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkIfExistPersonsInAgeGroup(AgeGroup currentAgeGeoup, List<Person> person) {

        for (Person currentPerson : person) {
            if ((currentPerson.getAge() <= currentAgeGeoup.getUpperTreshold()) & (currentPerson.getAge() >= currentAgeGeoup.getLowerTreshold())) {
                return true;
            }

        }
        return false;
    }


}
