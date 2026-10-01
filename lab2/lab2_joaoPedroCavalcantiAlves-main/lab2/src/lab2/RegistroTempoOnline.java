package lab2;

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoEsperado;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
        this.tempoEsperado = 120;
    }
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnline, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnline = 0;
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
