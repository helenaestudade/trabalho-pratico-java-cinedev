
package trabalho.pratico.java.cinedev;

   import java.util.Scanner;

public class TrabalhoPraticoJavaCinedev {

public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao;

        // matriz de assentos (10 fileiras x 20 cadeiras)
        char[][] salaDeCinema = new char[10][20];

        // inicializando todos os assentos como 'L' (livres)
        for (int i = 0; i < salaDeCinema.length; i++) {
            for (int j = 0; j < salaDeCinema[i].length; j++) {
                salaDeCinema[i][j] = 'L';
            }
        }

        // função para mostrar o mapa de assentos
        Runnable mostrarMapa = () -> {
            System.out.println("\nMapa de assentos de cinema:");
            System.out.print("    ");
            for (int j = 0; j < salaDeCinema[0].length; j++) {
                System.out.printf("%02d ", j);
            }
            System.out.println();
            for (int i = 0; i < salaDeCinema.length; i++) {
                System.out.printf("F%02d ", i);
                for (int j = 0; j < salaDeCinema[i].length; j++) {
                    System.out.print(" " + salaDeCinema[i][j] + " ");
                }
                System.out.println();
            }
        };

        // loop do menu
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Mapa de assento");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Cancelar compra de ingresso");
            System.out.println("4 - Exibir relatório de ocupação");
            System.out.println("5 - Sair");

            opcao = teclado.nextInt();

            if (opcao == 1) {
                mostrarMapa.run();

            } else if (opcao == 2) {
                // Comprar ingresso
                System.out.println("Quantos ingressos deseja comprar? ");
                int quantidade = teclado.nextInt();

                for (int k = 1; k <= quantidade; k++) {
                    System.out.println("\nIngresso " + k + ":");
                    System.out.println("Digite o tipo (I = Inteiro, M = Meio): ");
                    char tipo = teclado.next().toUpperCase().charAt(0);

                    System.out.println("Digite a fileira (0 a 9): ");
                    int fila = teclado.nextInt();
                    System.out.println("Digite a cadeira (0 a 19): ");
                    int cadeira = teclado.nextInt();

                    if (fila >= 0 && fila < salaDeCinema.length &&
                        cadeira >= 0 && cadeira < salaDeCinema[0].length) {

                        if (salaDeCinema[fila][cadeira] == 'L') {
                            salaDeCinema[fila][cadeira] = (tipo == 'M') ? 'M' : 'I';
                            System.out.println("Ingresso comprado com sucesso!");
                        } else {
                            System.out.println("Esse assento já está ocupado!");
                            k--;
                        }
                    } else {
                        System.out.println("Assento inválido! Tente novamente.");
                        k--;
                    }
                }
                mostrarMapa.run();

            } else if (opcao == 3) {
                // Cancelar compra
                System.out.println("Digite a fileira (0 a 9): ");
                int fila = teclado.nextInt();
                System.out.println("Digite a cadeira (0 a 19): ");
                int cadeira = teclado.nextInt();

                if (fila >= 0 && fila < salaDeCinema.length &&
                    cadeira >= 0 && cadeira < salaDeCinema[0].length) {

                    if (salaDeCinema[fila][cadeira] == 'I' || salaDeCinema[fila][cadeira] == 'M') {
                        System.out.println("Digite o tipo do ingresso a cancelar (I = Inteiro, M = Meio): ");
                        char tipoCancelamento = teclado.next().toUpperCase().charAt(0);

                        if (salaDeCinema[fila][cadeira] == tipoCancelamento) {
                            salaDeCinema[fila][cadeira] = 'L';
                            System.out.println("Compra cancelada com sucesso!");
                        } else {
                            System.out.println("O tipo informado não corresponde ao assento!");
                        }
                    } else {
                        System.out.println("Esse assento já está livre!");
                    }
                } else {
                    System.out.println("Assento inválido!");
                }
                
                mostrarMapa.run();
            }
        }
        
