package labJava;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }
    public RegistroTempoOnline(String nomeDisciplina ,int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
    }
    public void adicionaTempoOnline(int tempoOnline){
        this.tempoOnline += tempoOnline;
    }
    public boolean atingiuMetaTempoOnline(){
        if (tempoOnline >= tempoEsperado){
            return true;

        }else{
            return false;
        }
    }


}
