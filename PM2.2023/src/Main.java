import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println("EXERCÍCIOS BÁSICOS:");
			System.out.println("1 - Inverter Vetor");
			System.out.println("2 - Somar Pares de Vizinhos");
			System.out.println("3 - Retângulo de Caracteres");
			System.out.println("4 - Frase Invertida");
			System.out.println("EXERCÍCIOS APLICADOS:");
			System.out.println("5 - Organizar Plano de Estudos");
			System.out.println("6 - Vencedor Loteria");
			System.out.println("7 - Multiplicação por 11");
			System.out.println("8 - Data Válida");
			System.out.println("9 - Dia da Semana 2024");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			int opcao = sc.nextInt();

			if (opcao == 0) {
				System.out.println("Encerrando o programa.");
				break;
			} else if (opcao == 1) {
				inverterVetor();
			} else if (opcao == 2) {
				somarParesVizinhos();
			} else if (opcao == 3) {
				RetangulodeCaracteres();
			} else if (opcao == 4) {
				FraseInvertida();
			} else if (opcao == 5) {
				planoDeEstudos();
			} else if (opcao == 6) {
				vencedorLoteria();
			} else if (opcao == 7) {
				multiplicacaoPorOnze();
			} else if (opcao == 8) {
				System.out.print("Digite uma data no formato DD/MM/AAAA: ");
				String data = scanner.nextLine();
				dataValida.verificaData(data);
				break;
			} else if (opcao == 9) {
				diaDaSemana();
			} else {
				System.out.println("Opção inválida. Escolha novamente.");
			}

			sc.nextLine(); // Consumes the newline character after each operation
		}

		sc.close();
	}

	public static void inverterVetor() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[5]; // Criar um vetor para armazenar os números

		for (int i = 0; i < 5; i++) {
			System.out.println("Digite um número:");
			int num = sc.nextInt();
			numeros[i] = num; // Armazenar o número no vetor
		}

		// Imprime o vetor original
		System.out.println("Vetor criado:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println(); // Pular linha após a impressão do vetor original

		// Invertendo a ordem dos elementos do vetor
		for (int i = 0; i < numeros.length / 2; i++) {
			int temp = numeros[i];
			numeros[i] = numeros[numeros.length - 1 - i];
			numeros[numeros.length - 1 - i] = temp;
		}

		// Imprimir o vetor invertido
		System.out.println("Vetor invertido:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println(); // Pular linha após a impressão do vetor invertido
	}

	public static void somarParesVizinhos() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o tamanho do vetor:");
		int tamanho = sc.nextInt();

		int[] vetorOriginal = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite um número:");
			vetorOriginal[i] = sc.nextInt();
		}

		int[] vetorSoma = new int[tamanho];
		for (int i = 0; i < tamanho; i++) {
			int soma = vetorOriginal[i];
			if (i > 0) {
				soma += vetorOriginal[i - 1];
			}
			if (i < tamanho - 1) {
				soma += vetorOriginal[i + 1];
			}
			vetorSoma[i] = soma;
		}

		System.out.println("Vetor original:");
		for (int num : vetorOriginal) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("Vetor de somas:");
		for (int soma : vetorSoma) {
			System.out.print(soma + " ");
		}
		System.out.println();

		sc.close();
	}

	public static void RetangulodeCaracteres() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o número de caracteres da base do retângulo: ");
		int base = scanner.nextInt();

		System.out.print("Digite o número de caracteres da altura do retângulo: ");
		int altura = scanner.nextInt();

		char simbolo = 'X'; // Símbolo para o retângulo

		scanner.close();

		for (int i = 1; i <= altura; i++) {
			for (int j = 1; j <= base; j++) {
				if (i == 1 || i == altura || j == 1 || j == base) {
					System.out.print(simbolo);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}
	}

	public static void FraseInvertida() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Digite uma frase (ou 'fim' para encerrar): ");
			String frase = scanner.nextLine();

			if (frase.equalsIgnoreCase("fim")) {
				System.out.println("Encerrando o programa.");
				break;
			}

			String fraseInvertida = inverterFrase(frase);
			System.out.println("Frase invertida: " + fraseInvertida);
		}

		scanner.close();
	}

	public static String inverterFrase(String frase) {
		StringBuilder builder = new StringBuilder(frase);
		return builder.reverse().toString();
	}

	public static void planoDeEstudos() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o número de disciplinas: ");
		int disciplinas = scanner.nextInt();

		System.out.print("Digite o total de horas disponíveis: ");
		int horas = scanner.nextInt();

		System.out.print("Digite o total de minutos disponíveis: ");
		int minutos = scanner.nextInt();

		scanner.close();

		int totalMinutosDisponiveis = horas * 60 + minutos;
		int tempoPorDisciplina = totalMinutosDisponiveis / disciplinas;
		int minutosRestantes = totalMinutosDisponiveis % disciplinas;

		int hora = tempoPorDisciplina / 60;
		int minuto = tempoPorDisciplina % 60;

		System.out.println("Tempo de estudo por disciplina: " + hora + " horas e " + minuto + " minutos");

		if (minutosRestantes > 0) {
			System.out
					.println("Distribua " + minutosRestantes + " minutos de descanso nas pausas entre as disciplinas.");
		}

	}

	public static void vencedorLoteria() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o primeiro prêmio da loteria federal: ");
		int primeiroPremio = scanner.nextInt();

		System.out.print("Digite o segundo prêmio da loteria federal: ");
		int segundoPremio = scanner.nextInt();

		int parte1SegundoPremio = segundoPremio / 1000;
		int parte2PrimeiroPremio = primeiroPremio % 1000;

		int numeroVencedor = parte1SegundoPremio * 1000 + parte2PrimeiroPremio;

		System.out.println("O número vencedor da organização é: " + numeroVencedor);

		scanner.close();
	}

	public static void multiplicacaoPorOnze() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um número de 2 dígitos: ");
		int num = scanner.nextInt();

		int digito1 = num / 10;
		int digito2 = num % 10;

		int soma = digito1 + digito2;

		if (soma > 9) {
			digito1 += 1;
			soma -= 10;
		}

		int resultado = digito1 * 100 + soma * 10 + digito2;

		System.out.println("Resultado da multiplicação por 11: " + resultado);

		scanner.close();
	}

	public static void diaDaSemana() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite uma data no formato dd/MM/yyyy: ");
		String inputDate = scanner.nextLine();
		scanner.close();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(inputDate, formatter);
		System.out.println("O dia da semana para a data " + inputDate + " é: " + date.getDayOfWeek()
				.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.forLanguageTag("pt-BR")));

	}

}