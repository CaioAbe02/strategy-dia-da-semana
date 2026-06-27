public class TercaFeira implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Avance nas tarefas pendentes: " + info;
  }

  @Override
  public String prioridade() {
    return "ALTA";
  }
}