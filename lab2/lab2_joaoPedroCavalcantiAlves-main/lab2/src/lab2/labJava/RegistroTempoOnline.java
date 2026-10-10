package lab2.labJava;

/**
 * Registra o tempo (em horas) que o aluno dedica online a uma disciplina
 * remota. Por padrão, considera-se uma disciplina de 60 horas, para a qual
 * são esperadas 120 horas online (o dobro). Mesmo após atingir o tempo
 * esperado, é possível continuar adicionando tempo online.
 *
 * @author João Pedro Cavalcanti Alves
 */
public class RegistroTempoOnline {

    /** Nome da disciplina remota. */
    private String nomeDisciplina;

    /** Tempo online já utilizado na disciplina, em horas. */
    private int tempoOnline;

    /** Tempo online esperado para a disciplina, em horas. */
    private int tempoOnlineEsperado;

    /**
     * Constrói um registro de tempo online a partir do nome da disciplina.
     * O tempo online esperado é o padrão de 120 horas (disciplina de 60 horas).
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Constrói um registro de tempo online a partir do nome da disciplina e
     * do tempo online esperado. Todo registro começa com tempo online zerado.
     *
     * @param nomeDisciplina      o nome da disciplina
     * @param tempoOnlineEsperado o tempo online esperado, em horas
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Adiciona tempo online ao registro da disciplina. O valor é somado ao
     * tempo já registrado.
     *
     * @param tempoOnline a quantidade de horas a ser adicionada
     */
    public void adicionaTempoOnline(int tempoOnline) {
        this.tempoOnline += tempoOnline;
    }

    /**
     * Verifica se o aluno atingiu o tempo online esperado para a disciplina.
     *
     * @return true se o tempo online usado for maior ou igual ao esperado;
     *         false caso contrário
     */
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnline >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a String que representa o registro de tempo online. A
     * representação segue o formato "NOME tempoUsado/tempoEsperado", por
     * exemplo "LP2 32/30".
     *
     * @return a representação em String do registro de tempo online
     */
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}
