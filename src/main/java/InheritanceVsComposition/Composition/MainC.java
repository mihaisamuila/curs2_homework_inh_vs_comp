package InheritanceVsComposition.Composition;

import java.io.IOException;

public class MainC {


    public static void main(String[] args) throws IOException {

        InMemoryPersonReportGeneratorC providerMem = new InMemoryPersonReportGeneratorC();
        new ReportGeneratorC(providerMem).generateReport("Lista_persoane_in_memory_Com");


        FilePersonReportGeneratorC providerFile = new FilePersonReportGeneratorC("src/main/resources/people.txt");
        new ReportGeneratorC(providerFile).generateReport("Lista_persoane_from_file_Com");


    }


}
