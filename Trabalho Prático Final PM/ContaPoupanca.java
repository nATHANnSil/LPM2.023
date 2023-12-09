public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroDaConta, String nome, String cpf) {
        super(numeroDaConta, nome, cpf);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            depositar(-valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public double getRendimentoMensal() {
        return getSaldo() * 0.006;
    }

    @Override
    public double getImposto() {
        return 0;
    }
}