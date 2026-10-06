package labJava;

public class RegistroResumos {
    private String[] tema;
    private String[] conteudo;
    private int proximaPosicao;
    private int quantidade;

    public RegistroResumos(int numeroDeResumos) {
        this.tema = new String[numeroDeResumos];
        this.conteudo = new String[numeroDeResumos];
        this.proximaPosicao = 0;
        this.quantidade = 0;
    }
    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < this.quantidade; i++) {
            if (this.temas[i].equals(tema)) {
                this.conteudos[i] = conteudo;
                return;
            }
        }
        this.temas[this.proximaPosicao] = tema;
        this.conteudos[this.proximaPosicao] = conteudo;
        this.proximaPosicao = (this.proximaPosicao + 1) % this.temas.length;
        if (this.quantidade < this.temas.length) {
            this.quantidade++;
        }
    }

    public void adicionaResumo(String tema, String conteudo) {
        adiciona(tema, conteudo);
    }

    public String[] pegaResumos() {
        String[] resumos = new String[this.quantidade];
        for (int i = 0; i < this.quantidade; i++) {
            resumos[i] = this.temas[i] + ": " + this.conteudos[i];
        }
        return resumos;
    }

    public String imprimeResumos() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(this.quantidade).append(" resumo(s) cadastrado(s)\n- ");
        for (int i = 0; i < this.quantidade; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(this.temas[i]);
        }
        return sb.toString();
    }

    public int conta() {
        return this.quantidade;
    }

    public int contaResumos() {
        return conta();
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < this.quantidade; i++) {
            if (this.temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }
}
