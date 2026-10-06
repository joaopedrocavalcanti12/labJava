package lab2.labJava;

public class Descanso {
    private int horasDescanso;
    private int numerosSemana;

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }
    public void defineNumerosSemana(int valor) {
        this.numerosSemana = valor;
    }

    public String getStatusGeral() {
        if (this.numerosSemana > 0  && this.horasDescanso >= 26 * this.numerosSemana) {
            return "Descansado";
        }else {
            return "Cansado";
        }
    }

}
