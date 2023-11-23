import java.util.ArrayList;

public class DataBase {

    public ArrayList<Medlem> getMedlemsArrayList(){
        return MedlemsArrayList;
    }

    private ArrayList<Medlem> MedlemsArrayList;

    public DataBase(){
        MedlemsArrayList = new ArrayList<>();
    }

    public void tilføjMedlemmer(String birthdate, String fullName, String gender, String idNumber, String email, int phoneNumber, String adress, boolean activeMembership, boolean inactiveMembership, boolean seniorSwimmer, boolean competitionSwimmer, boolean isJunior, boolean isExerciser){
      MedlemsArrayList.add(new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, activeMembership, inactiveMembership, seniorSwimmer, competitionSwimmer, isJunior, isExerciser));
    }

    public void printMedlemmer(){
        for (int i =0; i<MedlemsArrayList.size(); i++){

            System.out.println(MedlemsArrayList.get(i));
            System.out.println("_______________________________");


        }
    }


    public void tilføjMedlemmer(boolean validDate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String swimmerType) {
    }
}
