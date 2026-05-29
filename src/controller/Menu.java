package controller;
import model.Transacao;
import service.FinanceiroService;
import repository.TransacaoRepositoryImpl;
import model.Receita;
import model.Despesa;
import java.util.Scanner;
public class Menu {

    Scanner sc = new Scanner(System.in);

    private FinanceiroService service;
    public Menu(){
        TransacaoRepositoryImpl repository = new TransacaoRepositoryImpl();

        this.service = new FinanceiroService(repository);
    }

    public void iniciar() {

        while (true) {

            System.out.println("\n=================== MENU ===================");
            System.out.println("1 - Filtrar por mês");
            System.out.println("2 - Gerar relatório mensal");
            System.out.println("3 - Adicionar transação");
            System.out.println("4 - Listar transações");
            System.out.println("5 - Calcular saldo");
            System.out.println("0 - Finalizar");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                System.out.println("Finalizando...");
                break;
            }
            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o mês e ano desejado");
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();


                    for (Transacao t : service.filtrarPorMes(mes, ano)){

                        System.out.println(t);

                    }
                }
                case 2 -> {
                    System.out.println("Digite o mês e ano do relatório");
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    System.out.println(service.gerarRelatorioMensal(mes,ano));

                }
                case 3 -> {

                    System.out.println("Digite uma opção: ");
                    System.out.println("1 - Receita");
                    System.out.println("2 - Despesa");
                    int esc = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite a descrição: ");
                    String desc = sc.nextLine();
                    System.out.println("Digite o valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    if (esc == 1){

                         service.adicionarTransacao(new Receita(desc, valor));
                        System.out.println("Receita adicionada!");

                    }
                    else if (esc == 2){

                        service.adicionarTransacao(new Despesa(desc, valor));
                        System.out.println("Despesa adicionada!");
                    }
                }
                case 4 -> {

                    System.out.println("\"\\n=================== TRANSAÇÕES ===================\"");
                    for (Transacao t : service.listar()){

                        System.out.println(t);
                    }

                }
                case 5 -> {

                    double saldo = service.calcularSaldo();
                    System.out.println("Saldo atual: " + saldo);

                }

            }


        }
    }

}
