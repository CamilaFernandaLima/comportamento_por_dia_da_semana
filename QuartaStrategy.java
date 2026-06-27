public class QuartaStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: quarta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Dia de revisão: verifique o andamento da atividade \"" + informacao + "\".");
    }

    @Override
    public String getPrioridade() {
        return "MÉDIA";
    }
}