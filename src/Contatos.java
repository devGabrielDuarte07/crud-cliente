import java.util.Scanner;

public class Contatos {
    public static void menuContato(){
        System.out.println("1 - Incluir cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Consultar cliente por código");
        System.out.println("4 - Apagar cliente");
        System.out.println("5 - Ordenar por nome");
        System.out.println("0 - Voltar");

        int opcContato = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Digite a opção que deseja realizar: ");
            opcContato = input.nextInt();

            switch (opcContato){
                case 1:
                    incluirContato();
                    break;
                case 2:
                    listarContato();
                    break;
                case 3:
                    listarContatoDeUmCliente();
                    break;
                case 4:
                    alterarContato();
                    break;
                case 5:
                    apagarContato();
                    break;
                case 0:
                    Main.menuPrincipal();
                    break;
            }
        }while (opcContato != 0);
    }

    private static void apagarContato() {
    }

    private static void alterarContato() {

    }

    private static void listarContatoDeUmCliente() {

    }

    private static void listarContato() {

    }

    private static void incluirContato() {

    }

}
