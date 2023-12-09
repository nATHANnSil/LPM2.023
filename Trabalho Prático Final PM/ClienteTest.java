import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testCliente() {
	       Cliente cliente = new Cliente("João", "12345678901", "senha123");
	        assertEquals("João", cliente.getNome());
	        assertEquals("12345678901", cliente.getCpf());
	        assertEquals("senha123", cliente.getSenha());	}

	@Test
	final void testGetNome() {
	    Cliente cliente = new Cliente("João", "12345678901", "senha123");
	    assertEquals("João", cliente.getNome());
	}

	@Test
	final void testGetCpf() {
	    Cliente cliente = new Cliente("João", "12345678901", "senha123");
	    assertEquals("12345678901", cliente.getCpf());
	}

	@Test
	final void testGetSenha() {
	    Cliente cliente = new Cliente("João", "12345678901", "senha123");
	    assertEquals("senha123", cliente.getSenha());
	}


	@Test
	final void testAdicionarConta() {
        Cliente cliente = new Cliente("João", "12345678901", "senha123");
        assertNotEquals(1, cliente.getContas().size());
    }

	@Test
	final void testGetContas() {
	    Cliente cliente = new Cliente("João", "12345678901", "senha123");
	    assertNotEquals(1, cliente.getContas().size());
	}

	@Test
	final void testGetSaldoTotal() {
		Cliente cliente = new Cliente("Maria", "987654321", "senha456");
        Conta conta1 = new ContaPoupanca("002", "Maria", "987654321");
        Conta conta2 = new ContaInvestimento("003", "Maria", "987654321");

        assertEquals(0.0, cliente.getSaldoTotal());

        cliente.adicionarConta(conta1);
        cliente.adicionarConta(conta2);

        assertEquals(0.0, cliente.getSaldoTotal()); // As contas são inicializadas com saldo zero

        conta1.depositar(500);
        conta2.depositar(1000);

        assertEquals(1500.0, cliente.getSaldoTotal());
	}
}
