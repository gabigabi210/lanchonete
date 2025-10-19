package Lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Combo {
    private final Hamburguer hamburguer;
    private final String bebida;
    private final String sobremesa;
    private final String acompanhamento;
    private final double precoTotal;
    private final boolean eComboPronto;
    private List<String> itens = new ArrayList<>();
    public Combo(Hamburguer hamburguer, String bebida, String sobremesa, String acompanhamento, double precoTotal, boolean eComboPronto) {
        this.hamburguer = hamburguer;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
        this.acompanhamento = acompanhamento;
        this.precoTotal = precoTotal;
        this.eComboPronto = eComboPronto;
    }

    public Hamburguer getHamburguer(){
        return hamburguer;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public String getBebida() {
        return bebida;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public boolean isComboPronto() {
        return eComboPronto;
    }

    @Override
    public String toString(){
        String temDesconto = "";
        if (eComboPronto){
            temDesconto = "Com desconto de combo!";
        }
        return "=== COMBO MONTADO ===\n" +
                "Lanche: " + hamburguer.toString() + "\n" +
                "Bebida: " + bebida + "\n" +
                "Acompanhamento: " + acompanhamento + "\n" +
                "Sobremesa: " + sobremesa + "\n" +
                "PREÇO FINAL: R$" + String.format("%.2f", precoTotal) + "\n" +
                temDesconto +
                "\n==============================";
    }
}
