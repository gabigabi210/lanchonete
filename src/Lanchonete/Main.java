package Lanchonete;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Atendente atendente = new Atendente();

        System.out.println("Bem vindo à Lanchonete Brat!");
        while (true){

            System.out.println("\nVocê deseja:");
            System.out.println("[1] Pedir um combo pronto (com desconto!)");
            System.out.println("[2] Montar seu próprio combo");
            System.out.println("[3] Sair");
            System.out.print("Opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                pedirComboPronto(sc, atendente);
                break;
            } else if (opcao == 2) {
                montarComboPersonalizado(sc);
                break;
            } else if (opcao == 3) {
                System.out.println("Obrigado pela preferência! Volte sempre!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }

    private static void pedirComboPronto(Scanner sc, Atendente atendente) {
        System.out.println("Nossos combos prontos (com 15% de desconto!): ");
        List<String> listaCombos = atendente.getListaCombos();
        for (int i = 0; i < listaCombos.size(); i++){
            System.out.println("[" + (i + 1) + "]" + listaCombos.get(i));
        }
        System.out.println("Qual você deseja: ");
        int opcaoCombo = sc.nextInt();
        sc.nextLine();

        ComboBuilder builder = new ComboBuilder();
        Combo combo = null;

        switch (opcaoCombo) {
            case 1:
                combo = atendente.buildComboPadrao(builder);
                break;
            case 2:
                combo = atendente.buildComboVegetariano(builder);
                break;
            case 3:
                combo = atendente.buildComboEconomico(builder);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        System.out.println("\n" + combo);
        System.out.println("Deseja adicionar algo extra? (s/n): ");
        String resposta = sc.nextLine();
        if (resposta.toLowerCase().equals("s")){
            adicionarExtras(sc, combo);
        }
    }


    private static void montarComboPersonalizado(Scanner sc) {
        System.out.println("Vamos montar o seu combo personalizado! ");
        ComboBuilder builder = new ComboBuilder();
        System.out.println("\nEscolha o hamburguer:");
        System.out.println("[1] Bovino com pão brioche");
        System.out.println("[2] Vegetariano com pão integral");
        System.out.println("[3] Frango com pão australiano");
        System.out.print("Opção: ");
        int opHamburguer = sc.nextInt();
        sc.nextLine();

        Hamburguer hamburguer = null;

        switch (opHamburguer) {
            case 1:
                hamburguer = new Hamburguer("Bovina", "Brioche");
                break;
            case 2: hamburguer =
                new Hamburguer("Vegetariana", "Integral");
                break;
            case 3:
                hamburguer = new Hamburguer("Frango", "Australiano");
                break;
        }
        System.out.print("Deseja queijo extra? (s/n): ");
        if (sc.nextLine().toLowerCase().equals("s")){
            hamburguer.temQueijoExtra();
        }
        System.out.print("Deseja molho extra? (s/n): ");
        if (sc.nextLine().toLowerCase().equals("s")){
            hamburguer.temMolhoExtra();
        }
        System.out.print("Deseja salada? (s/n): ");
        if (sc.nextLine().toLowerCase().equals("s")){
            hamburguer.temSalada();
        }

        System.out.println("\nEscolha a bebida:");
        System.out.println("[1] Milkshake");
        System.out.println("[2] Refrigerante");
        System.out.println("[3] Suco");
        System.out.println("[4] Sem bebida");
        System.out.print("Opção: ");
        int opBebida = sc.nextInt();
        sc.nextLine();

        String bebida = "";
        switch (opBebida) {
            case 1:
                bebida = "Milkshake";
                break;
            case 2:
                bebida = "Refrigerante";
                break;
            case 3:
                bebida = "Suco";
                break;
            case 4:
                bebida = "Sem bebida";
                break;
        }

        System.out.print("Deseja batata frita? (s/n): ");
        String acompanhamento = "Sem acompanhamento";
        if (sc.nextLine().toLowerCase().equals("s")){
            acompanhamento = "Batata Frita";
        }

        System.out.println("\nEscolha a sobremesa:");
        System.out.println("[1] Sorvete");
        System.out.println("[2] Salada de frutas");
        System.out.println("[3] Sem sobremesa");
        System.out.print("Opção: ");
        int opSobremesa = sc.nextInt();
        sc.nextLine();

        String sobremesa = "";
        switch (opSobremesa) {
            case 1:
                sobremesa = "Sorvete";
                break;
            case 2:
                sobremesa = "Salada de Frutas";
                break;
            case 3:
                sobremesa = "Sem sobremesa";
                break;
        }

        Combo comboPersonalizado = builder.setHamburguer(hamburguer)
                .setBebida(bebida)
                .setAcompanhamento(acompanhamento)
                .setSobremesa(sobremesa)
                .setEhComboPronto(false)
                .getCombo();
        System.out.println(comboPersonalizado);
    }

    private static void adicionarExtrasAoCombo(Scanner sc, Atendente atendente) {
        System.out.println("\nPrimeiro, escolha um combo base:");
        pedirComboPronto(sc, atendente);
    }
    private static void adicionarExtras(Scanner sc, Combo combo) {
        double extra = 0;
        List<String> extras = new ArrayList<>();

        System.out.print("Deseja adicionar mais um milkshake? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            extra += Cardapio.getPrecoMilkshake();
            extras.add("Milkshake extra");
        }

        System.out.print("Deseja adicionar mais uma batata frita? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            extra += Cardapio.getPrecoBatataFrita();
            extras.add("Batata frita extra");
        }

        if (!extras.isEmpty()) {
            double novoTotal = combo.getPrecoTotal() + extra;
            System.out.println("\n=== COMBO COM EXTRAS ===");
            System.out.println("Combo base: R$" + String.format("%.2f", combo.getPrecoTotal()));
            for (String item : extras) {
                System.out.println(item);
            }
            System.out.println("Total com extras: R$" + String.format("%.2f", novoTotal));
            System.out.println("========================");
        }

    }
}

