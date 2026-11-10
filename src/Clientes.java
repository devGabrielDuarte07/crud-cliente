import java.util.Scanner;

public class Clientes {

    public static void menuCliente(){
        System.out.println("1 - Incluir cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Consultar cliente por código");
        System.out.println("4 - Apagar cliente");
        System.out.println("5 - Ordenar por nome");
        System.out.println("0 - Voltar");

        int opcCliente = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Digite a opção que deseja realizar: ");
            opcCliente = input.nextInt();

            switch (opcCliente){
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    consultarClienteCodigo();
                    break;
                case 4:
                    apagarCliente();
                    break;
                case 5:
                    ordenarPorNome();
                    break;
                case 0:
                    Main.menuPrincipal();
                    break;
            }
        }while (opcCliente != 0);
    }

    private static void ordenarPorNome() {
    }

    private static void apagarCliente() {

    }

    private static void consultarClienteCodigo() {

    }

    private static void listarClientes() {

    }

    private static void incluirCliente() {

    }
}
