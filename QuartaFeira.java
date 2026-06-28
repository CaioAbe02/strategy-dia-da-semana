public class QuartaFeira implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Revise o andamento das atividades. " + info;
  }

  @Override
  public String prioridade() {
    return "ALTA";
  }
}