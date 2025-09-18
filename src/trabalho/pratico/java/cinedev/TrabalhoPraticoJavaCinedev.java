
package trabalho.pratico.java.cinedev;

   import java.util.Scanner;

public class TrabalhoPraticoJavaCinedev {

   
      public static void main(String args[]) {
        Scanner teclado = new Scanner(System.in);
        int opcao;

        // matriz de assentos
        char[][] salaDeCinema = new char[10][20];

        // cadeiras "L" são as livres
        for (int i = 0; i < salaDeCinema.length; i++) {
            for (int j = 0; j < salaDeCinema[i].length; j++) {
                salaDeCinema[i][j] = 'L';
            }
        }
                
        // Mapa de assentos
        Runnable mostrarMapa = () -> {
            System.out.println("\nMapa de assentos de cinema:");
            System.out.print("    ");
            for (int j = 0; j < salaDeCinema[0].length; j++) {
                System.out.printf("%02d ", j); // mostra cadeiras 00, 01, 02...
            }
            System.out.println();
            for (int i = 0; i < salaDeCinema.length; i++) {
                System.out.printf("F%02d ", i); // mostra fileira F00, F01...
                for (int j = 0; j < salaDeCinema[i].length; j++) {
                    System.out.print(" " + salaDeCinema[i][j] + " ");
                }
                System.out.println();
            }
        };

        do {
            
            // menu
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Mapa de assento");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Cancelar compra de ingresso");
            System.out.println("4 - Exibir relatório de ocupação");
            System.out.println("5 - Sair");

            opcao = teclado.nextInt();

            if (opcao == 1) {
                
                // mapa de assentos
                mostrarMapa.run();

            } else if (opcao == 2) {
                
                // Comprar ingresso
                System.out.println("Quantos ingressos deseja comprar? ");
                int quantidade = teclado.nextInt();

                for (int k = 1; k <= quantidade; k++) {
                    System.out.println("\nIngresso " + k + ":");
                    System.out.println("Digite o tipo ( 24,90 = Inteiro, 12,45 = Meio): ");
                    char tipo = teclado.next().toUpperCase().charAt(0);

                    System.out.println("Digite a fileira (0 a 9): ");
                    int fila = teclado.nextInt();
                    System.out.println("Digite a cadeira (0 a 19): ");
                    int cadeira = teclado.nextInt();

                    if (fila >= 0 && fila < salaDeCinema.length &&
                        cadeira >= 0 && cadeira < salaDeCinema[0].length) {

                        if (salaDeCinema[fila][cadeira] == 'L') {
                            salaDeCinema[fila][cadeira] = (tipo == 'M') ? 'M' : 'I'; // marca I ou M
                            System.out.println("Ingresso comprado com sucesso!");
                        } else {
                            System.out.println("Esse assento já está ocupado!");
                            k--; // volta para repetir essa compra
                        }
                    } else {
                        System.out.println("Assento inválido! Tente novamente.");
                        k--; // volta para repetir essa compra
                    }
                }

                // mostra mapa atualizado
                mostrarMapa.run();
