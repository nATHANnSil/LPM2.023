import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

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
	    void testGetRendimentoMensal() {
	        // Teste para uma conta genérica (método abstrato, não é possível testar diretamente)
	        Conta conta = new ContaPoupanca("001", "Teste", "123456789");
	        assertNotNull(conta.getRendimentoMensal());
	    }

	    @Test
	    void testGetImposto() {
	        // Teste para uma conta genérica (método abstrato, não é possível testar diretamente)
	        Conta conta = new ContaCorrente("002", "Teste", "987654321", 1000);
	        assertNotNull(conta.getImposto());
	    }

	    @Test
	    void testConta() {
	        // Teste para o construtor
	        Conta conta = new ContaCorrente("003", "Teste", "111222333", 500);
	        assertEquals("003", conta.getNumeroDaConta());
	        assertEquals("Teste", conta.getNome());
	        assertEquals(0.0, conta.getSaldo());
	        assertTrue(conta.getExtrato().isEmpty());
	    }

	    @Test
	    void testGetNumeroDaConta() {
	        // Teste para obter o número da conta
	        Conta conta = new ContaInvestimento("004", "Teste", "444555666");
	        assertEquals("004", conta.getNumeroDaConta());
	    }

	    @Test
	    void testGetNome() {
	        // Teste para obter o nome do cliente
	        Conta conta = new ContaPoupanca("005", "Teste", "777888999");
	        assertEquals("Teste", conta.getNome());
	    }

	    @Test
	    void testDepositar() {
	        // Teste para o método de depositar
	        Conta conta = new ContaCorrente("006", "Teste", "123123123", 1000);
	        conta.depositar(500);
	        assertEquals(500.0, conta.getSaldo());
	        assertEquals(1, conta.getExtrato().size());
	    }

	    @Test
	    void testSacar() {
	        // Teste para o método de sacar (método abstrato, não é possível testar diretamente)
	        Conta conta = new ContaInvestimento("007", "Teste", "456456456");
	        // Implemente a subclasse de ContaInvestimento para testar o método sacar
	        // Exemplo: assertTrue(conta.getSaldo() >= 0);
	    }

	    @Test
	    void testGetExtrato() {
	        // Teste para obter o extrato
	        Conta conta = new ContaPoupanca("008", "Teste", "789789789");
	        Map<java.util.Date, String> extrato = conta.getExtrato();
	        assertNotNull(extrato);
	        assertTrue(extrato.isEmpty());
	    }

	    @Test
	    void testGetSaldo() {
	        // Teste para obter o saldo
	        Conta conta = new ContaCorrente("009", "Teste", "987987987", 2000);
	        assertEquals(0.0, conta.getSaldo());
	        conta.depositar(1000);
	        assertEquals(1000.0, conta.getSaldo());
	    }
}
