import java.util.Map;

public class Catalogo {
  private final Map<String, StrategyDia> estrategias = Map.of(
    "segunda-feira", new SegundaFeira(),
    "terca-feira",   new TercaFeira(),
    "quarta-feira",  new QuartaFeira(),
    "quinta-feira",  new QuintaFeira(),
    "sexta-feira",   new SextaFeira(),
    "sabado",        new Sabado(),
    "domingo",      new Domingo()
  );

  public StrategyDia getEstrategia(String dia) {
    return estrategias.getOrDefault(dia, new StrategyAusente(dia));
  }
}