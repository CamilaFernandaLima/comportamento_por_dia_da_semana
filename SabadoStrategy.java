public class SabadoStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: sábado");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Aproveite para estudo livre ou descanso: que tal avançar em \"" + informacao + "\" sem pressão?");
    }

    @Override
    public String getPrioridade() {
        return "BAIXA";
    }
}