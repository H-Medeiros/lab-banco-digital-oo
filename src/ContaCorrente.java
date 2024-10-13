import java.util.HashMap;
import java.util.Map;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.tipoDeConta = "Conta Corrente";
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void transferir(Integer numeroContaDestino, Double valor, String tipoContaDestino) {
        Conta contaDestino = Conta.getListaContasCorrente().get(numeroContaDestino);
        if (contaDestino != null && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " para " + tipoContaDestino + " número: " + numeroContaDestino + " realizada com sucesso.");
        } else {
            System.out.println("Transferência não realizada. Verifique o saldo e a conta destino.");
        }
    }
}
