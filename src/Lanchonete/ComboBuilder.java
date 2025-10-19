package Lanchonete;

import viagem.Cardapio;

public class ComboBuilder implements Builder {
    private Hamburguer hamburguer;
    private String bebida;
    private String sobremesa;
    private String acompanhamento;
    private boolean eComboPronto = false;

    @Override
    public ComboBuilder setHamburguer(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
        return this;
    }

    @Override
    public ComboBuilder setBebida(String bebida) {
        this.bebida = bebida;
        return this;
    }

    @Override
    public ComboBuilder setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
        return this;
    }

    @Override
    public ComboBuilder setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
        return this;
    }

    public ComboBuilder setEhComboPronto(boolean eComboPronto) {
        this.eComboPronto = eComboPronto;
        return this;
    }

    public Combo getCombo(){
        double precoTotal = 0.0;
        if (hamburguer != null){
            precoTotal += hamburguer.getPreco();
        }

        if (bebida != null){
            switch (bebida.toLowerCase()){
                case "milkshake":
                    precoTotal += Cardapio.getPrecoMilkshake();
                    break;
                case "refrigerante":
                    precoTotal += Cardapio.getPrecoRefrigerante();
                    break;
                case "suco":
                    precoTotal += Cardapio.getPrecoSuco();
                    break;
            }
        }

        if (acompanhamento != null){
            switch (acompanhamento.toLowerCase()){
                case "batata frita":
                    precoTotal += Cardapio.getPrecoBatataFrita();
                    break;
            }
        }

        if (sobremesa != null){
            switch (sobremesa.toLowerCase()){
                case "sorvete":
                    precoTotal += Cardapio.getPrecoSorvete();
                    break;
            }
        }

        if (eComboPronto){
            precoTotal = Cardapio.aplicarDescontoCombo(precoTotal);
        }
        return new Combo(hamburguer, bebida, sobremesa, acompanhamento, precoTotal, eComboPronto);
    }
}
