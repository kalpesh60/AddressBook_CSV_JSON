import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddressBookFileIO {

    private static String fileName = "AddressBook.csv";

    public static boolean readDataFromCSVFile() throws IOException {
        if (Files.exists(Paths.get(fileName))) {
            Path filePath = Paths.get(fileName);
            if (Files.exists(filePath)) {
                CSVReader csvreader = new CSVReader(new FileReader(String.valueOf(filePath)));
                String[] line = csvreader.readNext();
                while (line != null) {
                    System.out.println(line);
                    line = csvreader.readNext();
                }
                csvreader.close();
            }
        }
        return true;
    }

    public static boolean writeIntoCSVFile(ArrayList<String[]> addContact) {
        if (Files.exists(Paths.get(fileName))) {
            Path filePath = Paths.get(fileName);
            try {
                if (Files.exists(filePath)) {
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                } else {
                    Files.createFile(filePath);
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        } else return false;
    }
}