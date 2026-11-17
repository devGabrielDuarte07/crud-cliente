import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Clientes {

    public static String[][] menuCliente(String[][] matrizClientes){
        int opcCliente = 0;
        do {
            System.out.println("1 - Incluir cliente");
            System.out.println("2 - Listar clientes ativos");
            System.out.println("3 - Consultar cliente por código");
            System.out.println("4 - Alterar cliente");
            System.out.println("5 - Inativar cliente");
            System.out.println("6 - Ordenar por nome");
            System.out.println("0 - Voltar");


            Scanner input = new Scanner(System.in);

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
                    consultarClienteCodigo(matrizClientes, input);
                    break;
                case 4:
                    alterarCliente(matrizClientes, input);
                    break;
                case 5:
                    matrizClientes = inativarCliente(matrizClientes, input);
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


        String[] cabecalho = {
                "CODIGO", "NOME", "CPF/CNPJ", "NASCIMENTO",
                "SEXO", "CIDADE", "ESTADO", "STATUS"
        };

        int[] tamanhos = {8, 30, 15, 15, 10, 20, 10, 10};

        Utils.imprimirLinhas(cabecalho, tamanhos);

        for (int i = 0; i < matrizClientes.length; i++) {

            if(matrizClientes[i][7].equalsIgnoreCase("ativo")) {

                Utils.imprimirLinhas(matrizClientes[i], tamanhos);
            }
        }
    }

    private static void consultarClienteCodigo(String[][] matrizClientes, Scanner input) {

        System.out.println("Digite o código do cliente: ");
        int codigo = input.nextInt();
        String codigoStr = String.valueOf(codigo);

        int posicao = localizarCliente(matrizClientes, codigoStr);

        if(posicao != -1){
            System.out.println("CODIGO | NOME | CPF/CNPJ | NASCIMENTO | SEXO | CIDADE | ESTADO | STATUS");

            for (int j = 0; j < 8; j++) {
                System.out.print(matrizClientes[posicao][j] + " | ");
            }

            System.out.println();

        } else {
            System.out.println("Cliente com código " + codigo + " não encontrado");
        }

    }

    private static void alterarCliente(String[][] matrizClientes, Scanner input) {

        listarClientesAtivos(matrizClientes);

        System.out.println("Digite o código do cliente que deseja alterar: ");
        int codigo = input.nextInt();
        input.nextLine();
        String codigoStr = String.valueOf(codigo);

        int posicao = localizarCliente(matrizClientes, codigoStr);

        if(posicao != -1 && matrizClientes[posicao][7].equalsIgnoreCase("Ativo")){
            for (int j = 0; j < 8; j++) {
                System.out.print(matrizClientes[posicao][j] + " | ");
            }
            System.out.println();
            System.out.println("Deseja alterar esse cliente? (S/N)");
            String confirmacao = input.nextLine();
            if(confirmacao.equalsIgnoreCase("S")) {
                System.out.println("O que deseja alterar?");
                System.out.println("1 - Nome");
                System.out.println("2 - CPF/CNPJ");
                System.out.println("3 - Data de nascimento");
                System.out.println("4 - Sexo");
                System.out.println("5 - Cidade");
                System.out.println("6 - Estado");

                System.out.print("Escolha uma opção: ");
                int opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1:
                        alterarCampoCliente(matrizClientes, posicao, 1, "nome", input);
                        break;
                    case 2:
                        alterarCampoCliente(matrizClientes, posicao, 2, "CPF/CNPJ", input);
                        break;
                    case 3:
                        alterarCampoCliente(matrizClientes, posicao, 3, "data de nascimento", input);
                        break;
                    case 4:
                        alterarCampoCliente(matrizClientes, posicao, 4, "sexo", input);
                        break;
                    case 5:
                        alterarCampoCliente(matrizClientes, posicao, 5, "cidade", input);
                        break;
                    case 6:
                        alterarCampoCliente(matrizClientes, posicao, 6, "estado", input);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } else {
                System.out.println("Operação cancelada");
            }

        } else {
            System.out.println("Cliente não encontrado ou está inativo");
        }
    }

    private static String[][] inativarCliente(String[][] matrizClientes, Scanner input) {
        listarClientesAtivos(matrizClientes);
        System.out.println("Digite o código do cliente que deseja excluir: ");
        int codigo = input.nextInt();
        input.nextLine();
        String codigoStr = String.valueOf(codigo);

        int posicao = localizarCliente(matrizClientes, codigoStr);


        if(posicao != -1 && matrizClientes[posicao][7].equalsIgnoreCase("Ativo")) {

            for (int j = 0; j < 8; j++) {
                System.out.print(matrizClientes[posicao][j] + " | ");
            }
            System.out.println();
            System.out.println("Confirma exclusão? (S/N)");
            String confirmacao = input.nextLine();
            if(confirmacao.equalsIgnoreCase("S")) {
                int colunaStatus = matrizClientes[posicao].length - 1;
                matrizClientes[posicao][colunaStatus] = "Inativo";
                System.out.println("Cliente inativado com sucesso");
            }else {
                System.out.println("Operação cancelada");
            }
        } else{
            System.out.println("Cliente não encontrado ou já está inativo");        }

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


    private static int localizarCliente(String[][] matrizClientes, String codigo){

        for (int i = 0; i < matrizClientes.length; i++) {
            if(matrizClientes[i][0] != null && matrizClientes[i][0].equals(codigo)){
                return i;
            }
        }
        return -1;
    }

    private static void alterarCampoCliente(String[][] matrizCliente, int posicao, int coluna, String campo, Scanner input){
        System.out.println("Digite o novo " + campo + ":");

        String novoValor = input.nextLine();
        matrizCliente[posicao][coluna] = novoValor;

        System.out.println(campo + " alterado com sucesso");
    }
}
