public class SextaStrategy implements DiaStrategy {

    @Override
    public void executar(String usuario, String informacao) {
        System.out.println("Usuário: " + usuario);
        System.out.println("Dia consultado: sexta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Registre o que foi concluído: marque \"" + informacao + "\" como finalizado.");
    }

    @Override
    public String getPrioridade() {
        return "MÉDIA";
    }
}