/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package AppCalculadora;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class AppCalculadora {

    public static void main(String[] args) throws Exception {
        // Define o charset UTF-8 no console
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // Código existente
        Scanner scanner = new Scanner(System.in);

        // Saudação inicial
        System.out.println("*********************************************");
        System.out.println("Bem-vindo à Calculadora de Investimentos!");
        System.out.println("*********************************************");
        
        System.out.print("Por favor, informe o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Olá, " + nome + "! Vamos começar.");

        while (true) {
            // Menu de opções
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Sair");
            System.out.print("Digite o número da operação desejada: ");

            int opcao = scanner.nextInt();

            // Tratamento das opções
            switch (opcao) {
                case 1 -> {
                    System.out.println("Operação: Soma");
                    double[] numerosSoma = lerDoisNumeros(scanner);
                    System.out.println("Resultado: " + soma(numerosSoma[0], numerosSoma[1]));
                }

                case 2 -> {
                    System.out.println("Operação: Subtração");
                    double[] numerosSub = lerDoisNumeros(scanner);
                    System.out.println("Resultado: " + subtracao(numerosSub[0], numerosSub[1]));
                }

                case 3 -> {
                    System.out.println("Operação: Multiplicação");
                    double[] numerosMult = lerDoisNumeros(scanner);
                    System.out.println("Resultado: " + multiplicacao(numerosMult[0], numerosMult[1]));
                }

                case 4 -> {
                    System.out.println("Operação: Divisão");
                    double[] numerosDiv = lerDoisNumeros(scanner);
                    try {
                        System.out.println("Resultado: " + divisao(numerosDiv[0], numerosDiv[1]));
                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 5 -> {
                    System.out.println("Operação: Raiz Quadrada");
                    System.out.print("Digite o número: ");
                    double numeroRaiz = scanner.nextDouble();
                    try {
                        System.out.println("Resultado: " + raizQuadrada(numeroRaiz));
                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 6 -> {
                    System.out.println("Encerrando o programa. Até logo, " + nome + "!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Métodos para operações matemáticas
    private static double soma(double a, double b) {
        return a + b;
    }

    private static double subtracao(double a, double b) {
        return a - b;
    }

    private static double multiplicacao(double a, double b) {
        return a * b;
    }

    private static double divisao(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }
        return a / b;
    }

    private static double raizQuadrada(double a) {
        if (a < 0) {
            throw new ArithmeticException("Não é possível calcular a raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }

    // Método auxiliar para ler dois números
    private static double[] lerDoisNumeros(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        return new double[]{num1, num2};
    }
}
