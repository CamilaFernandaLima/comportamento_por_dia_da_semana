public class DomingoStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: domingo");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Planeje a próxima semana: inclua \"" + informacao + "\" nas suas metas.");
    }

    @Override
    public String getPrioridade() {
        return "BAIXA";
    }
}