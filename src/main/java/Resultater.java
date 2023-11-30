public class Resultater {
    private String type;
    private String dato;
    private String disciplin;
    private String medlem;
    private double tid;

    public Resultater(String type, String dato, String disciplin, String medlem, double tid){
        this.type = type;
        this.dato = dato;
        this.disciplin = disciplin;
        this.medlem = medlem;
        this.tid = tid;

    }

    public void setDato(String dato){
        this.dato = dato;
    }

    public void setMedlem(String medlem){
        this.medlem = medlem;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setTid(int tid){
        this.tid = tid;
    }

    public void setDisciplin(String disciplin){
        this.disciplin = disciplin;
    }



    public String getDato(){
        return dato;
    }

    public String getType(){
        return type;
    }

    public String getmedlem(){
        return medlem;
    }

    public double getTid(){
        return tid;
    }

    public String getDisciplin(){
        return disciplin;
    }


    @Override
    public String toString() {
        return "Type" + type +
                "Dato" + dato +
                "Tid" + tid +
                "diciplin" + disciplin;
    }
}
