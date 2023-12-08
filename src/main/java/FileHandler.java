import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    public ArrayList<Medlem> loadMedlemmer(){
        ArrayList<Medlem> visAlleMedlemmer = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("medlemmer.csv"))){

            while(scanner.hasNextLine()){
                String[] parts = scanner.nextLine().split(";");
                String fullName = parts[0];
                String birthdate = parts[1];
                String gender = parts[2];
                int idNumber = Integer.parseInt(parts[3].trim());
                String email = parts[4];
                int phoneNumber = Integer.parseInt(parts[5].trim());
                String adress = parts[6];
                String isCompetitionSwimmer = parts[7];
                boolean isAktiv =  Boolean.parseBoolean(parts[8]);
                boolean restance = Boolean.parseBoolean(parts[9]);
                int beløbBetalt = Integer.parseInt(parts[10]);
                Medlem medlem = new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, isCompetitionSwimmer, isAktiv, restance, beløbBetalt);
                visAlleMedlemmer.add(medlem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return visAlleMedlemmer;
    }

    public ArrayList<Resultater> loadResultater() {
        ArrayList<Resultater> resultater = new ArrayList<>();
        try (Scanner input = new Scanner(new File("Resultater.csv"))) {
            while (input.hasNextLine()) {
                String[] parts = input.nextLine().split(";");
                String type = parts[0];
                String dato = parts[1];
                String diciplin = parts[2];
                String navn = parts[3];
                int medlemsId = Integer.parseInt(parts[4].trim());;
                String tid = parts[5];
                Resultater training = new Resultater(type,dato,diciplin,navn,medlemsId,tid);
                resultater.add(training);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultater;
    }

    public void gemResultaterICsv(ArrayList<Resultater> trainingArrayList) {
        try (PrintStream output = new PrintStream(new File("Resultater.csv"));){
                for (Resultater training : trainingArrayList) {
                    output.println(training.getType() + ";" + training.getDato() +
                            ";" + training.getDisciplin() + ";" + training.getmedlem() +
                            ";" + training.getMedlemsId() + ";" + training.getTid());
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
        }
    }

    public void gemMedlemslisteTilCSV(ArrayList<Medlem> medlemsListe) {
        try (PrintStream output = new PrintStream(new File("medlemmer.csv"))) {
            for (Medlem medlem : medlemsListe) {
                output.println(medlem.getFullName() + ";" + medlem.getBirthdate() + ";"
                        + medlem.getGender() + ";" + medlem.getIdNumber() + ";" + medlem.getEmail() +
                        ";" + medlem.getPhoneNumber() + ";" + medlem.getAdress() + ";" + medlem.getCompetitionSwimmer() +  ";"
                        + medlem.getisAktiv() + ";" + medlem.getRestance() + ";" + medlem.getBeløbBetalt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}



