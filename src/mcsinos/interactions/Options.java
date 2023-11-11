package mcsinos.interactions;
import mcsinos.entity.Order;
import mcsinos.enumerator.MenuItem;
import mcsinos.service.McSinosService;

import java.util.*;

import static java.lang.System.out;

public class Options {
    // Atributos
    Scanner scanner;
    Entry entry;
    McSinosService service = new McSinosService();
    List<Enum> menuItems = Arrays.asList(MenuItem.values());

    // Construtor
    public Options() {
        scanner = new Scanner(System.in);
        entry = new Entry();
    }

    // Métodos
    public int choose() {
        out.println(ConsoleColors.BLUE_BOLD + "\n========== McSinos ==========" + ConsoleColors.RESET);
        out.println("1. Mostrar fila de pedidos");
        out.println("2. Solicitar pedido");
        out.println("3. Entregar pedido");
        out.println("4. Sair do programa");
        return entry.leInt("Escolha uma opção: ");
    }

    public void showOrderList() {
        out.println(service.showOrderQueue());
    }

    public void takeOrder() {
        out.println(ConsoleColors.BLUE_BOLD + "\n=========== Menu ===========" + ConsoleColors.RESET);
        showMenuItems();
        MenuItem choosedOrder = chooseOrder();
        Order order = new Order(choosedOrder);
    }

    private void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            out.println(i+1 + ". " + menuItems.get(i));
        }
        for (MenuItem info : EnumSet.allOf(MenuItem.class)) {
            System.out.println(info);
        }
    }

    private MenuItem chooseOrder() {
        while (true) {
            int numOrder = entry.leInt("Escolha o pedido: ");
            if (numOrder < menuItems.size()) {
                return menuItems.get(numOrder-1);
            }
            out.println("Pedido inválido!");
        }
    }

    public void deliverOrder() {
        service.delivery();
    }
}
