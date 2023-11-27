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



    public Medlem(String birthdate, String fullName, String gender, int idNumber, String email, int phoneNumber, String adress, String isCompetitionSwimmer) {
        this.birthdate = birthdate;
        this.fullName = fullName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
       this.isCompetitionSwimmer = isCompetitionSwimmer;
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

    @Override
    public String toString() {
        return "Medlem: " +
                " FullName = " + fullName + " " +
                " Birthdate = " +  birthdate + " " +
                " Gender = " + gender + " " +
                " IdNumber = " + idNumber + " " +
                " Email = " + email + " " +
                " +45 = " + phoneNumber + " " +
                " Adress = " + adress + " " +
                " IsCompetitionSwimmer = " + isCompetitionSwimmer + '\n';
    }
}
