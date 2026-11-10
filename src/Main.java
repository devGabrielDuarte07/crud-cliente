import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        menuPrincipal();


    }

    public static void menuPrincipal(){
        System.out.println("1 - Gerenciar clientes");
        System.out.println("2 - Gerenciar contatos");
        System.out.println("3 - Relatórios");
        System.out.println("0 - Sair");
        int opcMenu = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Escolha a opção que deseja realizar: ");
            opcMenu = input.nextInt();

            switch (opcMenu) {
                case 1:
                    Clientes.menuCliente();
                    break;
                case 2:
                    Contatos.menuContato();
                    break;
                case 3:
                    relatorio();
                    break;
                case 0:
                    System.out.println("Até mais...");
                    return;
                default:
                    System.out.println("Opção válida, tente novamente ");
                    menuPrincipal();
            }
        } while (opcMenu != 0);
    }





    private static void relatorio() {
        System.out.println("relatio");
    }


}