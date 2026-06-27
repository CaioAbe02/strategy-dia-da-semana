import java.util.Map;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    Catalogo catalogo = new Catalogo();

    String dia = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")).toLowerCase();
    StrategyDia estrategia = catalogo.getEstrategia(dia);
    String info = "Relatório final do projeto, limpar aquário e responder e-mails pendentes.";

    System.out.println("Dia consultado: " + dia);
    System.out.println("Prioridade: " + estrategia.prioridade());
    System.out.println("Mensagem: " + estrategia.executar(info));
  }
}

