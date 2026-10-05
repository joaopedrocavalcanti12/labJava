package labJava;

public class Descanso {
    private int horasDescanso;
    private int numerosSemana;

    public void defineHorasDescanso(int horasDescanso) {
        this.horasDescanso = horasDescanso;
    }
    public void defineNumerosSemana(int numerosSemana) {
        this.numerosSemana = numerosSemana;
    }

    public String getStatusGeral() {
        if (horasDescanso >= 8  && numerosSemana >= 5) {
            return "Descansado";
        }else {
            return "Cansado";
        }
    }

}
