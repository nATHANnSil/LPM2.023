import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaPoupancaTest {

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
        ContaPoupanca contaPoupanca = new ContaPoupanca("123", "Cliente", "123456789");
        double rendimento = contaPoupanca.getRendimentoMensal();
        assertEquals(0.006 * contaPoupanca.getSaldo(), rendimento);
    }

    @Test
    void testGetImposto() {
        ContaPoupanca contaPoupanca = new ContaPoupanca("456", "Cliente", "987654321");
        double imposto = contaPoupanca.getImposto();
        assertEquals(0, imposto);
    }

    @Test
    void testSacar() {
        ContaPoupanca contaPoupanca = new ContaPoupanca("789", "Cliente", "111222333");
        contaPoupanca.depositar(1000);
        contaPoupanca.sacar(500);
        assertEquals(500, contaPoupanca.getSaldo());
    }

    @Test
    void testContaPoupanca() {
        ContaPoupanca contaPoupanca = new ContaPoupanca("013", "Cliente", "444555666");
        assertEquals("013", contaPoupanca.getNumeroDaConta());
        assertEquals("Cliente", contaPoupanca.getNome());
        assertEquals(0, contaPoupanca.getSaldo());
    }

}
