package viagem;

import java.util.ArrayList;
import java.util.List;

//1. o produto
public class PacoteViagem {
    private final String destino;
    private final String transporte;
    private final List<String> itens = new ArrayList<>();

    private PacoteViagem(String destino, String transporte){
        this.destino = destino;
        this.transporte = transporte;
        this.itens.add("Transporte: " + transporte);
    }

    public void adicionarItem(String item){
        this.itens.add(item);
    }

    @Override
    public String toString(){
        String resultado = "\n --- Pacote para " + destino + " ---\n";
        for (String item : itens){
            resultado += "- " + item + "\n";
        }
        return resultado;
    }

    // a classe builder concreta implementa a interface de construção
    public static class PacoteDeFeriasBuilder implements PacoteBuilder{
        //campos obrigatorios (recebidos no construtor
        private final String destino;
        private final String transporte;
        //o produto
        private PacoteViagem pacote;
        //construtor de concreteBuilder recebe os obrigatorios
        public PacoteDeFeriasBuilder(String destino, String transporte){
            this.destino = destino;
            this.transporte = transporte;
            // inicializa o produto
            this.pacote = new PacoteViagem(destino, transporte);
        }

        @Override
        public PacoteBuilder montarHotel(String nomeHotel) {
            pacote.adicionarItem("Hospedagem: Hotel " + nomeHotel);
            return this;
        }

        @Override
        public PacoteBuilder montarSeguroViagem() {
            pacote.adicionarItem("Serviço: Seguro Viagem Completo");
            return this;
        }

        @Override
        public PacoteBuilder montarPasseios(int numPasseios) {
            pacote.adicionarItem("Atividades: " + numPasseios + "Passeio(s) Turístico(s).");
            return this;
        }

        @Override
        public PacoteViagem build() {
            return this.pacote;
        }
    }

}
