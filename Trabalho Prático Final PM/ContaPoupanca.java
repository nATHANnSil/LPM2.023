public class ContaPoupanca extends Conta {

    public ContaPoupanca(String numeroDaConta, String nome, String cpf) {
        super(numeroDaConta, nome, cpf);
    }
 
    //Método para sacar

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            depositar(-valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    //Método para calcular o rendimento mensal

    @Override
    public double getRendimentoMensal() {
        return getSaldo() * 0.006;
    }

    //Método para obter o cálculo de imposto


    @Override
    public double getImposto() {
        return 0;
    }
}