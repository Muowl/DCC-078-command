package padroes.command;

public class Lampada {

    private final String ambiente;
    private boolean ligada;

    public Lampada(String ambiente) {
        this.ambiente = ambiente;
    }

    public void ligar() {
        ligada = true;
    }

    public void desligar() {
        ligada = false;
    }

    public boolean isLigada() {
        return ligada;
    }

    public String getAmbiente() {
        return ambiente;
    }
}
