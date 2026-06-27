public class Sabado implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Realize estudo livre ou descanse. " + info;
  }

  @Override
  public String prioridade() {
    return "MÉDIA";
  }
}