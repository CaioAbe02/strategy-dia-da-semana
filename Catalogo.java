import java.util.Map;

public class Catalogo {
  private final Map<String, StrategyDia> estrategias = Map.of(
    "segunda-feira", new SegundaFeira(),
    "terça-feira",   new TercaFeira()
  );

  public StrategyDia getEstrategia(String dia) {
    return estrategias.getOrDefault(dia, new StrategyAusente(dia));
  }
}