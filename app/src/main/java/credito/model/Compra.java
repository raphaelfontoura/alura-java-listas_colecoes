package credito.model;

public class Compra {
    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
