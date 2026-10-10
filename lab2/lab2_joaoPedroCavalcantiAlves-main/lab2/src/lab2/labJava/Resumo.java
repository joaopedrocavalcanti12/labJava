package lab2.labJava;

/**
 * Representa um resumo de estudo, que encapsula um tema e o seu conteúdo.
 * O resumo não está necessariamente associado a uma disciplina, pois o
 * estudo de um tema pode ser útil para diferentes conteúdos.
 *
 * @author João Pedro Cavalcanti Alves
 */
public class Resumo {

    /** Tema do resumo. */
    private String tema;

    /** Conteúdo (texto, descrição ou anotação) referente ao tema. */
    private String conteudo;

    /**
     * Constrói um resumo a partir do seu tema e do seu conteúdo.
     *
     * @param tema     o tema do resumo
     * @param conteudo o conteúdo do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo.
     *
     * @return o tema do resumo
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo do resumo.
     *
     * @return o conteúdo do resumo
     */
    public String getConteudo() {
        return conteudo;
    }
}
