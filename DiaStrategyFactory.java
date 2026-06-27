import java.util.HashMap;
import java.util.Map;

public class DiaStrategyFactory {

    private static final Map<String, DiaStrategy> estrategias = new HashMap<>();

    static {
        estrategias.put("segunda", new SegundaStrategy());
        estrategias.put("terca", new TercaStrategy());
        estrategias.put("quarta", new QuartaStrategy());
        estrategias.put("quinta", new QuintaStrategy());
        estrategias.put("sexta", new SextaStrategy());
        estrategias.put("sabado", new SabadoStrategy());
        estrategias.put("domingo", new DomingoStrategy());
    }

    public static DiaStrategy criar(String dia) {
        DiaStrategy strategy = estrategias.get(normalizar(dia));
        if (strategy == null) {
            return new NullDiaStrategy(dia);
        }
        return strategy;
    }

    private static String normalizar(String dia) {
        if (dia == null) return "";
        return dia.toLowerCase()
                  .replace("ç", "c")
                  .replace("á", "a")
                  .replace("â", "a")
                  .replace("ã", "a")
                  .replace("é", "e")
                  .replace("ê", "e")
                  .replace("í", "i")
                  .replace("ó", "o")
                  .replace("ô", "o")
                  .replace("ú", "u")
                  .replace("ü", "u")
                  .replace("-feira", "")
                  .replace("sábado", "sabado")
                  .trim();
    }
}