package repository;
import model.Transacao;
import java.util.List;
public interface TransacaoRepository {

    void salvar(Transacao t);

    List<Transacao> listar();
}