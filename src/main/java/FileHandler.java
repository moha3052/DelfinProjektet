import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    public ArrayList<Medlem> loadMedlemmer(){
        ArrayList<Medlem> visAlleMedlemmer = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("medlemmer.csv"))){

            while( scanner.hasNextLine()){
                String[] parts = scanner.nextLine().split(";");
                String fullName = parts[0];
                String birthdate = parts[1];
                String gender = parts[2];
                int idNumber = Integer.parseInt(parts[3].trim());
                String email = parts[4];
                int phoneNumber = Integer.parseInt(parts[5].trim());
                String adress = parts[6];
                String isCompetitionSwimmer = parts[7];
                Medlem medlem = new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, isCompetitionSwimmer);
                visAlleMedlemmer.add(medlem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return visAlleMedlemmer;
    }

    public void gemMedlemslisteTilCSV(ArrayList<Medlem> medlemsListe) {
        try (PrintStream output = new PrintStream(new File("medlemmer.csv"))) {
            for (Medlem medlem : medlemsListe) {
                output.println(medlem.getFullName() + ";" + medlem.getBirthdate() + ";"
                        + medlem.getGender() + ";" + medlem.getIdNumber() + ";" + medlem.getEmail() +
                        ";" + medlem.getPhoneNumber() + ";" + medlem.getAdress() + ";" + medlem.getCompetitionSwimmer());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



