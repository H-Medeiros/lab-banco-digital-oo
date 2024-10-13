public interface IConta {
    void sacar(Double valor);
    void depositar(Double valor);
    void imprimirExtrato();
    void transferir(Integer numeroContaDestino, Double valor, String tipoContaDestino);
}
