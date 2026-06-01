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

            int opcao;
           try {
               opcao = sc.nextInt();
           }
           catch (Exception e){
               System.out.println("Apenas números de 0 a 5");
               sc.nextLine();
               continue;
           }
            if (opcao == 0) {
                System.out.println("Finalizando...");
                break;
            }
            switch (opcao){
                case 1 -> {
                    System.out.println("Digite o mês e ano desejado");
                    System.out.print("Mês: ");
                    int mes;
                    try {
                        mes = sc.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("Digite apenas números");
                        sc.nextLine();
                        continue;
                    }
                    System.out.print("Ano: ");
                    int ano;
                    try {
                        ano = sc.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("Digite apenas números");
                        sc.nextLine();
                        continue;
                    }

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
                    int esc;
                    try {
                         esc = sc.nextInt();
                        sc.nextLine();
                    }
                    catch (Exception e){
                        System.out.println("Apenas números 1 ou 2");
                        sc.nextLine();
                        continue;
                    }

                    System.out.println("Digite a descrição: ");
                    String desc = sc.nextLine();
                    System.out.println("Digite o valor: ");
                    double valor;
                    try{
                        valor = sc.nextDouble();
                        sc.nextLine();
                    }
                    catch (Exception e){
                        System.out.println("Apenas números");
                        sc.nextLine();
                        continue;
                    }

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

                    System.out.println("\n=================== TRANSAÇÕES ===================");
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
