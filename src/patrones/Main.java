package patrones;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Examen2 - Patrones de Diseño");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        // === Singleton ===
        JTextArea singletonArea = new JTextArea();
        ConfiguracionApp config1 = ConfiguracionApp.getInstancia();
        config1.setIdioma("Inglés");
        ConfiguracionApp config2 = ConfiguracionApp.getInstancia();
        singletonArea.setText("=== PATRÓN SINGLETON ===\n"
                + "Idioma de config1: " + config1.getIdioma() + "\n"
                + "Idioma de config2: " + config2.getIdioma() + "\n"
                + "¿Misma instancia?: " + (config1 == config2));
        tabs.add("Singleton", new JScrollPane(singletonArea));

        // === Prototype ===
        JTextArea prototypeArea = new JTextArea();
        Documento original = new Documento("Contrato", "Texto original del contrato");
        Documento copia = original.clone();
        copia.setTitulo("Contrato - Copia");
        copia.setContenido("Texto modificado en la copia");
        prototypeArea.setText("=== PATRÓN PROTOTYPE ===\n"
                + "Original: " + original.getTitulo() + " - " + original.getContenido() + "\n"
                + "Copia: " + copia.getTitulo() + " - " + copia.getContenido() + "\n"
                + "¿Mismo objeto?: " + (original == copia));
        tabs.add("Prototype", new JScrollPane(prototypeArea));

        // === Factory ===
        JTextArea factoryArea = new JTextArea();
        factoryArea.setText("=== PATRÓN FACTORY ===\n");
        Vehiculo auto = VehiculoFactory.crearVehiculo("auto");
        Vehiculo moto = VehiculoFactory.crearVehiculo("moto");
        factoryArea.append("Auto -> Acelerando...\n");
        auto.acelerar();
        factoryArea.append("Moto -> Acelerando...\n");
        moto.acelerar();
        tabs.add("Factory", new JScrollPane(factoryArea));

        // === Builder ===
        JTextArea builderArea = new JTextArea();
        Pizza pizza = new Pizza.PizzaBuilder()
                .setTamaño("Grande")
                .conQueso()
                .conPepperoni()
                .build();
        builderArea.setText("=== PATRÓN BUILDER ===\n"
                + "Tamaño: " + pizza.getTamaño() + "\n"
                + "Con queso: " + pizza.tieneQueso() + "\n"
                + "Con pepperoni: " + pizza.tienePepperoni());
        tabs.add("Builder", new JScrollPane(builderArea));

        add(tabs, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}