package andreaortez_lab7p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JProgressBar;

public class Barra2 implements Runnable{

    private JProgressBar barra;
    private Archivo a;
    private double size;

    public Barra2(JProgressBar barra, Archivo a, double size) {
        this.barra = barra;
        this.a = a;
        this.size = size;
    }

    @Override
    public void run() {
        while (barra.getValue() != barra.getMaximum()) {
            barra.setValue(barra.getValue());
        }

        try {

        } catch (Exception ex) {
        }
    }
}
