import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Resultater {
    private String type;
    private LocalDate dato;
    private String disciplin;
    private String medlem;
    private int medlemsId;
    private Medlem id;
    private String fullName;
    private String tid;

    public Resultater(String type, String dato, String disciplin, String medlem, int medlemsId, String tid){
        this.type = type;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.dato = LocalDate.parse(dato, formatter);
        this.disciplin = disciplin;
        this.medlem = medlem;
        this.medlemsId = medlemsId;
        this.tid = tid;

    }


    public void setMedlemsId(int medlemsId){
        this.medlemsId = medlemsId;
    }

    public void setDato(LocalDate dato){
        this.dato = dato;
    }

    public void setMedlem(String medlem){
        this.medlem = medlem;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setTid(String tid){
        this.tid = tid;
    }

    public void setDisciplin(String disciplin){
        this.disciplin = disciplin;
    }



    public LocalDate getDato(){
        return dato;
    }

    public String getType(){
        return type;
    }

    public String getmedlem(){
        return medlem;
    }

    public String getTid(){
        return tid;
    }

    public String getDisciplin(){
        return disciplin;
    }

    public int getMedlemsId(){
        return medlemsId;
    }


    @Override
    public String toString() {
        return " Navnet på deltageren:" + " " + medlem + " - " +
                "Type:" + " " + type + " " +
                "Id:" + " " + medlemsId
                + " Dato:" + " " + dato + " "
                + " Tid:" + " " + tid + " " +
                " Diciplin:" + " " + disciplin  + '\n';
    }
}
