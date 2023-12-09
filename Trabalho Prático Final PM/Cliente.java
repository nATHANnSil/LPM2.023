import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String senha;
    private List<Conta> contas;

    //Construtor

    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    //Método para obter o nome
    
    public String getNome() {
        return this.nome;
    }

    //Método para obter o CPF
    
    public String getCpf() {
    	return this.cpf;
    }

    //Método para obter a senha
    
    public String getSenha() {
    	return this.senha;
    }

    //Método para criar uma nova conta

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    //Método para obter as Contas

    public List<Conta> getContas() {
        return this.contas;
    }

    //Método para obter o Saldo Total

    public double getSaldoTotal() {
        double total = 0.0;
        for (Conta conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    //Método para ver as contas

    public void verContas() {
        for (Conta conta : contas) {
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("Extrato: " + conta.getExtrato());
        }
    }
}
