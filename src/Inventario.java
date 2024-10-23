import java.util.ArrayList;
import java.util.Scanner;

public class Inventario {

    private static final int LIMITE = 8; // Limite de itens no inventário.
    private static ArrayList<String> inventario = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ");

        adicionarItens(scanner);
        exibirInventario();

        System.out.println(" ");
        scanner.close();
    }

    public static void adicionarItens(Scanner scanner) {
        String item;

        while (inventario.size() < LIMITE) {
            System.out.println("Digite o nome do item para adicionar ao inventário (ou 'sair' para finalizar):");
            item = scanner.nextLine();

            if (item.equalsIgnoreCase("sair")) {
                break;
            }

            if (!inventarioCheio()) {
                inventario.add(item);
                System.out.println("Item '" + item + "' adicionado ao inventário.");
            } else {
                System.out.println("O inventário está cheio! Não é possível adicionar mais itens.");
                break;
            }
        }
    }

    public static boolean inventarioCheio() {
        return inventario.size() >= LIMITE;
    }

    public static void exibirInventario() {
        System.out.println("\nItens no inventário:");
        for (String item : inventario) {
            System.out.println("- " + item);
        }
    }
}

// PS: DEPOIS ARRUMAR PRA PODER SER EXECUTADO SOMENTE NA MAIN.
