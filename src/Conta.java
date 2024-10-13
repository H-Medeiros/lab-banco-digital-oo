import java.util.HashMap;
import java.util.Map;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 193;
    private static int SEQUENCIAL = 1;
    protected String tipoDeConta;
    protected Integer agencia;
    protected Integer numero;
    protected Double saldo;
    protected Cliente cliente;

    private static Map<Integer, Conta> listaContasCorrente = new HashMap<>();
    private static Map<Integer, Conta> listContasPoupanca = new HashMap<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipoDeConta = null;
        this.saldo = 0.0;
        listaContasCorrente.put(this.numero, this);
        listContasPoupanca.put(this.numero, this);
    }

    public static Map<Integer, Conta> getListaContasCorrente() {
        return listaContasCorrente;
    }
    public static Map<Integer, Conta> getListContasPoupanca() {
        return listaContasCorrente;
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
        System.out.println(String.format("Tipo de conta: %s", this.tipoDeConta));
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    @Override
    public abstract void transferir(Integer numeroContaDestino, Double valor, String tipoContaDestino);
}
