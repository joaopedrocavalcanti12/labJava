
package lab2.labJava;

import java.util.Arrays;

public class Disciplina {

    private String nomeDisciplina;
    private int horasEstudo;
    private double nota[];
    private int pesos[];

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[4];
    }

    public Disciplina(String nomeDisciplina, int quantidadeNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[quantidadeNotas];
    }

    public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[quantidadeNotas];
        this.pesos = pesos;
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= this.nota.length) {
            this.nota[nota - 1] = valorNota;
        }
    }

    private double calculaMedia() {
        double soma = 0;

        if (pesos == null) {
            for (double n : this.nota) {
                soma += n;
            }

            return soma / this.nota.length;
        } else {
            int somaPesos = 0;

            for (int i = 0; i < this.nota.length; i++) {
                soma += this.nota[i] * pesos[i];
                somaPesos += pesos[i];
            }

            return soma / somaPesos;
        }
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.nota);
    }
}
