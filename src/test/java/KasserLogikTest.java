import Database.DataBase;
import Logik.KasserLogik;
import Model.Medlem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class KasserLogikTest {

        private int medlemsPris = 0;
        ArrayList<KasserLogik> kasserLogikArrayList = new ArrayList<>();


        DataBase dataBase = new DataBase();


        public int oversigtOverKontingent() {
            int totalPris = 0;
            ArrayList<Medlem> medlems = dataBase.getMedlemmer();

            for (Medlem medlem : medlems) {

                if (!medlem.getisAktiv()) {
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
                // totalpris += medlemspris
            }

            return totalPris;
        }

        public int medlemsKontingent(Medlem medlem) {

            if (!medlem.getisAktiv()) {
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
}