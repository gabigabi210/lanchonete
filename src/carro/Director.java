package carro;

public class Director {
    public Carro construirCarroPadrao(Carro.CarroBuilder builder){
        return builder.build();
    }

    public Carro construirCarroEsportivo(Carro.CarroBuilder builder){
        return builder.comTetoSolar().comCor("Vermelho").build();
    }
}
