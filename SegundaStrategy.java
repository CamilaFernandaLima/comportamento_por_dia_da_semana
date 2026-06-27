public class SegundaStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: segunda-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Início de semana: organize suas prioridades antes de começar \"" + informacao + "\".");
    }

    @Override
    public String getPrioridade() {
        return "ALTA";
    }
}