package viagem;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DirectorPacotes director = new DirectorPacotes();

        System.out.println("--- Montador de Pacotes de Viagem ---");
        //construção padrao via director
        PacoteViagem pacoteBasico = director.construirPacoteBasico("Paris", "Avião");
        System.out.println("Pacote sugerido: ");
        System.out.println(pacoteBasico);
        //construção customizada via builder com interação
        System.out.println("--- Construção personalizada ---");
        System.out.println("Qual o seu destino? ");
        String destino = sc.nextLine();

        System.out.println("Qual o método de transporte? ");
        String transporte = sc.nextLine();

        PacoteViagem.PacoteDeFeriasBuilder customBuilder = new PacoteViagem.PacoteDeFeriasBuilder(destino, transporte);
        System.out.println("Deseja incluir seguro viagem? [s/n] ");
        if (Objects.equals(sc.nextLine(), "s")){
            customBuilder.montarSeguroViagem();
        }
        System.out.println("Deseja incluir hotel? [s/n] ");
        if (Objects.equals(sc.nextLine(), "s")){
            System.out.println("Nome do Hotel: ");
            String hotel = sc.nextLine();
            customBuilder.montarHotel(hotel);
        }
        System.out.println("Quantos passeios turísticos quer incluir? ");
        int numPasseios = sc.nextInt();
        if (numPasseios > 0) {
            customBuilder.montarPasseios(numPasseios);
        }
        PacoteViagem pacoteCustomizado = customBuilder.build();
        System.out.println("Pronto!!!");
        System.out.println(pacoteCustomizado);
    }
}
