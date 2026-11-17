public class Utils {

    public static void  imprimirLinhas(String[] dados, int[] tamanhos){

        for (int i = 0; i < dados.length; i++) {
            String espacos = "";

            int tamanhoColuna = tamanhos[i];
            int quantidadeEspacos = tamanhoColuna - dados[i].length();
            for (int j = 0; j < quantidadeEspacos; j++) {
                espacos += " ";
            }
            System.out.print(dados[i] + espacos + " | ");
        }
        System.out.println();
    }
}
