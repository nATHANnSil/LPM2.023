import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
    private String nome;
    private String cpf;
    private double saldo;
    private String numeroDaConta;
    public abstract double getRendimentoMensal();
    public abstract double getImposto();
    private Map<Date, String> transacoes;

    //Construtor

    public Conta(String numeroDaConta, String nome, String cpf) {
        this.numeroDaConta = numeroDaConta;
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = 0.0;
        this.transacoes = new HashMap<>();

    }

    //Método para obter o numero da Conta

    public String getNumeroDaConta() {
        return this.numeroDaConta;
    }

    //Método para obter o nome do Cliente
    
    public String getNome() {
        return this.nome;
    }

    //Método para depositar

    public void depositar(double valor) {
        this.saldo += valor;
        transacoes.put(new Date(), "Depósito: " + valor);
    }

    //Método para sacar

    public abstract void sacar(double valor);

    public Map<Date, String> getExtrato() {
        return this.transacoes;
    }

    //Método para obter o saldo

    public double getSaldo() {
        return this.saldo;
    }
}
