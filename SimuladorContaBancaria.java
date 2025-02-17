class ContaBancaria {

    private String titular;
    private double saldo;

    public ContaBancaria(String titular) {

        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor){

        saldo += valor;
    }

    public void sacar(double valor) {

        if(saldo >= valor) saldo -= valor;
        else System.out.println("Saldo Insuficiente");
    
    }
    public void mostrarSaldo(){

        System.out.println("Saldo de "+ titular + ": R$" + saldo);
    }
    
}

public class SimuladorContaBancaria {

    public static void main(String[] args){

        ContaBancaria conta = new ContaBancaria("Maria");
        conta.depositar(100);
        conta.sacar(30);
        conta.mostrarSaldo();
    }
}
