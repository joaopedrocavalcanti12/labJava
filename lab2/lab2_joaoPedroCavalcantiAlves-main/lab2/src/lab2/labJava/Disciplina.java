package labJava;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private int nota;
    private double valorNota;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.nota = 0;
        this.valorNota = 0;
    }

    public void cadastraHoras(int horasEstudo) {
        this.horasEstudo += horasEstudo;
    }

    public void cadastraNota(int nota) {
        this.nota++;
        this.valorNota += nota;
    }

    public boolean aprovado() {
        if (nota == 0) {
            return false;
        }
        return (valorNota / nota) >= 7.0;

    }

    public String toString() {
        double media = 0.0;
        if (notas > 0) {
            media = valorNota / nota;
        }
        return nomeDisciplina + " " + horasEstudo + " " + media;
    }
}