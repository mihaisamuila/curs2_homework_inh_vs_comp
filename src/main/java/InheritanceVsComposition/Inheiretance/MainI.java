package InheritanceVsComposition.Inheiretance;

import java.io.IOException;

public class MainI {


    public static void main(String[] args) throws IOException {

        //var generator = new FileCountryReportGenerator("src/main/resources/countries.txt");
        //generator.generateReport("output.txt");

        new InMemoryPersonReportGeneratorI().generateReport("Lista_persoane_in_memory_Inh.txt");

        FilePersonReportGeneratorI generator = new FilePersonReportGeneratorI("src/main/resources/people.txt");
        generator.generateReport("Lista_persoane_from_file_Inh.txt");


    }


}
