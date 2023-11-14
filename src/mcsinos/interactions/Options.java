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
        out.println(ConsoleColors.BLUE_BOLD + "\n========== Pedidos em Andamento ==========" + ConsoleColors.RESET);
        out.println(service.showOrderQueue());
    }

    public void takeOrder() {
        out.println(ConsoleColors.BLUE_BOLD + "\n=========== Menu ===========" + ConsoleColors.RESET);
        List<MenuItem> items = new ArrayList<>();
        showMenuItems();
        while (true) {
            MenuItem choosedOrder = chooseOrder();
            if (choosedOrder == null) {
                Order order = new Order(items);
                service.order(order);
                break;
            }
            items.add(choosedOrder);
        }
    }

    private void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            out.println(i+1 + ". " + menuItems.get(i));
        }
        out.println(menuItems.size()+1 + ". Finalizar pedido");
    }

    private MenuItem chooseOrder() {
        while (true) {
            int numOrder = entry.leInt("Escolha um item: ");
            if (numOrder-1 < menuItems.size()) {
                return (MenuItem) menuItems.get(numOrder-1);
            }
            if (numOrder-1 == menuItems.size()) {
                return null;
            }
            out.println("Pedido inválido!");
        }
    }

    public void deliverOrder() {
        service.delivery();
    }
}
