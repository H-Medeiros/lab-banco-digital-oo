import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 193;
    private static int SEQUENCIAL = 1;
    protected Integer agencia;
    protected Integer numero;
    protected Double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }


    @Override
    public void sacar(Double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if(this.saldo > valor){
        this.sacar(valor);
        contaDestino.depositar(valor);
        }else {
            System.out.println("Saldo Insuficiente");
        }
    }
}

