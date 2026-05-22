package repository;

import model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class TransacaoRepositoryImpl implements TransacaoRepository {

    List<Transacao> transacoes = new ArrayList<>();

    @Override
    public void salvar(Transacao t) {
         transacoes.add(t);
    }

    @Override
    public List<Transacao> listar() {

        return transacoes;
    }
}