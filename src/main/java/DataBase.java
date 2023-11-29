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
   public void gemOplysningerICSV(Medlem medlem){
        fileHandler.gemOplysningerICSV(medlem);
    }

    public void tilføjMedlem(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String CompetitionSwimmer){
        Medlem medlem = new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
        medlemsListe.add(medlem);
        fileHandler.gemOplysningerICSV(medlem);
    }


    public Medlem findMedlemById(int id) {
        for (Medlem medlem : medlemsListe){
            if (medlem.getIdNumber() == id){
                return medlem;
            }
        }
        return null;
    }

    public void opdaterMedlem(Medlem opdateretMedlem) {
        for (int i = 0; i < medlemsListe.size(); i++) {
            if (medlemsListe.get(i).getIdNumber() == opdateretMedlem.getIdNumber()) {
                medlemsListe.set(i, opdateretMedlem);
                return;
            }
        }
    }
}
