package Logik;

import Database.DataBase;
import Model.Medlem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class KasserLogik {

    private int medlemsPris = 0;

    DataBase dataBase = new DataBase();


    public int oversigtOverKontingent(){
    int totalPris = 0;
        ArrayList<Medlem> medlems = dataBase.getMedlemmer();

        for(Medlem medlem: medlems){

            if (!medlem.getisAktiv()){
                medlemsPris = 500;
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate birthday = LocalDate.parse(medlem.getBirthdate(), formatter);
                LocalDate currentDate = LocalDate.now();
                int age = Period.between(birthday, currentDate).getYears();
                if (age <= 17) {
                    medlemsPris = 1000;
                } else if (age >= 18 && age <= 59) {
                    medlemsPris = 1600;
                } else if (age >= 60) {
                    medlemsPris = 1200;
                }
            }
         totalPris += medlemsPris;
        }
        return totalPris;
    }

    public static int medlemsKontingent(Medlem medlem){
            int medlemsPris = 0;
            if (!medlem.getisAktiv()){
                medlemsPris = 500;
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate birthday = LocalDate.parse(medlem.getBirthdate(), formatter);
                LocalDate currentDate = LocalDate.now();
                int age = Period.between(birthday, currentDate).getYears();
                if (age <= 17) {
                    medlemsPris = 1000;
                } else if (age >= 18 && age <= 59) {
                    medlemsPris = 1600;
                } else if (age >= 60) {
                    medlemsPris = 1200;
                }
            }

        return medlemsPris;


    }
    public double medlemRestance() {
        ArrayList<Medlem> medlems = dataBase.getMedlemsListe();
       //ArrayList<Double> restanceList = new ArrayList<>();
        double tilbageKontingen = 0.0;
        for (Medlem medlem : medlems) {

            tilbageKontingen = medlemsKontingent(medlem) - medlem.getBeløbBetalt();

        }
        return tilbageKontingen;
    }


}
