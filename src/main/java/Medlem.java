public class Medlem {

    private String birthdate;
    private String fullName;
    private String gender;
    private String idNumber;
    private String email;
    private int phoneNumber;
    private String adress;
    private boolean isActiveMembership;
    private boolean isInactiveMembership;
    private boolean isCompetitionSwimmer;
    private boolean isExerciser;
    private boolean isJunior;
    private boolean isSenior;



    public Medlem(String birthdate, String fullName, String gender, String idNumber, String email, int phoneNumber, String adress, boolean activeMembership, boolean inactiveMembership, boolean seniorSwimmer, boolean competitionSwimmer, boolean isJunior, boolean isExerciser) {
        this.birthdate = birthdate;
        this.fullName = fullName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.isActiveMembership = activeMembership;
        this.isInactiveMembership = inactiveMembership;
        this.isSenior = seniorSwimmer;
        this.isCompetitionSwimmer = competitionSwimmer;
        this.isJunior = isJunior;
        this.isExerciser = isExerciser;
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

    public void setIdNumber(String idNumber) {
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

    public void setActiveMembership(boolean isActiveMembership) {
        this.isActiveMembership = isActiveMembership;
    }

    public void setInactiveMembership(boolean isInactiveMembership) {
        this.isInactiveMembership = isInactiveMembership;
    }
    public void setSenior(boolean isSenior) {
        this.isSenior = isSenior;
    }

    public void setCompetitionSwimmer(boolean isCompetitionSwimmer) {
        this.isCompetitionSwimmer = isCompetitionSwimmer;
    }

    public void setJunior(boolean isJunior) {
        this.isJunior = isJunior;
    }

    public void setExerciser(boolean isExerciser) {
        this.isExerciser = isExerciser;
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

    public String getIdNumber() {
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

    public boolean getActiveMembership() {
        return isActiveMembership;
    }

    public boolean getInactiveMembership() {
        return isInactiveMembership;
    }

    public boolean getSeniorSwimmer() {
        return isSenior;
    }

    public boolean getCompetitionSwimmer() {
        return isCompetitionSwimmer;
    }

    public boolean isJunior() {
        return isJunior;
    }

    public boolean isExerciser() {
        return isExerciser;
    }



}
