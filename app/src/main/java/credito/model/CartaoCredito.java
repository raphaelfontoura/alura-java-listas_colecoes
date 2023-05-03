package credito.model;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double limite;
    private double saldo;
    private final List<Compra> compras;
    public CartaoCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void comprar(Compra compra) {
        if (compra.getValor() > saldo) throw new IllegalStateException("Valor acima do limite.");
        this.saldo -= compra.getValor();
        compras.add(compra);
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" +
                "limite=" + limite +
                ", saldo=" + saldo +
                ", compras=" + compras +
                '}';
    }
}
