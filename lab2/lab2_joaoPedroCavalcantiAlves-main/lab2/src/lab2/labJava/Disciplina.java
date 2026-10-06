package lab2.labJava;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double nota[];
    ;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[4];
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
            this.nota[nota - 1] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;
        for (double n : this.nota) {
            soma += n;
        }
        return soma / 4;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.nota);
    }
}

