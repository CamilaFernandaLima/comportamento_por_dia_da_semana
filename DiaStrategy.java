public interface DiaStrategy {
    void executar(String usuario, String informacao);
    String getPrioridade();
}