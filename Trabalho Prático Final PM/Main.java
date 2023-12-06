import java.util.Scanner;

public class Main {
    private static DirecaoXuBank direcao = new DirecaoXuBank();
    private static Cliente clienteAtual = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cliente");
            System.out.println("2. Diretores");
            System.out.println("3. Passar Meses");
            System.out.println("Escolha uma opção:");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                menuCliente(scanner);
            } else if (opcao == 2) {
                menuDiretores(scanner);
            } else if (opcao == 3) {
            	passarMeses(scanner);
            }
        }
    }

    private static void menuCliente(Scanner scanner) {
        System.out.println("1. Criar nova conta");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Verificar situação das contas");
        System.out.println("Escolha uma opção:");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            // Código para criar nova conta
            Conta novaConta = criarConta(scanner);
            if (novaConta != null) {
                clienteAtual.adicionarConta(novaConta);
            } else {
                System.out.println("Não foi possível criar a conta. Por favor, tente novamente.");
            }
        } else if (opcao == 2) {
            // Código para sacar
            System.out.println("Digite o valor que deseja sacar:");
            double valor = scanner.nextDouble();
            clienteAtual.getContas().get(0).sacar(valor); // Supondo que o cliente sacará da primeira conta
        } else if (opcao == 3) {
            // Código para depositar
            System.out.println("Digite o valor que deseja depositar:");
            double valor = scanner.nextDouble();
            clienteAtual.getContas().get(0).depositar(valor); // Supondo que o cliente depositará na primeira conta
        } else if (opcao == 4) {
            // Código para verificar situação das contas
            clienteAtual.verContas();
        }
    }

    private static Conta criarConta(Scanner scanner) {
        System.out.println("Digite o tipo de conta que deseja criar (corrente, poupanca, rendafixa, investimento):");
        String tipo = scanner.next();
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.next();
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.next();
        System.out.println("Digite a senha do cliente:");
        String senha = scanner.next();
        clienteAtual = criarCliente(nome, cpf, senha);
        direcao.adicionarCliente(clienteAtual);
        if (tipo.equals("corrente")) {
            System.out.println("Digite o limite para a conta corrente:");
            double limite = scanner.nextDouble();
            return new ContaCorrente(nome, cpf, limite);
        } else if (tipo.equals("poupanca")) {
            return new ContaPoupanca(nome, cpf);
        } else if (tipo.equals("rendafixa")) {
            return new ContaRendaFixa(nome, cpf);
        } else if (tipo.equals("investimento")) {
            return new ContaInvestimento(nome, cpf);
        } else {
            System.out.println("Tipo de conta inválido. Por favor, tente novamente.");
            return null;
        }
    }

    private static Cliente criarCliente(String nome, String cpf, String senha) {
        return new Cliente(nome, cpf, senha);
    }

    private static void menuDiretores(Scanner scanner) {
        System.out.println("1. Valor total em custódia para cada tipo de conta");
        System.out.println("2. Saldo médio das contas");
        System.out.println("3. Cliente com maior saldo");
        System.out.println("4. Cliente com menor saldo");
        System.out.println("Escolha uma opção:");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            // Código para obter o valor total em custódia para cada tipo de conta
            System.out.println("Valor total em custódia: " + direcao.getValorEmCustodia());
        } else if (opcao == 2) {
            // Código para obter o saldo médio das contas
            System.out.println("Saldo médio das contas: " + direcao.getSaldoMedio());
        } else if (opcao == 3) {
            // Código para obter o cliente com maior saldo
            Cliente clienteComMaiorSaldo = direcao.getClienteComMaiorSaldo();
            System.out.println("Cliente com maior saldo: " + clienteComMaiorSaldo.getNome());
        } else if (opcao == 4) {
            // Código para obter o cliente com menor saldo
            Cliente clienteComMenorSaldo = direcao.getClienteComMenorSaldo();
            System.out.println("Cliente com menor saldo: " + clienteComMenorSaldo.getNome());
        }
    }
    
    private static void passarMeses(Scanner scanner) {
        System.out.println("Digite o número de meses que deseja passar:");
        int meses = scanner.nextInt();
        for (int i = 0; i < meses; i++) {
            for (Cliente cliente : direcao.getClientes()) {
                for (Conta conta : cliente.getContas()) {
                    double rendimento = conta.getRendimentoMensal();
                    double imposto = conta.getImposto();
                    conta.depositar(rendimento - imposto);
                }
            }
        }
    }
}
