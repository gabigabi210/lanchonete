package pizza;

//director
public class Cozinheiro {
    //nao precisa saber o que é pizza.Pizza, só como usar a interface do builder
    public Pizza construirPizzaMargherita(Pizza.PizzaBuilder builder){
        return builder.build();
    }

    public Pizza construirPizzaQuatroQueijos(Pizza.PizzaBuilder builder){
        //tem queijo extra mas nao tem azeitonas
        return builder.comQueijoExtra().build();
    }

    public Pizza construirPizzaVegana(Pizza.PizzaBuilder builder){
        //tem azeitonas mas nao tem queijo extra
        return builder.comAzeitonas().build();
    }

    public Pizza construirPizzaChocolate(Pizza.PizzaBuilder builder){
        return builder.comAzeitonas().build();
    }
}
