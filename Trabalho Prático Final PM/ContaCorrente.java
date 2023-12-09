public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String numeroDaConta, String nome, String cpf, double limite) {
        super(numeroDaConta, nome, cpf);
        this.limite = limite;
    }

    //Método para sacar

    @Override
    public void sacar(double valor) {
        if (getSaldo() + limite >= valor) {
            depositar(-valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    //Método para depositar

    @Override
    public void depositar(double valor) {
        if (getSaldo() < 0) {
            super.depositar(valor - (Math.abs(getSaldo()) * 0.03 + 10));
        } else {
            super.depositar(valor);
        }
    }

    //Método para calcular o rendimento mensal

    @Override
    public double getRendimentoMensal() {
        return 0;

    }
    //Método para fazer o cálculo de imposto
    
    @Override
    public double getImposto() {
        return 0;
    }
}
