import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaRendaFixaTest {

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
	    final void testGetRendimentoMensal() {
	        ContaRendaFixa conta = new ContaRendaFixa("1234", "João", "12345678901");
	        conta.depositar(1000.0);
	        double rendimento = conta.getRendimentoMensal();
	        assertTrue(rendimento >= 5.0 && rendimento <= 8.5);
	    }

	    @Test
	    final void testGetImposto() {
	        ContaRendaFixa conta = new ContaRendaFixa("1234", "João", "12345678901");
	        conta.depositar(1000.0);
	        double imposto = conta.getImposto();
	        assertTrue(imposto >= 0.75 && imposto <= 1.275);
	    }

	    @Test
	    final void testSacar() {
	        ContaRendaFixa conta = new ContaRendaFixa("1234", "João", "12345678901");
	        conta.depositar(1000.0);
	        conta.sacar(500.0);
	        assertEquals(480.0, conta.getSaldo());
	    }

	    @Test
	    final void testContaRendaFixa() {
	        ContaRendaFixa conta = new ContaRendaFixa("1234", "João", "12345678901");
	        assertEquals("1234", conta.getNumeroDaConta());
	        assertEquals("João", conta.getNome());
	        assertEquals(0, conta.getSaldo());
	    }
}
