import java.util.ArrayList;

public class Medlem {


    private String birthdate;
    private String fullName;
    private String gender;
    private int idNumber;
    private String email;
    private int phoneNumber;
    private String adress;
    private String isCompetitionSwimmer;
    private boolean isAktiv;
    private Medlem id;


    // Denne konstruktør bliver brugt til at oprette et nyt medlem.
    public Medlem(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String isCompetitionSwimmer) {
        this.birthdate = birthdate;
        this.fullName = fullName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
       this.isCompetitionSwimmer = isCompetitionSwimmer;
       this.isAktiv = true;
    }

    // Denne konstruktør bliver brugt til at læse fra csv filen.
    public Medlem(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String isCompetitionSwimmer, boolean isAktiv) {
        this.birthdate = birthdate;
        this.fullName = fullName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.isCompetitionSwimmer = isCompetitionSwimmer;
        this.isAktiv = isAktiv;
    }

    public void setisaktiv(boolean isAktiv){
        this.isAktiv = isAktiv;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void setCompetitionSwimmer(String isCompetitionSwimmer) {
        this.isCompetitionSwimmer = isCompetitionSwimmer;
    }



    public String getBirthdate() {
        return birthdate;
    }
    public Medlem getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public String getCompetitionSwimmer() {
        return isCompetitionSwimmer;
    }

    public boolean getisAktiv(){
        return isAktiv;
    }

    @Override
    public String toString() {
        return "Medlem: " +
                "birthdate: " + birthdate + " " +
                " fullName: " + fullName + " " +
                " gender: " + gender + " "+
                " idNumber: " + idNumber + " " +
                " email: " + email + " " +
                " phoneNumber: " + phoneNumber + " " +
                " adress: " + adress + " " +
                " CompetitionSwimmer: " + isCompetitionSwimmer + " " +
                " Aktiv: " + isAktiv + '\n';
    }


}
