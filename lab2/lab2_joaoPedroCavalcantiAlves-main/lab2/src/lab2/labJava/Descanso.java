package lab2.labJava;

/**
 * Representa a rotina de descanso de um aluno.
 * O aluno é considerado descansado quando descansa 26 horas por semana
 * ou mais (sem contar as horas de sono). Se nenhuma hora de descanso ou
 * número de semanas for registrado, o aluno começa cansado.
 *
 * @author João Pedro Cavalcanti Alves
 */
public class Descanso {

    /** Total de horas de descanso registradas. */
    private int horasDescanso;

    /** Número de semanas em que as horas de descanso foram acumuladas. */
    private int numeroSemanas;

    /**
     * Define o total de horas de descanso do aluno.
     *
     * @param valor o total de horas de descanso
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o número de semanas em que as horas de descanso foram acumuladas.
     *
     * @param valor o número de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Retorna o estado geral de descanso do aluno. O aluno é considerado
     * descansado se descansou pelo menos 26 horas por semana; caso contrário,
     * ou se não houver número de semanas registrado, é considerado cansado.
     *
     * @return "descansado" ou "cansado", de acordo com a rotina de descanso
     */
    public String getStatusGeral() {
        if (this.numeroSemanas > 0 && this.horasDescanso >= 26 * this.numeroSemanas) {
            return "descansado";
        } else {
            return "cansado";
        }
    }

}
