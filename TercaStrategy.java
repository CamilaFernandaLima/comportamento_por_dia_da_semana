public class TercaStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: terça-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Avance nas tarefas pendentes: dedique tempo a \"" + informacao + "\" hoje.");
    }

    @Override
    public String getPrioridade() {
        return "ALTA";
    }
}
