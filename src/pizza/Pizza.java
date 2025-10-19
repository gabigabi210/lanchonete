package pizza;

public class Pizza {
    // obrigatorio
    private final String massa;
    private final String molho;
    //opcionais
    private final boolean temQueijoExtra;
    private final boolean temAzeitonas;

    public Pizza(String massa, String molho, boolean temQueijoExtra, boolean temAzeitonas) {
        this.massa = massa;
        this.molho = molho;
        this.temQueijoExtra = temQueijoExtra;
        this.temAzeitonas = temAzeitonas;
    }

    @Override
    public String toString() {
        String ingredientesOpcionais = "";
        if (temQueijoExtra) {
            ingredientesOpcionais += " + Queijo Extra";
        }
        if (temAzeitonas) {
            ingredientesOpcionais += " + Azeitonas";
        }

        return "pizza.Pizza montada: [Massa: " + massa + ", Molho: " + molho + ingredientesOpcionais + "]";
    }

    public static class PizzaBuilder {
        //mesmas propriedades do produto mas sem o final
        private String massa;
        private String molho;
        //opcionais com valores padrão
        private boolean temQueijoExtra = false;
        private boolean temAzeitonas = false;

        //construtor do builder recebe os parametros obrigatorios
        public PizzaBuilder(String massa, String molho) {
            this.massa = massa;
            this.molho = molho;
        }

        //metodo construtor pra ingredientes opcionais, retorna o proprio builder pra permitir chamadas encadeadas
        public PizzaBuilder comQueijoExtra() {
            this.temQueijoExtra = true;
            return this;
        }

        public PizzaBuilder comAzeitonas() {
            this.temAzeitonas = true;
            return this; // permite o encadeamento
        }

        //metodo final: cria e retorna a instancia do produto(pizza) chamando o construtor privado do produto
        public Pizza build() {
            return new Pizza(massa, molho, temQueijoExtra, temAzeitonas);
        }
    }
}
