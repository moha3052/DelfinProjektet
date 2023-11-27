import java.io.File;
import java.util.ArrayList;

public class DataBase {

    private ArrayList<Medlem> medlemsListe;
    private FileHandler fileHandler;


    private File file = new File("medlemmer.csv");

    public void loadMedlemmerFraCSV(){
        this.medlemsListe = fileHandler.loadMedlemmer();
    }

    public void printMedlemsList(){
        for (Medlem medlem :  medlemsListe) {
            System.out.println(medlem.toString());

        }
    }

    public ArrayList<Medlem> getMedlemsListe(){
        return medlemsListe;
    }

    public DataBase(){
        this.fileHandler = new FileHandler();
        loadMedlemmerFraCSV();
    }

    public void gemOplysningerICSV(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String CompetitionSwimmer){
        fileHandler.gemOplysningerICSV(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
    }

}
