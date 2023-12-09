import java.util.ArrayList;
import java.util.List;

public class DirecaoXuBank {
    private List<Cliente> clientes;

    public DirecaoXuBank() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public List<Cliente> getClientes(){
    	return this.clientes;
    }

    public double getValorEmCustodia() {
        double total = 0.0;
        for (Cliente cliente : clientes) {
            total += cliente.getSaldoTotal();
        }
        return total;
    }

    public double getSaldoMedio() {
        return getValorEmCustodia() / clientes.size();
    }

    //Método para obter o cliente com Maior Saldo


    public Cliente getClienteComMaiorSaldo() {
        Cliente clienteComMaiorSaldo = null;
        for (Cliente cliente : clientes) {
            if (clienteComMaiorSaldo == null || cliente.getSaldoTotal() > clienteComMaiorSaldo.getSaldoTotal()) {
                clienteComMaiorSaldo = cliente;
            }
        }
        return clienteComMaiorSaldo;
    }

    //Método para obter o cliente com Menor Saldo

    public Cliente getClienteComMenorSaldo() {
        Cliente clienteComMenorSaldo = null;
        for (Cliente cliente : clientes) {
            if (clienteComMenorSaldo == null || cliente.getSaldoTotal() < clienteComMenorSaldo.getSaldoTotal()) {
                clienteComMenorSaldo = cliente;
            }
        }
        return clienteComMenorSaldo;
    }
}