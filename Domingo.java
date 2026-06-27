public class Domingo implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Planeje a próxima semana. " + info;
  }

  @Override
  public String prioridade() {
    return "BAIXA";
  }
}