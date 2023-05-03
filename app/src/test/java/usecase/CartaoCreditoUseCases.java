package usecase;

import credito.model.CartaoCredito;
import credito.model.Compra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartaoCreditoUseCases {

    @Test
    void shouldCreateNewCreditoWithInitialValue() {
        var credito = new CartaoCredito(1000);

        assertEquals(1000, credito.getLimite());
    }

    @Test
    void shouldDecreaseSaldoWhenCreditoIsUsedToBuySomethingUtilTheSaldoValue() {
        var credito = new CartaoCredito(1000);
        var bicicleta = new Compra("Bicicleta", 500);
        credito.comprar(bicicleta);

        assertEquals(500, credito.getSaldo());
        assertEquals(1, credito.getCompras().size());
    }

    @Test
    void shouldThrowExceptionWhenTrySpendValueGraterThenLimite() {
        var credito = new CartaoCredito(1000);
        var carro = new Compra("Palio", 45000);

        assertThrows(Exception.class, () -> credito.comprar(carro));
        assertTrue(credito.getCompras().isEmpty());
    }
}
