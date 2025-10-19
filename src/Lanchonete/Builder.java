package Lanchonete;

public interface Builder {
    ComboBuilder setHamburguer(Hamburguer hamburguer);
    ComboBuilder setBebida(String bebida);
    ComboBuilder setSobremesa(String sobremesa);
    ComboBuilder setAcompanhamento(String acompanhamento);
}
