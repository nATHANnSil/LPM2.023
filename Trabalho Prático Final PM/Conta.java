import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Conta {
    private String nome;
    private String cpf;
    private double saldo;
    public abstract double getRendimentoMensal();
    public abstract double getImposto();
    private Map<Date, String> transacoes;


    public Conta(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = 0.0;
        this.transacoes = new HashMap<>();

    }

    public void depositar(double valor) {
        this.saldo += valor;
        transacoes.put(new Date(), "Depósito: " + valor);
    }

    public abstract void sacar(double valor);

    public Map<Date, String> getExtrato() {
        return this.transacoes;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
