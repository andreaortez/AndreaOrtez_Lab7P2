package andreaortez_lab7p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Barra implements Runnable {

    private JProgressBar barra, barra2;
    private Carpeta c;
    private ArrayList<Archivo> archivos = new ArrayList();

    public Barra(JProgressBar barra, JProgressBar barra2, Carpeta c) {
        this.barra = barra;
        this.barra2 = barra2;
        this.c = c;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {

        double tiempo = 0;
        for (Archivo a : archivos) {

            try {
                tiempo += a.getTamaño();
                Barra2 b = new Barra2(barra2, a, tiempo);
                Thread process = new Thread(b);
                process.start();

                //bitacora
                File file = new File("./bitacora.txt");
                FileWriter fw = null;
                BufferedWriter bw = null;
                fw = new FileWriter(file, true);
                bw = new BufferedWriter(fw);
                String cad = a.getNombre() + " -> " + a.getTamaño() + " -> " + new Date() + "\n";
                bw.write(cad);
                bw.flush();
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Barra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        double sleep = tiempo / 10;
        sleep *= 1000;
        barra.setValue(barra.getValue() + 1);

        try {
            Thread.sleep((long) sleep);
        } catch (InterruptedException ex) {
        }
    }

    public void cantidad(Carpeta c) {
        for (Archivo a : c.getArchivos()) {
            archivos.add(a);
        }
        for (Carpeta car : c.getCarpetas()) {
            cantidad(car);
        }
    }
}
