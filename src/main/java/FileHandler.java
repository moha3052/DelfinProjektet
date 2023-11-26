import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public void gemOplysningerICSV(String fullName, String birthday, String gender, int idNumber, String email, int phoneNumber, String adress, String CompetitionSwimmer) {
        String csvFile = "medlemmer.csv";
        try {
            FileWriter fileWriter = new FileWriter(csvFile, true); // 'true' for at tilføje til filen i stedet for at overskrive
            PrintWriter printWriter = new PrintWriter(fileWriter);


            String data = String.format("%s,%s,%s,%d,%s,%d,%s,%s\n", fullName, birthday, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);


            printWriter.print(data);


            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til CSV-fil: " + e.getMessage());
        }
    }




}
