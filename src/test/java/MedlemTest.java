import Model.Medlem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedlemTest {
        @Test
        public void testGettersAndSetters() {
            Medlem medlem = new Medlem("01-01-2000", "John Doe", "Male", 123, "john@example.com", 123456789, "123 Street", "Yes");
            assertEquals("01-01-2000", medlem.getBirthdate());
            assertEquals("John Doe", medlem.getFullName());
            assertEquals("Male", medlem.getGender());
            assertEquals(123, medlem.getIdNumber());
            assertEquals("john@example.com", medlem.getEmail());
            assertEquals(123456789, medlem.getPhoneNumber());
            assertEquals("123 Street", medlem.getAdress());
            assertEquals("Yes", medlem.getCompetitionSwimmer());
            assertEquals(1000.0, medlem.getBeløbBetalt());
            assertTrue(medlem.getisAktiv());


            medlem.setBirthdate("02-02-2002");
            assertEquals("02-02-2002", medlem.getBirthdate());

            medlem.setFullName("Jane Doe");
            assertEquals("Jane Doe", medlem.getFullName());
            medlem.setisaktiv(false);
            assertFalse(medlem.getisAktiv());
        }
        @Test
        void testToString() {
            // Arrange: Create a Model.Medlem object with sample data
            Medlem medlem = new Medlem("11-01-1980", "Danis Bomer", "mand", 90, "Bomer@yahoo.com", 21212121, "Baggesensgade31", "ja");
            medlem.setBirthdate("11-01-1980");
            medlem.setFullName("Danis Bomer");
            medlem.setGender("mand");
            medlem.setIdNumber(90);
            medlem.setEmail("Bomer@yahoo.com");
            medlem.setPhoneNumber(21212121);
            medlem.setAdress("Baggesensgade31");
            medlem.setCompetitionSwimmer("ja");
            medlem.setisaktiv(true);
            medlem.setBeløbBetalt(1000);

            // Expected string with correct formatting
            String expected = "Model.Medlem: birthdate: 11-01-1980  fullName: Danis Bomer  gender: mand  idNumber: 90  email: Bomer@yahoo.com  phoneNumber: 21212121  adress: Baggesensgade31  CompetitionSwimmer: ja  Aktiv: truerestance1000.0" ;

            // Actual result from toString() method
            String actual = medlem.toString().trim();

            // Print expected and actual strings for inspection
            System.out.println("Expected: " + expected);
            System.out.println("Actual  : " + actual);

            // Perform the assertion
            Assertions.assertEquals(expected, actual);
        }
    }


