package padroes.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControleRemotoTest {

    private final ControleRemoto controle = new ControleRemoto();

    @Test
    void deveExecutarComandoDeLampada() {
        Lampada sala = new Lampada("Sala");

        controle.pressionar(new LigarLampadaComando(sala));

        assertTrue(sala.isLigada());
    }

    @Test
    void deveExecutarComandoDeTermostato() {
        Termostato termostato = new Termostato(24);

        controle.pressionar(new AjustarTemperaturaComando(termostato, 20));

        assertEquals(20, termostato.getTemperatura());
    }

    @Test
    void deveDesfazerComandosNaOrdemInversa() {
        Lampada sala = new Lampada("Sala");
        Termostato termostato = new Termostato(24);
        controle.pressionar(new LigarLampadaComando(sala));
        controle.pressionar(new AjustarTemperaturaComando(termostato, 18));

        assertTrue(controle.desfazerUltimo());
        assertEquals(24, termostato.getTemperatura());
        assertTrue(sala.isLigada());

        assertTrue(controle.desfazerUltimo());
        assertFalse(sala.isLigada());
    }

    @Test
    void deveRestaurarTemperaturaAnteriorEmAjustesSucessivos() {
        Termostato termostato = new Termostato(24);
        controle.pressionar(new AjustarTemperaturaComando(termostato, 22));
        controle.pressionar(new AjustarTemperaturaComando(termostato, 19));

        controle.desfazerUltimo();

        assertEquals(22, termostato.getTemperatura());
    }

    @Test
    void deveInformarQuandoNaoHaNadaParaDesfazer() {
        assertFalse(controle.desfazerUltimo());
        assertEquals(0, controle.getTotalComandos());
    }

    @Test
    void deveContarComandosNoHistorico() {
        controle.pressionar(new LigarLampadaComando(new Lampada("Quarto")));
        controle.pressionar(new AjustarTemperaturaComando(new Termostato(24), 21));

        assertEquals(2, controle.getTotalComandos());
        controle.desfazerUltimo();
        assertEquals(1, controle.getTotalComandos());
    }
}
