public interface IConta {
    void sacar(Double valor);
    void depositar(Double valor);
    void imprimirExtrato();
    void transferir(double valor, IConta contaDestino);
}
