package viagem;
//2- O director (Construct())
public class DirectorPacotes {
    public PacoteViagem construirPacoteBasico(String destino, String transporte) {
        //cria e inicializa o builder
        PacoteViagem.PacoteDeFeriasBuilder builder = new PacoteViagem.PacoteDeFeriasBuilder(destino, transporte);
        //receita basica
        return builder.montarHotel("Estrela do mar").build();
    }
}
