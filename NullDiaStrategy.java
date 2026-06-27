public class NullDiaStrategy implements DiaStrategy {

    private final String diaInformado;

    public NullDiaStrategy(String diaInformado) {
        this.diaInformado = diaInformado;
    }

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: " + diaInformado);
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Dia inválido ou sem estratégia associada. Nenhuma ação foi executada.");
    }

    @Override
    public String getPrioridade() {
        return "INDEFINIDA";
    }
}