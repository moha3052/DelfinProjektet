import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    public void testLoadMedlemmer() {
        FileHandler fileHandler = new FileHandler();
        ArrayList<Medlem> medlemsListe = fileHandler.loadMedlemmer();
        assertNotNull(medlemsListe);
        assertFalse(medlemsListe.isEmpty());
    }
    @Test
    public void testLoadResultater() {
        FileHandler fileHandler = new FileHandler();
        ArrayList<Resultater> resultaterList = fileHandler.loadResultater();
        assertNotNull(resultaterList);
        assertFalse(resultaterList.isEmpty());
    }
    @Test
    public void testGemResultaterICsv() {
        FileHandler fileHandler = new FileHandler();
        ArrayList<Resultater> resultaterList = new ArrayList<>();
        resultaterList.add(new Resultater("Type1", "01-01-2023", "Discipline1", "Member1", 1, "10:30"));
        resultaterList.add(new Resultater("Type2", "02-02-2023", "Discipline2", "Member2", 2, "11:45"));
        fileHandler.gemResultaterICsv(resultaterList);
        ArrayList<Resultater> loadedResultaterList = fileHandler.loadResultater();
        ArrayList<String> expectedStrings = new ArrayList<>();
        for (Resultater resultater : resultaterList) {
            expectedStrings.add(resultater.toString());
        }
        ArrayList<String> actualStrings = new ArrayList<>();
        for (Resultater resultater : loadedResultaterList) {
            actualStrings.add(resultater.toString());
        }
        assertLinesMatch(expectedStrings.stream(), actualStrings.stream());
    }
    @Test
    public void testGemMedlemslisteTilCSV() {
        File tempFile = new File("tempMedlemmer.csv");
        ArrayList<Medlem> testMedlemsListe = new ArrayList<>();
        FileHandler fileHandler = new FileHandler();
        fileHandler.gemMedlemslisteTilCSV(testMedlemsListe);
        tempFile.delete();
    }

}