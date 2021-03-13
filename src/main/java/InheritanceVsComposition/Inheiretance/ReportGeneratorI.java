package InheritanceVsComposition.Inheiretance;

import InheritanceVsComposition.AgeGroup;
import InheritanceVsComposition.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class ReportGeneratorI {


    public void generateReport(String outputFile) throws IOException {
        List<Person> persons = readPersons();
        writeReport(persons, outputFile);
    }

    public void writeReport(List<Person> persons, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {


            for (AgeGroup currentAgeGroup : AgeGroup.values()) {


                if (checkIfExistPersonsInAgeGroup(currentAgeGroup)) {
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

    protected abstract List<Person> readPersons();

    private boolean checkIfExistPersonsInAgeGroup(AgeGroup currentAgeGeoup) {

        for (Person person : readPersons()) {
            if ((person.getAge() <= currentAgeGeoup.getUpperTreshold()) & (person.getAge() >= currentAgeGeoup.getLowerTreshold())) {
                return true;
            }

        }
        return false;
    }


}
