package Lanchonete;

public class Cardapio {
    private static double precoHamburguerBase = 10.0;
    private static double precoBatataFrita = 8.0;
    private static double precoMilkshake = 12.0;
    private static double precoSorvete = 6.0;
    private static double precoRefrigerante = 5.0;
    private static double precoSuco = 4.0;
    private static double precoQueijoExtra = 2.0;
    private static double precoMolhoExtra = 1.0;

    private static double descontoCombo = 0.15;

    public static double getPrecoBatataFrita() {
        return precoBatataFrita;
    }

    public static double getPrecoMilkshake() {
        return precoMilkshake;
    }

    public static double getPrecoHamburguerBase() {
        return precoHamburguerBase;
    }

    public static double getPrecoSorvete() {
        return precoSorvete;
    }

    public static double getPrecoRefrigerante() {
        return precoRefrigerante;
    }

    public static double getPrecoSuco() {
        return precoSuco;
    }

    public static double getPrecoOpcionais(String item){
        switch (item) {
            case "Queijo Extra":
                return precoQueijoExtra;
            case "Molho Extra":
                return precoMolhoExtra;
            default:
                return 0.0;
        }
    }

    public static double aplicarDescontoCombo(double preco) {
        return preco * (1 - descontoCombo);
    }
}
