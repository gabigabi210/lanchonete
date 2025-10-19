package carro;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        System.out.println("--Montando carros com builder");
        Carro.CarroBuilder padraoBuilder = new Carro.CarroBuilder("Normais", "1.0");
        Carro carroPadrao = director.construirCarroPadrao(padraoBuilder);
        System.out.println("Carro padrao: " + carroPadrao);
        Carro.CarroBuilder esportivoBuilder = new Carro.CarroBuilder("Corrida", "Potente");
        Carro carroEsportivo = director.construirCarroEsportivo(esportivoBuilder);
        System.out.println("Carro esportivo: " + carroEsportivo);
    }
}
