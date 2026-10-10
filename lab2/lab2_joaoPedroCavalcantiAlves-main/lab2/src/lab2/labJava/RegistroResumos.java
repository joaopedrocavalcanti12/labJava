package lab2.labJava;

import java.util.Arrays;

/**
 * Registro de resumos de estudo com capacidade limitada. Ao adicionar um
 * resumo com o registro cheio, o primeiro resumo cadastrado é substituído;
 * em seguida, o segundo, e assim sucessivamente. Não pode existir mais de
 * um resumo com o mesmo tema.
 *
 * @author João Pedro Cavalcanti Alves
 */
public class RegistroResumos {

    /** Resumos armazenados. O tamanho do array é a capacidade do registro. */
    private Resumo[] resumos;

    /** Quantidade de resumos armazenados no momento. */
    private int quantidadeResumos;

    /** Posição onde será guardado o próximo resumo (ou substituído, se estiver cheio). */
    private int proximaPosicao;

    /**
     * Constrói um registro de resumos com uma capacidade máxima. O registro
     * começa vazio.
     *
     * @param numeroDeResumos a quantidade máxima de resumos que o registro armazena
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

    /**
     * Adiciona um resumo ao registro. Se já existir um resumo com o mesmo
     * tema, nada é adicionado. Se o registro estiver cheio, o resumo mais
     * antigo é substituído.
     *
     * @param tema     o tema do resumo
     * @param conteudo o conteúdo do resumo
     */
    public void adiciona(String tema, String conteudo) {

        if (!temResumo(tema)) {

            resumos[proximaPosicao] = new Resumo(tema, conteudo);

            if (quantidadeResumos < resumos.length) {
                quantidadeResumos++;
            }

            proximaPosicao++;

            if (proximaPosicao == resumos.length) {
                proximaPosicao = 0;
            }
        }
    }

    /**
     * Retorna os resumos armazenados. Cada resumo segue o formato
     * "tema: conteudo".
     *
     * @return um array com um elemento para cada resumo cadastrado
     */
    public String[] pegaResumos() {

        String[] resultado = new String[quantidadeResumos];

        for (int i = 0; i < quantidadeResumos; i++) {
            resultado[i] = resumos[i].getTema()
                    + ": "
                    + resumos[i].getConteudo();
        }

        return resultado;
    }

    /**
     * Retorna a String que representa o registro de resumos. A representação
     * tem duas linhas: a quantidade de resumos cadastrados e os temas
     * separados por " | ". Por exemplo:
     * "- 2 resumo(s) cadastrado(s)" e, na linha seguinte, "- Classes | Tipo".
     *
     * @return a representação em String do registro de resumos
     */
    public String imprimeResumos() {

        String resultado = "- " + quantidadeResumos
                + " resumo(s) cadastrado(s)\n";

        resultado += "- ";

        for (int i = 0; i < quantidadeResumos; i++) {

            resultado += resumos[i].getTema();

            if (i < quantidadeResumos - 1) {
                resultado += " | ";
            }
        }

        return resultado;
    }

    /**
     * Retorna a quantidade de resumos armazenados no momento.
     *
     * @return a quantidade de resumos cadastrados
     */
    public int conta() {
        return quantidadeResumos;
    }

    /**
     * Verifica se existe um resumo com o tema informado.
     *
     * @param tema o tema a ser procurado
     * @return true se existir um resumo com esse tema; false caso contrário
     */
    public boolean temResumo(String tema) {

        for (int i = 0; i < quantidadeResumos; i++) {

            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Busca os resumos cujo conteúdo contém a chave de busca, ignorando
     * diferenças entre letras maiúsculas e minúsculas.
     *
     * @param chaveDeBusca o texto a ser procurado no conteúdo dos resumos
     * @return um array com os temas encontrados, em ordem alfabética
     */
    public String[] busca(String chaveDeBusca) {
        String chave = chaveDeBusca.toLowerCase();

        // 1º passo: contar quantos resumos têm a chave no conteúdo
        int quantidadeEncontrada = 0;
        for (int i = 0; i < quantidadeResumos; i++) {
            String conteudo = resumos[i].getConteudo().toLowerCase();
            if (conteudo.contains(chave)) {
                quantidadeEncontrada++;
            }
        }

        // 2º passo: criar o array do tamanho certo e guardar os temas
        String[] resultado = new String[quantidadeEncontrada];
        int posicao = 0;
        for (int i = 0; i < quantidadeResumos; i++) {
            String conteudo = resumos[i].getConteudo().toLowerCase();
            if (conteudo.contains(chave)) {
                resultado[posicao] = resumos[i].getTema();
                posicao++;
            }
        }

        // 3º passo: colocar em ordem alfabética
        Arrays.sort(resultado);

        return resultado;
    }
}