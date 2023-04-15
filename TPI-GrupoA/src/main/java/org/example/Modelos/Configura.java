package org.example.Modelos;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Getter @Setter
public class Configura {
    private int ptosPartido;
    private int ptosGoles;
    private int ptosRonda;
    private int ptosFase;
    private String fuentePronostico;

    public void instanciarConfig() throws FileNotFoundException, IOException {
        try {
            Properties prop = new Properties();
            String home = System.getProperty("user.dir");
            File f = new File(home + "\\config.properties");
            prop.load(new FileInputStream(f));
            this.setPtosPartido(Integer.parseInt(prop.getProperty("ptosPartido")));
            this.setPtosFase(Integer.parseInt(prop.getProperty("ptosGoles")));
            this.setPtosRonda(Integer.parseInt(prop.getProperty("ptosRonda")));
            this.setPtosFase(Integer.parseInt(prop.getProperty("ptosFase")));
            this.setFuentePronostico(prop.getProperty("fuentePronostico"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
