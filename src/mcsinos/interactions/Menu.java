package mcsinos.interactions;
import static java.lang.System.*;
public class Menu {
    // Atributos
    static Options options = new Options();

    // Métodos
    public static void main(String[] args) {
        boolean keepLoop = true;
        out.println("Bem-vindo ao McSinos!");
        while (keepLoop) {
            int escolha = options.choose();
            switch (escolha) {
                case 1 -> options.showOrderList();
                case 2 -> options.takeOrder();
                case 3 -> options.deliverOrder();
                case 4 -> keepLoop = false;
                default -> out.println("Resposta Não Encontrada!");
            }
        }
    }
}
