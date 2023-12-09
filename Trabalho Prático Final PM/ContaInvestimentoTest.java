import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaInvestimentoTest {

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
        ContaInvestimento contaInvestimento = new ContaInvestimento("123", "Cliente", "123456789");
        double rendimento = contaInvestimento.getRendimentoMensal();
        assertTrue(rendimento >= -0.006 && rendimento <= 0.015);
    }

    @Test
    void testGetImposto() {
        ContaInvestimento contaInvestimento = new ContaInvestimento("456", "Cliente", "987654321");
        double imposto = contaInvestimento.getImposto();
        assertEquals(0, imposto);
    }

    @Test
    void testSacar() {
        ContaInvestimento contaInvestimento = new ContaInvestimento("789", "Cliente", "111222333");
        contaInvestimento.depositar(1000);
        contaInvestimento.sacar(500);
        assertEquals(500, contaInvestimento.getSaldo());
    }

    @Test
    void testContaInvestimento() {
        ContaInvestimento contaInvestimento = new ContaInvestimento("012", "Cliente", "444555666");
        assertEquals("012", contaInvestimento.getNumeroDaConta());
        assertEquals("Cliente", contaInvestimento.getNome());
        assertEquals(0, contaInvestimento.getSaldo());
    }
}
