public class QuintaFeira implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Colabore com alguém da equipe. " + info;
  }

  @Override
  public String prioridade() {
    return "ALTA";
  }
}