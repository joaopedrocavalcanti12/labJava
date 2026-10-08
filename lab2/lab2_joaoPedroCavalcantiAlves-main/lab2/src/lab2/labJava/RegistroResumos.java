package lab2.labJava;

import java.util.Arrays;

public class RegistroResumos {

    private Resumo[] resumos;
    private int quantidadeResumos;
    private int proximaPosicao;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidadeResumos = 0;
        this.proximaPosicao = 0;
    }

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

    public String[] pegaResumos() {

        String[] resultado = new String[quantidadeResumos];

        for (int i = 0; i < quantidadeResumos; i++) {
            resultado[i] = resumos[i].getTema()
                    + ": "
                    + resumos[i].getConteudo();
        }

        return resultado;
    }

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

    public int conta() {
        return quantidadeResumos;
    }

    public boolean temResumo(String tema) {

        for (int i = 0; i < quantidadeResumos; i++) {

            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }

    public String[] busca(String chaveDeBusca) {

        String[] resultado = new String[quantidadeResumos];
        int quantidadeEncontrada = 0;

        for (int i = 0; i < quantidadeResumos; i++) {

            String conteudo = resumos[i].getConteudo().toLowerCase();

            if (conteudo.contains(chaveDeBusca.toLowerCase())) {

                resultado[quantidadeEncontrada] =
                        resumos[i].getTema();

                quantidadeEncontrada++;
            }
        }

        resultado = Arrays.copyOf(resultado, quantidadeEncontrada);

        Arrays.sort(resultado);

        return resultado;
    }
}
