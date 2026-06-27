import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // Exemplo 1: entrada válida — quarta-feira
        System.out.println("> Exemplo 1: dia válido");
        DiaStrategy estrategiaValida = DiaStrategyFactory.criar("quarta");
        estrategiaValida.executar("Ana", "Implementar relatório");

        System.out.println();

        // Exemplo 2: entrada inválida — dia inexistente
        System.out.println("> Exemplo 2: dia inválido");
        DiaStrategy estrategiaInvalida = DiaStrategyFactory.criar("feriado");
        estrategiaInvalida.executar("Ana", "Implementar relatório");

        System.out.println();

        // Bônus: usa o dia atual automaticamente
        System.out.println("> Exemplo 3: dia atual");
        String diaAtual = getDiaAtual();
        DiaStrategy estrategiaHoje = DiaStrategyFactory.criar(diaAtual);
        estrategiaHoje.executar("Ana", "Implementar relatório");
    }

    private static String getDiaAtual() {
        return LocalDate.now()
                        .getDayOfWeek()
                        .getDisplayName(TextStyle.FULL, Locale.of("pt", "BR"));
    }
}


