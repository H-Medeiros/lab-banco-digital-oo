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

        System.out.println("Contas De Paulo");
        cPaulo.imprimirExtrato();
        pPaulo.imprimirExtrato();

        System.out.println(" ");
        System.out.println("Contas De vanilton");
        pVenilton.imprimirExtrato();
        cVenilton.imprimirExtrato();

        cVenilton.sacar(20.0);
        cVenilton.imprimirExtrato();
        System.out.println("Saque Feitos");
        System.out.println(" ");

        cVenilton.transferir(20, pVenilton);
        System.out.println("Apos Transferencia");
        cVenilton.imprimirExtrato();
        pVenilton.imprimirExtrato();
    }

}