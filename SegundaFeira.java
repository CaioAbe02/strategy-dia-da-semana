public class SegundaFeira implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Organize suas prioridades. " + info;
  }

  @Override
  public String prioridade() {
    return "ALTA";
  }
}