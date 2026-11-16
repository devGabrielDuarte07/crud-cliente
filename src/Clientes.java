import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Clientes {

    public static String[][] menuCliente(String[][] matrizClientes){
        System.out.println("1 - Incluir cliente");
        System.out.println("2 - Listar clientes ativos");
        System.out.println("3 - Consultar cliente por código");
        System.out.println("4 - Alterar cliente");
        System.out.println("5 - Inativar cliente");
        System.out.println("6 - Ordenar por nome");
        System.out.println("0 - Voltar");

        int opcCliente = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Digite a opção que deseja realizar: ");
            opcCliente = input.nextInt();

            switch (opcCliente){
                case 1:
                    matrizClientes = incluirCliente(matrizClientes);
                    break;
                case 2:
                    listarClientesAtivos(matrizClientes);
                    break;
                case 3:
                    consultarClienteCodigo(matrizClientes);
                    break;
                case 4:
                    alterarCliente(matrizClientes);
                    break;
                case 5:
                    matrizClientes = inativarCliente(matrizClientes);
                    break;
                case 6:
                    ordenarPorNome(matrizClientes);
                    break;
                case 0:
                    break;
            }
        }while (opcCliente != 0);

        return matrizClientes;
    }

    private static String[][] incluirCliente(String[][] matrizClientes) {

        String[][] novaMatriz = new String[1][1];

        return novaMatriz;
    }

    private static void listarClientesAtivos(String[][] matrizClientes) {


        System.out.println("CODIGO | NOME | CPF/CNPJ | NASCIMENTO | SEXO | CIDADE | ESTADO | STATUS");

        for (int i = 0; i < matrizClientes.length; i++) {

            if(matrizClientes[i][7].equalsIgnoreCase("ativo")) {

                for (int j = 0; j < 8; j++) {
                    System.out.print(matrizClientes[i][j] + " | ");
                }

                System.out.println();
            }
        }
    }

    private static void consultarClienteCodigo(String[][] matrizClientes) {

    }

    private static void alterarCliente(String[][] matrizClientes) {
    }

    private static String[][] inativarCliente(String[][] matrizClientes) {
        listarClientesAtivos(matrizClientes);
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o código do cliente que deseja excluir: ");
        int codigo = input.nextInt();


        return matrizClientes;
    }

    private static void ordenarPorNome(String[][] matrizClientes) {
    }



    public static String[][] carregarClientesCSV() {
        String arquivo = "clientes.csv";
        String[][] matrizClientes = new String[0][8];
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Divide a linha por vírgula
                String[] dados = linha.split(",");

                if (dados.length >= 8) {
                    // Aumenta a matriz em 1 linha
                    matrizClientes = aumentarMatrizClientes(matrizClientes);
                    int indice = matrizClientes.length - 1;

                    // Preenche a nova linha com os dados do CSV
                    matrizClientes[indice][0] = dados[0].trim(); // codigo
                    matrizClientes[indice][1] = dados[1].trim(); // nome
                    matrizClientes[indice][2] = dados[2].trim(); // cpf_cnpj
                    matrizClientes[indice][3] = dados[3].trim(); // data_nascimento
                    matrizClientes[indice][4] = dados[4].trim(); // sexo
                    matrizClientes[indice][5] = dados[5].trim(); // cidade
                    matrizClientes[indice][6] = dados[6].trim(); // estado
                    matrizClientes[indice][7] = dados[7].trim().toUpperCase(); // status

                    contador++;
                }
            }

            System.out.println("✓ " + contador + " clientes foram carregados do arquivo.");

        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }

        return matrizClientes;
    }

    private static String[][] aumentarMatrizClientes(String[][] matriz) {
        String[][] novaMatriz = new String[matriz.length + 1][8];

        for (int i = 0; i < matriz.length; i++) {
            novaMatriz[i] = matriz[i];
        }

        return novaMatriz;
    }
}
