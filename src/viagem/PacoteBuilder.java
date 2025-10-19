package viagem;
//1- a interface abstrata!
public interface PacoteBuilder {
    PacoteBuilder montarHotel(String nomeHotel);
    PacoteBuilder montarSeguroViagem();
    PacoteBuilder montarPasseios(int numPasseios);
    //metodo que obtem o resultado final
    PacoteViagem build();
}
