package patrones;

public class Pizza {
    private String tamaño;
    private boolean queso;
    private boolean pepperoni;

    private Pizza(PizzaBuilder builder) {
        this.tamaño = builder.tamaño;
        this.queso = builder.queso;
        this.pepperoni = builder.pepperoni;
    }

    public String getTamaño() {
        return tamaño;
    }

    public boolean tieneQueso() {
        return queso;
    }

    public boolean tienePepperoni() {
        return pepperoni;
    }

    public static class PizzaBuilder {
        private String tamaño;
        private boolean queso;
        private boolean pepperoni;

        public PizzaBuilder setTamaño(String tamaño) {
            this.tamaño = tamaño;
            return this;
        }

        public PizzaBuilder conQueso() {
            this.queso = true;
            return this;
        }

        public PizzaBuilder conPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}