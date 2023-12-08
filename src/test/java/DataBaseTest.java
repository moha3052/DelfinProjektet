import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DataBaseTest {


        private DataBase database;
        @BeforeAll
        public void setUp() {
            database = new DataBase(false);
        }

        @Test
        public void testLoadMedlemmerFraCSV() {
            DataBase dataBase = new DataBase();
            dataBase.loadMedlemmerFraCSV();
            assertNotNull(dataBase.getMedlemmer());
        }
        @Test
        public void testFindMedlemById() {
            DataBase database = new DataBase();
            Medlem testMedlem = new Medlem("11-01-1980", "Danis Bomer", "mand", 90, "Bomer@yahoo.com", 21212121, "Baggesensgade31", "ja");
            database.getMedlemsListe().add(testMedlem);
            Medlem foundMedlem = database.findMedlemById(testMedlem.getIdNumber());
            assertNotNull(foundMedlem);
            assertEquals(testMedlem.getIdNumber(), foundMedlem.getIdNumber());
        }
        @Test
        public void testTilføjMedlemTilArray() {
            Medlem medlem = new Medlem("11-01-1980", "Danis Bomer", "mand", 90, "Bomer@yahoo.com", 21212121, "Baggesensgade31", "ja");
            int førAntalMedlemmer = database.getMedlemmer().size();
            database.tilføjMedlemTilArray(medlem);
            int efterAntalMedlemmer = database.getMedlemmer().size();
            assertEquals(førAntalMedlemmer + 1, efterAntalMedlemmer);
        }
        @Test
        public void testOpdaterMedlemIDatabase() {
            Medlem medlem = new Medlem("11-01-1980", "Danis Bomer", "mand", 90, "Bomer@yahoo.com", 21212121, "Baggesensgade31", "ja");
            database.tilføjMedlemTilArray(medlem);
            Medlem opdateretMedlem = new Medlem("11-01-1980", "Danis Bomer", "mand", 90, "Bomer@yahoo.com", 21212121, "Baggesensgade31", "ja");
            database.opdaterMedlemIDatabase(opdateretMedlem);
            Medlem fundetMedlem = database.findMedlemById(medlem.getIdNumber());
            assertEquals(opdateretMedlem, fundetMedlem);
        }
    }

