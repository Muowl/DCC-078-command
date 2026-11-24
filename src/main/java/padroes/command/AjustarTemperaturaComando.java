package padroes.command;

public class AjustarTemperaturaComando implements Comando {

    private final Termostato termostato;
    private final int novaTemperatura;
    private int temperaturaAnterior;

    public AjustarTemperaturaComando(Termostato termostato, int novaTemperatura) {
        this.termostato = termostato;
        this.novaTemperatura = novaTemperatura;
    }

    @Override
    public void executar() {
        temperaturaAnterior = termostato.getTemperatura();
        termostato.setTemperatura(novaTemperatura);
    }

    @Override
    public void desfazer() {
        termostato.setTemperatura(temperaturaAnterior);
    }
}
