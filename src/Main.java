
public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente paulo = new Cliente();
        paulo.setNome("Paulo");

        Conta cPaulo = new ContaPoupanca(paulo);
        Conta pPaulo = new ContaCorrente(paulo);

        Conta cVenilton = new ContaCorrente(venilton);
        Conta pVenilton = new ContaPoupanca(venilton);

        cVenilton.depositar(100.0);
        pVenilton.depositar(20.0);

        cPaulo.imprimirExtrato();
        pPaulo.imprimirExtrato();
        pVenilton.imprimirExtrato();
        cVenilton.imprimirExtrato();

        cVenilton.sacar(20.0);
        cVenilton.imprimirExtrato();

        cVenilton.transferir(1, 20.0,"Conta Corrente");
        cVenilton.imprimirExtrato();
        cPaulo.imprimirExtrato();
    }

}