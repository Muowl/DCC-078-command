package padroes.command;

public class Termostato {

    private int temperatura;

    public Termostato(int temperaturaInicial) {
        this.temperatura = temperaturaInicial;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}
