import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Kasseren {

    DataBase dataBase = new DataBase();

    Scanner scanner = new Scanner(System.in);

    public void printKassere() {
        System.out.println();
        System.out.println("Kassere: ");
        System.out.println("_________________");
        System.out.println("1. Oversigt over betaling");
        System.out.println("3. Tilbage til menu");
        System.out.println();
    }
        public void handleKassere () {
            boolean kassereRunning = true;

            while (kassereRunning) {
                printKassere();
                int kassereChoice = scanner.nextInt();

                switch (kassereChoice) {
                    case 1:
                        oversigtOverKontingent();
                    case 3:
                        kassereRunning = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                        break;
                }
            }
        }



    public int oversigtOverKontingent(){
    int totalPris = 0;
        ArrayList<Medlem> medlems = dataBase.getMedlemmer();

        for(Medlem medlem: medlems){
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
         totalPris = totalPris + medlemsPris;
            // totalpris += medlemspris
        }

        return totalPris;


    }

    /*For aktive medlemmer er kontingentet for ungdomssvømmere (under 18 år) 1000 kr. årligt, for seniorsvømmere (18 år og over) 1600 kr. årligt.
    For medlemmer over 60 år gives der 25 % rabat af seniortaksten. For passivt medlemskab er taksten 500 kr. årligt.
    Kassereren vil gerne kunne danne sig et overblik over, hvor meget klubben kan forvente at få indbetalt i kontingent i alt.
    Kassereren har desuden ønsket, at systemet kan vise en oversigt over medlemmer, der er i restance.*/


}
