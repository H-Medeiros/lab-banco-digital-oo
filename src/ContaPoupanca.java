public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.tipoDeConta = "Conta Poupança";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void transferir(Integer numeroContaDestino, Double valor, String tipoContaDestino) {
        Conta contaDestino = Conta.getListContasPoupanca().get(numeroContaDestino);
        if (contaDestino != null && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " para " + tipoContaDestino + " número: " + numeroContaDestino + " realizada com sucesso.");
        } else {
            System.out.println("Transferência não realizada. Verifique o saldo e a conta destino.");
        }
    }
}
