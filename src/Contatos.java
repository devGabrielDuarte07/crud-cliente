import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    private static String[][] carregarContatosCSV() {
        String arquivo = "contatos.csv";
        String[][] matrizContatos = new String[0][5];
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

                if (dados.length >= 5) {
                    // Aumenta a matriz em 1 linha
                    matrizContatos = aumentarMatrizContatos(matrizContatos);
                    int indice = matrizContatos.length - 1;

                    // Preenche a nova linha com os dados do CSV
                    matrizContatos[indice][0] = dados[0].trim(); // codigo_contato
                    matrizContatos[indice][1] = dados[1].trim(); // codigo_cliente
                    matrizContatos[indice][2] = dados[2].trim(); // tipo
                    matrizContatos[indice][3] = dados[3].trim(); // valor
                    matrizContatos[indice][4] = dados[4].trim().toUpperCase(); // status

                    contador++;
                }
            }

            System.out.println("✓ " + contador + " contatos foram carregados do arquivo.");

        } catch (IOException e) {
            System.out.println("\n✗ Erro ao ler arquivo " + arquivo + ": " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo existe no diretório do projeto.");
        }

        return matrizContatos;
    }

    private static String[][] aumentarMatrizContatos(String[][] matrizContatos) {

        String[][] novaMatriz = new String[1][1];
        return novaMatriz;
    }

}
