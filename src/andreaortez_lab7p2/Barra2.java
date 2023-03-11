package andreaortez_lab7p2;

import javax.swing.JProgressBar;

public class Barra2 implements Runnable {

    private JProgressBar barra;
    private Archivo a;
    private double size;

    public Barra2(JProgressBar barra, Archivo a, double size) {
        this.barra = barra;
        this.a = a;
        this.size = size;
        barra.setMaximum((int)size);
    }

    @Override
    public void run() {
        while (barra.getValue() != barra.getMaximum()) {
            barra.setValue(barra.getValue()+1);
        }
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
        }
        barra.setValue(0);
    }
}
