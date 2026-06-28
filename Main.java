import java.util.Map;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.text.Normalizer;

public class Main {
  public static void main(String[] args) {
    Catalogo catalogo = new Catalogo();
    Scanner sc = new Scanner(System.in);

    System.out.println("1 - Usar data atual");
    System.out.println("2 - Informar um dia");
    System.out.print("Escolha: ");

    int opcao = sc.nextInt();
    sc.nextLine();

    String dia;

    if (opcao == 1) {
      dia = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")).toLowerCase();
    }
    else {
      System.out.print("Digite um dia da semana: ");
      dia = sc.nextLine().toLowerCase();
    }

    dia = Normalizer.normalize(dia, Normalizer.Form.NFD).replaceAll("\\p{M}", "");

    StrategyDia estrategia = catalogo.getEstrategia(dia);
    
    System.out.print("Informe uma informação adicional (nome, tarefa ou meta): ");
    String info = sc.nextLine();
    
    System.out.println("Dia consultado: " + dia);
    System.out.println("Prioridade: " + estrategia.prioridade());
    System.out.println("Mensagem: " + estrategia.executar(info));
  }
}

