import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println(
					"Ao digitar o nome do arquivo, digitar antes a pasta que ele está localizado. Ex.: src/exercicio02.txt");
			System.out.println("1 - Soma a partir de Arquivo");
			System.out.println("2 - Data Válida a partir de Arquivo");
			System.out.println("3 - Frase Invertida a partir de Arquivo");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			int opcao = sc.nextInt();

			if (opcao == 0) {
				System.out.println("Encerrando o programa.");
				break;
			} else if (opcao == 1) {
				Exercico02Arquivo();
			} else if (opcao == 2) {
				exercicioValidacaoDatas();
			} else if (opcao == 3) {
				exercicioInverterFrase();
			}
		}
	}

	public static void Exercico02Arquivo() {
		// Lê o nome do arquivo do usuário
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String fileName = scanner.nextLine();
		scanner.close();

		// Abre o arquivo e lê as linhas
		ArquivoTextoLeitura fileReader = new ArquivoTextoLeitura(fileName);
		String line;
		while ((line = fileReader.ler()) != null) {
			String[] numbers = line.split(";");
			int[] originalArray = new int[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				originalArray[i] = Integer.parseInt(numbers[i]);
			}

			// Calcula a soma dos pares de vizinhos
			List<Integer> sumList = new ArrayList<>();
			for (int i = 0; i < originalArray.length - 1; i += 2) {
				sumList.add(originalArray[i] + originalArray[i + 1]);
			}

			// Converte a lista de soma em um array
			int[] sumArray = new int[sumList.size()];
			for (int i = 0; i < sumList.size(); i++) {
				sumArray[i] = sumList.get(i);
			}

			// Imprime o resultado
			System.out.print("Vetor original: ");
			for (int number : originalArray) {
				System.out.print(number + " ");
			}
			System.out.println();
			System.out.print("Vetor de soma: ");
			for (int number : sumArray) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
		fileReader.fecharArquivo();
	}

	public static void exercicioValidacaoDatas() {
		// Lê o nome do arquivo do usuário
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String fileName = scanner.nextLine();
		scanner.close();

		// Abre o arquivo e lê as linhas
		ArquivoTextoLeitura fileReader = new ArquivoTextoLeitura(fileName);
		int numberOfDates = Integer.parseInt(fileReader.ler());
		for (int i = 0; i < numberOfDates; i++) {
			String date = fileReader.ler();
			if (isValidDate(date)) {
				System.out.println(date + " é uma data válida.");
			} else {
				System.out.println(date + " não é uma data válida.");
			}
		}
		fileReader.fecharArquivo();
	}

	public static boolean isValidDate(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(date, formatter);
		} catch (DateTimeException e) {
			return false;
		}
		return true;
	}

	public static void exercicioInverterFrase() {
		// Lê o nome do arquivo do usuário
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo: ");
		String fileName = scanner.nextLine();
		scanner.close();

		// Abre o arquivo e lê as linhas
		ArquivoTextoLeitura fileReader = new ArquivoTextoLeitura(fileName);
		String line;
		while ((line = fileReader.ler()) != null && !line.equals("fim")) {
			String reversedLine = new StringBuilder(line).reverse().toString();
			System.out.println(reversedLine);
		}
		fileReader.fecharArquivo();
	}

}
