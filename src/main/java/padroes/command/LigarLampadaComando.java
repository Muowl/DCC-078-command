package padroes.command;

public class LigarLampadaComando implements Comando {

    private final Lampada lampada;

    public LigarLampadaComando(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void executar() {
        lampada.ligar();
    }

    @Override
    public void desfazer() {
        lampada.desligar();
    }
}
