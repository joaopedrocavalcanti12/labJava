package lab2.labJava;

public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    public String getStatusGeral() {
        if (this.numeroSemanas > 0  && this.horasDescanso >= 26 * this.numeroSemanas) {
            return "Descansado";
        }else {
            return "Cansado";
        }
    }

}
