package service;
import repository.TransacaoRepository;
import model.Transacao;
import model.Receita;
import model.Despesa;

import java.util.ArrayList;
import java.util.List;

public class FinanceiroService  {
    private TransacaoRepository repository;

    public FinanceiroService(TransacaoRepository repository){

        this.repository = repository;


    }
    public List<Transacao> filtrarPorMes(int mes, int ano){

        List<Transacao> filtro = new ArrayList<>();

        for (Transacao t : repository.listar()){

            if (t.getDataHora().getMonthValue() == mes &&
                    t.getDataHora().getYear() == ano){
                filtro.add(t);
            }
        }
        return filtro;

    }
    public String gerarRelatorioMensal(int mes, int ano){

        List<Transacao> transacoesMes = filtrarPorMes(mes, ano);

        double totalReceita = 0;
        double totalDespesa = 0;

        for (Transacao t : transacoesMes){

            if(t instanceof Receita){
                totalReceita += t.getValor();

            }

            else if (t instanceof Despesa){
                totalDespesa += t.getValor();

                 totalDespesa -= totalReceita;
            }

        }

        double saldoFinal = totalReceita - totalDespesa;

        return "RELATÓRIO MENSAL\n" +
            "Receitas: " + totalReceita + "\n" +
            "Despesas: " + totalDespesa + "\n" +
            "Saldo: " + saldoFinal;
    }

    public void adicionarTransacao(Transacao t){

        repository.salvar(t);

    }
    public List<Transacao> listar(){

      return repository.listar();
    }

    public double calcularSaldo(){

        double saldo = 0;
        for (Transacao t : repository.listar()){

            if(t instanceof Receita){

                saldo += t.getValor();

            }
            else if (t instanceof Despesa){
                saldo = saldo - t.getValor();

            }
        }
        return saldo;
    }




}
