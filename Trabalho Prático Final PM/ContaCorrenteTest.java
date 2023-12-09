import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaCorrenteTest {

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
        ContaCorrente contaCorrente = new ContaCorrente("123", "Cliente", "123456789", 1000);
        assertEquals(0, contaCorrente.getRendimentoMensal());
    }

    @Test
    void testGetImposto() {
        ContaCorrente contaCorrente = new ContaCorrente("456", "Cliente", "987654321", 2000);
        assertEquals(0, contaCorrente.getImposto());
    }

    @Test
    void testDepositar() {
        ContaCorrente contaCorrente = new ContaCorrente("789", "Cliente", "111222333", 500);
        contaCorrente.depositar(300);
        assertEquals(300, contaCorrente.getSaldo());
    }

    @Test
    void testSacar() {
        ContaCorrente contaCorrente = new ContaCorrente("012", "Cliente", "444555666", 1000);
        contaCorrente.depositar(500);
        contaCorrente.sacar(200);
        assertEquals(300, contaCorrente.getSaldo());
    }

    @Test
    void testContaCorrente() {
        ContaCorrente contaCorrente = new ContaCorrente("345", "Cliente", "777888999", 1500);
        assertEquals("345", contaCorrente.getNumeroDaConta());
        assertEquals("Cliente", contaCorrente.getNome());
        assertEquals(0, contaCorrente.getSaldo());
    }

}
