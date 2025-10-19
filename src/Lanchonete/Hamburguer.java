package Lanchonete;

import viagem.Cardapio;

import java.util.ArrayList;
import java.util.List;

public class Hamburguer {
    private String carne;
    private String pao;
    private final List<String> adicoes = new ArrayList<>();
    private double preco;

    public Hamburguer(String carne, String pao) {
        this.carne = carne;
        this.pao = pao;
        this.preco += Cardapio.getPrecoHamburguerBase();
    }

    public void temSalada(){
        adicoes.add("Salada");
    }

    public void temMolhoExtra(){
        double precoAdicional = Cardapio.getPrecoOpcionais("Molho Extra");
        adicoes.add("Molho Extra");
        this.preco += precoAdicional;
    }

    public void temQueijoExtra(){
        double precoAdicional = Cardapio.getPrecoOpcionais("Queijo Extra");
        adicoes.add("Queio Extra");
        this.preco += precoAdicional;
    }

    public double getPreco(){
        return this.preco;
    }

    @Override
    public String toString() {
        return "Hamburguer [Carne: " + carne + ", Pão: " + pao +
                ", Adicionais: " + adicoes + ", Preço: R$" + String.format("%.2f", preco) + "]";
    }
}
