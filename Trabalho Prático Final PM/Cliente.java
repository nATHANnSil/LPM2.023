import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public double getSaldoTotal() {
        double total = 0.0;
        for (Conta conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public void verContas() {
        for (Conta conta : contas) {
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("Extrato: " + conta.getExtrato());
        }
    }
}
