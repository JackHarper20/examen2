package patrones;

public class ConfiguracionApp {

    private static ConfiguracionApp instancia;
    private String idioma;

    private ConfiguracionApp() {
        idioma = "Español";
    }

    public static ConfiguracionApp getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionApp();
        }
        return instancia;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }
}