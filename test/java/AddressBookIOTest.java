import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIOTest {

    @Test
    public void givenCSV_FileWhenRead_ShouldReturnTrue() throws IOException{
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        boolean result = addressBookFileIO.readDataFromCSVFile();
        Assertions.assertTrue(result);
    }

    @Test
    public void givenCSVFile_WhenWrite_ShouldReturnTrue() {
        ArrayList<String[]> contacts = new ArrayList<>();
        String[] contact1 = {"Kalpesh", "dha", "mum", "pan", "Mah", "523001", "8106261925", "lkjk388@gmail.com"};
        contacts.add(contact1);
        AddressBookFileIO opencsv=new AddressBookFileIO();
        boolean result = opencsv.writeIntoCSVFile(contacts);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenJsonFile_WhenWrite_ShouldReturnTrue() {
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        List<Contact> contactList = new ArrayList<>();
        Contact contact1 = new Contact("Kalpesh", "dha", "mum", "pan", "Mah", "523001", "8106261925", "lkjk388@gmail.com");
        contactList.add(contact1);
        boolean b = addressBookFileIO.writeIntoJsonFile(contactList);
        Assertions.assertTrue(b);
    }

    @Test
    public void givenJsonFile_WhenRead_ShouldReturnTrue() {
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        boolean b = addressBookFileIO.readIntoJsonFile();
        Assertions.assertTrue(b);
    }
}
