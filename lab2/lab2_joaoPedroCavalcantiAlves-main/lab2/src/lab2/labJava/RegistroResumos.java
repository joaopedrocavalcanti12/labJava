package labJava;

public class RegistroResumos {
    private String[] tema;
    private String[] conteudo;

    public RegistroResumos(int numeroDeResumos) {
        tema = new String[numeroDeResumos];
        conteudo = new String[numeroDeResumos];
        quantidade = 0;
    }
    public void adicionaResumo(String tema, String conteudo) {
        if (quantidade < tema.length) {
            tema[quantidade] = tema;
            conteudo[quantidade] = conteudo;
            quantidade++
        }
    }
    public String[] pegaResumos() {
        String[] resumos = new String[quantidade];

        for (int i = 0; i < quantidade; i++) {
            resumos[i] = tema[i] + ": " + conteudo[i];
        }
        return resumos;
    }
    public int contaResumos() {
        return quantidade;
    }
    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            if (temas[i].equals(tema)){
                return true;
            }
        }
        return false;
    }
}
