public class ContaRendaFixa extends Conta {
    private static final double TAXA = 20;

    public ContaRendaFixa(String numeroDaConta, String nome, String cpf) {
        super(numeroDaConta, nome, cpf);
    }

    //Método para sacar

    @Override
    public void sacar(double valor) {
        if (getSaldo() - TAXA >= valor) {
            depositar(-valor - TAXA);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    //Método para calcular o rendimento mensal

    @Override
    public double getRendimentoMensal() {
        return getSaldo() * (Math.random() * (0.0085 - 0.005) + 0.005);
    }

    //Método para fazer o cálculo de imposto

    @Override
    public double getImposto() {
        return getRendimentoMensal() * 0.15;
    }
}