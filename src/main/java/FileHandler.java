import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    public void gemOplysningerICSV(String fullName, String birthday, String gender, int idNumber, String email, int phoneNumber, String adress, String CompetitionSwimmer) {
        String csvFile = "medlemmer.csv";
        try {
            FileWriter fileWriter = new FileWriter(csvFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            String data = String.format("%s,%s,%s,%d,%s,%d,%s,%s\n", fullName, birthday, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);


            printWriter.print(data);


            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til CSV-fil: " + e.getMessage());
        }
    }

    public ArrayList<Medlem> loadMedlemmer(){
        ArrayList<Medlem> visAlleMedlemmer = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("medlemmer.csv"))){
            int index = 1;
            while( scanner.hasNextLine()){
                String[] parts = scanner.nextLine().split(";");
                String birthdate = parts[0];
                String fullName = parts[1];
                String gender = parts[2];
                int idNumber = Integer.parseInt(parts[3].trim());
                String email = parts[4];
                int phoneNumber = Integer.parseInt(parts[5].trim());
                String adress = parts[6];
                String isCompetitionSwimmer = parts[7];
                Medlem medlem = new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, isCompetitionSwimmer);
                visAlleMedlemmer.add(medlem);

                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return visAlleMedlemmer;
    }

    }



