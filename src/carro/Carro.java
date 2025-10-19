package carro;

public class Carro {
    //obrigatorios
    private final String motor;
    private final String pneus;
    //opcionais
    private final String cor;
    private final boolean temTetoSolar;
    //construtor privado que e usado apenas pelo builder

    private Carro(String motor, String pneus, String cor, boolean temTetoSolar) {
        this.cor = cor;
        this.motor = motor;
        this.pneus = pneus;
        this.temTetoSolar = temTetoSolar;
    }
    @Override
    public String toString(){
        String tetoSolar = " e nao tem teto solar.";
        if (temTetoSolar) {
            tetoSolar = " e tem teto solar.";
        }
        return "Carro montado: [motor: " + motor + ", pneus: " + pneus + ", cor: " + cor + tetoSolar;
    }

    public static class CarroBuilder {
        private String motor;
        private String pneus;
        private String cor = "Branco";
        private boolean temTetoSolar = false;
        // apenas os obrigatorios
        public CarroBuilder(String pneus, String motor) {
            this.pneus = pneus;
            this.motor = motor;
        }

        public CarroBuilder comCor(String cor){
            this.cor = cor;
            return this;
        }

        public CarroBuilder comTetoSolar(){
            this.temTetoSolar = true;
            return this;
        }

        public Carro build(){
            return new Carro(motor, pneus, cor, temTetoSolar);
        }
    }
}
