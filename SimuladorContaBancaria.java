//usa o import para importar a biblioteca Scanner
import java.util.Scanner;

class ContaBancaria {

    //Atributos da ContaBancaria
    private String titular;
    private String cpf;
    private double saldo;

    public ContaBancaria(String titular, String cpf) {
        this.titular = titular;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    //Métodos da ContaBancaria
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }
    
    //Método para realizar o saque
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }

    //Método para realizar o cambio
    public void cambio(double valor, double taxa, String moeda) {
        double conversao = valor * taxa;

        if (saldo >= valor) {
            saldo -= valor;
            System.out.printf("Valor convertido: %.2f %s\n", conversao, moeda);
            System.out.println("Conversão realizada! Você recebeu: " + conversao + " " + moeda);
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }

    //Método para mostrar o saldo
    public void mostrarSaldo() {
        System.out.println("Saldo de " + titular + " (CPF: " + cpf + "): R$" + saldo);
    }
}

//Classe SimuladorContaBancaria
public class SimuladorContaBancaria {

    //Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String titular = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(titular, cpf);

        int opcao;
        //Cria um menu de opcoes para o usuario
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Mostrar Saldo");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Câmbio de dinheiro");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            //Executa a opcao escolhida pelo usuario
            switch (opcao) {
                case 1:
                    conta.mostrarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para realizar o depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para realizar o saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    realizarCambio(scanner, conta);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        //Fecha o Scanner após o uso
        scanner.close();
    }

    //Método para realizar o cambio
    public static void realizarCambio(Scanner scanner, ContaBancaria conta) {

        //cria um sub menu para o usuario escolher a moeda
        System.out.println("\nEscolha a moeda para câmbio:");
        System.out.println("1 - Dólar (USD) - Taxa R$5.69");
        System.out.println("2 - Euro (EUR) - Taxa R$5.94");
        System.out.println("3 - Libra (GBP) - Taxa R$7.16");
        System.out.println("4 - Sair");
        
        //Recebe a opcao escolhida
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();

        double taxa = 0;
        String moeda = "";

        //Define a taxa e a moeda de acordo com a opcao escolhida
        switch (escolha) {
            case 1:
                taxa = 0.18;
                moeda = "USD";
                break;
            case 2:
                taxa = 0.17;
                moeda = "EUR";
                break;
            case 3:
                taxa = 0.14;
                moeda = "GBP";
                break;
            case 4:
                System.out.println("Operação cancelada!");
                return;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        //Recebe o valor para realizar o cambio
        System.out.print("Digite o valor para realizar o câmbio: ");
        double valor = scanner.nextDouble();

        //Realiza o cambio
        conta.cambio(valor, taxa, moeda);
    }
}
