import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class FileHandler {
    public void GemMedlem(ArrayList<Medlem> medlemmer) {
        try (PrintStream output = new PrintStream(new File("Medlem.csv"))) {
            for (Medlem medlem : medlemmer) {
                output.println(medlem.getIdNumber() + medlem.getFullName() +
                        ";" + medlem.getBirthdate() + ";" + medlem.getGender() + ";" +
                        ";" + medlem.getEmail() + ";" + medlem.getPhoneNumber() +
                        ";" + medlem.getAdress() + ";" + medlem.getActiveMembership() +
                        ";" + medlem.getInactiveMembership() + ";" + medlem.isJunior() +
                        ";" + medlem.getSeniorSwimmer() + ";" + medlem.isExerciser() +
                        ";" + medlem.getCompetitionSwimmer());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
