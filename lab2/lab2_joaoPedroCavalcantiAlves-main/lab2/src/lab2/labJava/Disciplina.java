
package lab2.labJava;

import java.util.Arrays;

/**
 * Representa uma disciplina cursada por um aluno, com horas de estudo e
 * notas. Por padrão a disciplina possui 4 notas e a média é aritmética (sem
 * arredondamento). Também é possível criar disciplinas com outro número de
 * notas e, opcionalmente, com pesos para o cálculo de uma média ponderada.
 * Notas não cadastradas valem zero e o aluno é aprovado com média maior ou
 * igual a 7.0.
 *
 * @author João Pedro Cavalcanti Alves
 */
public class Disciplina {

    /** Nome da disciplina. */
    private String nomeDisciplina;

    /** Horas de estudo acumuladas na disciplina. */
    private int horasEstudo;

    /** Notas da disciplina. A posição 0 guarda a nota 1, e assim por diante. */
    private double nota[];

    /** Pesos de cada nota para a média ponderada. Se for nulo, a média é aritmética. */
    private int pesos[];

    /**
     * Constrói uma disciplina a partir do seu nome. A disciplina possui 4
     * notas de mesmo peso (média aritmética) e começa sem horas de estudo.
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[4];
    }

    /**
     * Constrói uma disciplina a partir do seu nome e da quantidade de notas.
     * Todas as notas têm o mesmo peso (média aritmética).
     *
     * @param nomeDisciplina  o nome da disciplina
     * @param quantidadeNotas a quantidade de notas da disciplina
     */
    public Disciplina(String nomeDisciplina, int quantidadeNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[quantidadeNotas];
    }

    /**
     * Constrói uma disciplina a partir do seu nome, da quantidade de notas e
     * dos pesos de cada nota, para o cálculo de uma média ponderada. Por
     * exemplo, com 2 notas e pesos [6, 4], a média é calculada como
     * (6 * nota[0] + 4 * nota[1]) / 10.
     *
     * @param nomeDisciplina  o nome da disciplina
     * @param quantidadeNotas a quantidade de notas da disciplina
     * @param pesos           os pesos de cada nota; deve ter o mesmo tamanho
     *                        que a quantidade de notas
     */
    public Disciplina(String nomeDisciplina, int quantidadeNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = new double[quantidadeNotas];
        this.pesos = pesos;
    }

    /**
     * Cadastra horas de estudo para a disciplina. As horas são cumulativas,
     * ou seja, são somadas às previamente cadastradas.
     *
     * @param horasEstudo a quantidade de horas a ser somada
     */
    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    /**
     * Cadastra uma nota da disciplina. Se a nota já tiver sido cadastrada, o
     * valor anterior é substituído. Números de nota fora do intervalo de 1 até
     * a quantidade de notas da disciplina são ignorados.
     *
     * @param nota      o número da nota, de 1 até a quantidade de notas
     * @param valorNota o valor da nota
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= this.nota.length) {
            this.nota[nota - 1] = valorNota;
        }
    }

    /**
     * Calcula a média do aluno na disciplina, sem arredondamento. Se a
     * disciplina não tiver pesos, calcula a média aritmética; caso contrário,
     * calcula a média ponderada.
     *
     * @return a média do aluno na disciplina
     */
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

    /**
     * Verifica se o aluno foi aprovado na disciplina, ou seja, se a média é
     * maior ou igual a 7.0.
     *
     * @return true se o aluno foi aprovado; false caso contrário
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a String que representa a disciplina. A representação segue o
     * formato "NOME horasEstudo media [nota1, nota2, ...]", por exemplo
     * "PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]".
     *
     * @return a representação em String da disciplina
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " " + calculaMedia() + " " + Arrays.toString(this.nota);
    }
}