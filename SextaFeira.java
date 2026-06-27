public class SextaFeira implements StrategyDia {
  @Override
  public String executar(String info) {
    return "Registre o que foi concluído. " + info;
  }

  @Override
  public String prioridade() {
    return "ALTA";
  }
}