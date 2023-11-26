import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private File f = new File("medlemmer.csv");



    public ArrayList<Medlem> getMedlemsArrayList(){
        return MedlemsArrayList;
    }

    private ArrayList<Medlem> MedlemsArrayList;

    List<Medlem> medlemsliste = new ArrayList<>();

    public DataBase(){
        MedlemsArrayList = new ArrayList<>();
    }

    public void tilføjMedlemmer(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String CompetitionSwimmer){
      MedlemsArrayList.add(new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress,CompetitionSwimmer));
    }

}
