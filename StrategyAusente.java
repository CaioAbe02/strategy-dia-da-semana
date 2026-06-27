public class StrategyAusente implements StrategyDia {
  private final String dia;

  public StrategyAusente(String dia) {
    this.dia = dia;
  }

  @Override
  public String executar(String info) {
    return "Nenhuma estratégia definida para o dia: " + dia;
  }

  @Override
  public String prioridade() {
    return "INDEFINIDA";
  }
}