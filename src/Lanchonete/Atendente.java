package Lanchonete;

import java.util.ArrayList;
import java.util.List;

//director
public class Atendente {
    public Combo buildComboPadrao(ComboBuilder builder){
        Hamburguer h = new Hamburguer("Bovina", "Brioche");
        h.temQueijoExtra();
        Combo comboPadrao = builder.setHamburguer(h)
                .setAcompanhamento("Batata Frita")
                .setBebida("Milkshake")
                .setSobremesa("Sorvete de chocolate")
                .setEhComboPronto(true)
                .getCombo();
        return comboPadrao;
    }

    public Combo buildComboVegetariano(ComboBuilder builder){
        Hamburguer h = new Hamburguer("Vegetariana", "Integral");
        h.temSalada();
        Combo combo = builder.setHamburguer(h)
                .setAcompanhamento("Batata Frita")
                .setBebida("Suco")
                .setSobremesa("Salada de Frutas")
                .setEhComboPronto(true)
                .getCombo();
        return combo;
    }

    public Combo buildComboEconomico(ComboBuilder builder){
        Hamburguer h = new Hamburguer("Bovina", "Australiano");
        Combo combo = builder.setHamburguer(h)
                .setAcompanhamento("Batata Frita")
                .setBebida("Refrigerante")
                .setSobremesa("Sem sobremesa")
                .setEhComboPronto(true)
                .getCombo();
        return combo;
    }

    public List<String> getListaCombos() {
        List<String> combos = new ArrayList<>();
        combos.add("Combo Padrão - Hamburguer bovino com queijo, batata frita, milkshake e sorvete");
        combos.add("Combo Vegetariano - Hamburguer vegetariano, batata frita, suco e salada de frutas");
        combos.add("Combo Econômico - Hamburguer bovino, batata frita e refrigerante");
        return combos;
    }
}
