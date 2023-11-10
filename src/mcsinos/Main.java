package mcsinos;

import mcsinos.entity.Order;
import mcsinos.service.McSinosService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;
        McSinosService service = new McSinosService();
        do {
            System.out.println("Bem-vindo");
            System.out.println("1-Fazer pedido");
            System.out.println("2-Entregar pedido");
            System.out.println("3-Mostrar fila");
            System.out.println("4-Sair");
            opcao = input.nextInt();
            input.next();

            switch (opcao) {
                case 1 -> {
                    do{
                        break;
                    }while(true);
                }
                case 2 -> service.delivery();
                case 3 -> System.out.println(service.showOrderQueue());
                case 4 -> System.out.println("Tchau!");
                default -> System.out.println("Opção inválida");
            }
        } while (opcao != 4);
    }
}
