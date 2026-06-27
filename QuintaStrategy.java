public class QuintaStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: quinta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Colabore com alguém da equipe em \"" + informacao + "\" antes do fim do dia.");
    }

    @Override
    public String getPrioridade() {
        return "MÉDIA";
    }
}