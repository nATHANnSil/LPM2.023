import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirecaoXuBankTest {
	
    private DirecaoXuBank banco;
    private Cliente cliente1, cliente2, cliente3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

    @BeforeEach
    void setUp() {
        banco = new DirecaoXuBank();
        cliente1 = new Cliente("Cliente1", "111.111.111-11", "senha1");
        cliente2 = new Cliente("Cliente2", "222.222.222-22", "senha2");
        cliente3 = new Cliente("Cliente3", "333.333.333-33", "senha3");
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);
        banco.adicionarCliente(cliente3);
    }

	@AfterEach
	void tearDown() throws Exception {
	}

    @Test
    final void testDirecaoXuBank() {
        assertNotNull(banco);
        assertTrue(banco.getClientes().isEmpty());
    }

    @Test
    final void testAdicionarCliente() {
        Cliente novoCliente = new Cliente("NovoCliente", "444.444.444-44", "senha4");
        banco.adicionarCliente(novoCliente);
        assertTrue(banco.getClientes().contains(novoCliente));
    }

    @Test
    final void testGetClientes() {
        List<Cliente> clientes = banco.getClientes();
        assertNotNull(clientes);
        assertEquals(3, clientes.size());
        assertTrue(clientes.contains(cliente1));
        assertTrue(clientes.contains(cliente2));
        assertTrue(clientes.contains(cliente3));
    }

    @Test
    final void testGetValorEmCustodia() {
        cliente1.adicionarConta(new ContaCorrente("1", "Conta1", "111.111.111-11", 1000));
        cliente2.adicionarConta(new ContaPoupanca("2", "Conta2", "222.222.222-22"));
        cliente3.adicionarConta(new ContaInvestimento("3", "Conta3", "333.333.333-33"));
        
        assertEquals(0.0, banco.getValorEmCustodia());

        // Adicionando saldo às contas
        cliente1.getContas().get(0).depositar(500.0);
        cliente2.getContas().get(0).depositar(1000.0);
        cliente3.getContas().get(0).depositar(2000.0);

        assertEquals(3500.0, banco.getValorEmCustodia());
    }

    @Test
    final void testGetSaldoMedio() {
        cliente1.adicionarConta(new ContaCorrente("1", "Conta1", "111.111.111-11", 1000));
        cliente2.adicionarConta(new ContaPoupanca("2", "Conta2", "222.222.222-22"));
        cliente3.adicionarConta(new ContaInvestimento("3", "Conta3", "333.333.333-33"));
        
        assertEquals(0.0, banco.getSaldoMedio());

        // Adicionando saldo às contas
        cliente1.getContas().get(0).depositar(500.0);
        cliente2.getContas().get(0).depositar(1000.0);
        cliente3.getContas().get(0).depositar(2000.0);

        assertNotEquals(1166.67, banco.getSaldoMedio(), 0.01);
    }

    @Test
    final void testGetClienteComMaiorSaldo() {
        assertNull(banco.getClienteComMaiorSaldo());

        cliente1.adicionarConta(new ContaCorrente("1", "Conta1", "111.111.111-11", 1000));
        cliente2.adicionarConta(new ContaPoupanca("2", "Conta2", "222.222.222-22"));
        cliente3.adicionarConta(new ContaInvestimento("3", "Conta3", "333.333.333-33"));

        // Adicionando saldo às contas
        cliente1.getContas().get(0).depositar(500.0);
        cliente2.getContas().get(0).depositar(1000.0);
        cliente3.getContas().get(0).depositar(2000.0);

        assertEquals(cliente3, banco.getClienteComMaiorSaldo());
    }

    @Test
    final void testGetClienteComMenorSaldo() {
        assertNull(banco.getClienteComMenorSaldo());

        cliente1.adicionarConta(new ContaCorrente("1", "Conta1", "111.111.111-11", 1000));
        cliente2.adicionarConta(new ContaPoupanca("2", "Conta2", "222.222.222-22"));
        cliente3.adicionarConta(new ContaInvestimento("3", "Conta3", "333.333.333-33"));

        // Adicionando saldo às contas
        cliente1.getContas().get(0).depositar(500.0);
        cliente2.getContas().get(0).depositar(1000.0);
        cliente3.getContas().get(0).depositar(2000.0);

        assertEquals(cliente1, banco.getClienteComMenorSaldo());
    }

}
