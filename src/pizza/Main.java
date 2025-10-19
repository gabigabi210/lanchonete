package pizza;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //1. instancia o director
        Cozinheiro cozinheiro = new Cozinheiro();
        System.out.println("---Montando pizzas com builder");
        //montagem da pizza margherita
        //o cliente cria o builder basico(massa fina, molho de tomate
        Pizza.PizzaBuilder margheritaBuilder = new Pizza.PizzaBuilder("Fina", "Tomate");
        //o diretor recebe o builder e orquestra a montagem da margherita
        Pizza pizzaMargherita = cozinheiro.construirPizzaMargherita(margheritaBuilder);
        System.out.println("pizza.Pizza Margherita: " + pizzaMargherita);

        //montagem da pizza quatro queijos
        Pizza.PizzaBuilder quatroQueijosBuilder = new Pizza.PizzaBuilder("Grossa", "Branco");
        Pizza pizzaQuatroQueijos = cozinheiro.construirPizzaQuatroQueijos(quatroQueijosBuilder);
        System.out.println("pizza.Pizza Quatro Queijos: " + pizzaQuatroQueijos);

        //montagem da pizza vegana
        Pizza.PizzaBuilder pizzaVeganaBuilder = new Pizza.PizzaBuilder("Integral", "Pesto");
        Pizza pizzaVegana = cozinheiro.construirPizzaVegana(pizzaVeganaBuilder);
        System.out.println("pizza.Pizza vegana: " + pizzaVegana);

        Pizza.PizzaBuilder pizzaChocolateBuilder = new Pizza.PizzaBuilder("Fina", "Chocolate");
        Pizza pizzaChocolate = cozinheiro.construirPizzaChocolate(pizzaChocolateBuilder);
        System.out.println("pizza.Pizza chocolate: " + pizzaChocolate);
    }
}