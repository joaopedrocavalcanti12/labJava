package labJava;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }
    public RegistroTempoOnline(String nomeDisciplina ,int tempoOnlineEsperado){
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.nomeDisciplina = nomeDisciplina;
    }
    public void adicionaTempoOnline(int tempoOnline){
        this.tempoOnline += tempoOnline;
    }
    public boolean atingiuMetaTempoOnline() {
        if (tempoOnline >= tempoOnlineEsperado) {
            return true;
        }
        return false;
    }
    public String toString(){
        return nomeDisciplina + " " + tempoOnline+ "/" + tempoOnlineEsperado;

    }
}
