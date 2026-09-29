import java.util.Scanner;

/**
 * Programa de revisão sobre recursividade.
 *
 * Recursividade acontece quando um método chama a si mesmo para resolver
 * uma versão menor do mesmo problema. Toda recursão precisa de um caso-base
 * (uma situação simples que encerra as chamadas) para não continuar para sempre.
 *
 * Observação sobre a atividade: o enunciado pede três métodos escolhidos no
 * fórum da disciplina. Como os exemplos do fórum não estão neste material,
 * foram usados três exemplos clássicos: fatorial, Fibonacci e soma de 1 até N.
 * Se os métodos do fórum forem diferentes, basta substituir estes três métodos.
 */
public class RecursividadeClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // O menu continua aparecendo até a pessoa escolher a opção de sair.
        do {
            System.out.println("\n============================================");
            System.out.println("REVISÃO DE RECURSIVIDADE");
            System.out.println("1. Calcular o fatorial de um número");
            System.out.println("2. Encontrar um termo da sequência de Fibonacci");
            System.out.println("3. Somar os números de 1 até N");
            System.out.println("4. Encontrar a posição de um número em um vetor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número inteiro entre 0 e 20: ");
                    int numeroFatorial = scanner.nextInt();

                    // O limite 20 evita que o resultado ultrapasse o tamanho de long.
                    if (numeroFatorial < 0 || numeroFatorial > 20) {
                        System.out.println("Use um número entre 0 e 20.");
                    } else {
                        System.out.println("Fatorial de " + numeroFatorial + " = "
                                + fatorial(numeroFatorial));
                    }
                    break;

                case 2:
                    System.out.print("Digite a posição desejada (0 a 92): ");
                    int posicaoFibonacci = scanner.nextInt();

                    // O limite evita estouro do tipo long nesta implementação.
                    if (posicaoFibonacci < 0 || posicaoFibonacci > 92) {
                        System.out.println("Use uma posição entre 0 e 92.");
                    } else {
                        System.out.println("Termo " + posicaoFibonacci + " de Fibonacci = "
                                + fibonacci(posicaoFibonacci));
                    }
                    break;

                case 3:
                    System.out.print("Digite um número inteiro entre 0 e 10000: ");
                    int limite = scanner.nextInt();

                    if (limite < 0 || limite > 10000) {
                        System.out.println("Use um número entre 0 e 10000.");
                    } else {
                        System.out.println("A soma de 1 até " + limite + " = "
                                + somarAte(limite));
                    }
                    break;

                case 4:
                    System.out.print("Digite o tamanho do vetor (maior que 0): ");
                    int tamanho = scanner.nextInt();

                    if (tamanho <= 0) {
                        System.out.println("O tamanho precisa ser maior que zero.");
                        break;
                    }

                    int[] vetor = new int[tamanho];
                    for (int i = 0; i < tamanho; i++) {
                        System.out.print("Digite o elemento da posição " + i + ": ");
                        vetor[i] = scanner.nextInt();
                    }

                    System.out.print("Digite o número que deseja encontrar: ");
                    int procurado = scanner.nextInt();

                    // O método devolve o índice começando em zero, ou -1 se não encontrar.
                    int indice = encontrar(vetor, tamanho, procurado);
                    if (indice == -1) {
                        System.out.println("O número " + procurado + " não está no vetor.");
                    } else {
                        System.out.println("O número " + procurado + " está no índice " + indice
                                + " (posição " + (indice + 1) + " para uma contagem que começa em 1).");
                    }
                    break;

                case 5:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha um número de 1 a 5.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    /**
     * Calcula n! (n fatorial), que é n * (n - 1) * ... * 1.
     * Caso-base: 0! e 1! valem 1. Esse caso para a recursão.
     * Passo recursivo: n! é n multiplicado pelo fatorial de n - 1.
     */
    public static long fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    /**
     * Retorna o termo da sequência de Fibonacci na posição n.
     * A sequência começa assim: posição 0 = 0, posição 1 = 1.
     * Cada termo seguinte é a soma dos dois termos anteriores.
     */
    public static long fibonacci(int n) {
        // Casos-base: situações simples que encerram as chamadas recursivas.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Para chegar ao termo n, somamos os termos n-1 e n-2.
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Soma todos os números inteiros de 1 até n.
     * Exemplo: somarAte(4) calcula 4 + 3 + 2 + 1.
     */
    public static long somarAte(int n) {
        // Se n for zero, não há números positivos para somar.
        if (n == 0) {
            return 0;
        }

        // Diminui o problema: n mais a soma dos números até n-1.
        return n + somarAte(n - 1);
    }

    /**
     * Procura x nos primeiros n elementos do vetor A.
     * Devolve o índice (começando em zero) se encontrar; devolve -1 se não encontrar.
     */
    public static int encontrar(int[] A, int n, int x) {
        // Caso-base: não há mais elementos para olhar, então x não está no vetor.
        if (n <= 0) {
            return -1;
        }

        // Olha o último elemento da parte do vetor que ainda está sendo pesquisada.
        if (A[n - 1] == x) {
            return n - 1;
        }

        // Se não for esse, repete a busca na parte menor do vetor.
        return encontrar(A, n - 1, x);
    }
}
