public class ContaRendaFixa extends Conta {
    private static final double TAXA = 20;

    public ContaRendaFixa(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() - TAXA >= valor) {
            depositar(-valor - TAXA);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public double getRendimentoMensal() {
        return getSaldo() * (Math.random() * (0.0085 - 0.005) + 0.005);
    }

    @Override
    public double getImposto() {
        return getRendimentoMensal() * 0.15;
    }
}