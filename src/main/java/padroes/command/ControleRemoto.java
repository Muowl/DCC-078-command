package padroes.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class ControleRemoto {

    private final Deque<Comando> historico = new ArrayDeque<>();

    public void pressionar(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public boolean desfazerUltimo() {
        if (historico.isEmpty()) {
            return false;
        }
        historico.pop().desfazer();
        return true;
    }

    public int getTotalComandos() {
        return historico.size();
    }
}
