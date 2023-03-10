package andreaortez_lab7p2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Frame extends javax.swing.JFrame {
    
    Random random = new Random();
    AdminBinario ab = new AdminBinario("./files");
    String linkF = "dive.google.com/";
    
    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        ab.cargarArchivo();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl__opciones = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jt_listar = new javax.swing.JTree();
        pb1 = new javax.swing.JProgressBar();
        pb2 = new javax.swing.JProgressBar();
        bt_crearA = new javax.swing.JButton();
        bt_crearC = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl__opciones.setFont(new java.awt.Font("Dubai", 0, 36)); // NOI18N
        jl__opciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mi Unidad", "Destacados", "Papelera" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jl__opciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jl__opcionesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jl__opciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 240, 210));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        Jt_listar.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(Jt_listar);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 370, 380));
        jPanel1.add(pb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 310, 30));
        jPanel1.add(pb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 310, 30));

        bt_crearA.setText("Crear Archivo");
        bt_crearA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_crearAMouseClicked(evt);
            }
        });
        jPanel1.add(bt_crearA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        bt_crearC.setText("Crear Carpeta");
        bt_crearC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_crearCMouseClicked(evt);
            }
        });
        jPanel1.add(bt_crearC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 710, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_crearAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_crearAMouseClicked
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del archivo");
            
            String extension = "";
            int ext = Integer.parseInt(JOptionPane.showInputDialog("1-> .mp3\n2-> .mp4\n3-> .pdf\n4-> docx\nIngrese número de extensión"));
            switch (ext) {
                case 1:
                    extension = ".mp3";
                    break;
                case 2:
                    extension = ".mp4";
                    break;
                case 3:
                    extension = ".pdf";
                    break;
                case 4:
                    extension = ".docx";
            }
            
            double tamaño = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del archivo"));
            
            String link = "";
            for (int i = 0; i < 10; i++) {
                int car = 48 + random.nextInt(74);
                while (car >= 58 && car <= 64 || car >= 91 && car <= 96) {
                    car = 48 + random.nextInt(74);
                }
                link += (char) car;
            }
            
            Archivo a = new Archivo(nombre, linkF + link, extension, tamaño);
            
            String resp = JOptionPane.showInputDialog("Desea agregar este archivo en una carpeta [n/s]");
            
            if ("s".equals(resp)) {
                if (ab.getCarpetas().isEmpty()) {
                    Carpeta c = CrearCarpeta();
                    ab.setCarpetas(c);
                    ab.escribirArchivo();
                    
                    ab.getCarpetas().add(c);
                    String linkC = linkCarpeta();
                    
                    a = new Archivo(nombre, linkF + "/" + linkC + link, extension, tamaño);
                    c.getArchivos().add(a);
                } else {
                    int p = Integer.parseInt(JOptionPane.showInputDialog(Imprimir(ab.getCarpetas()) + "Ingrese posición de la carpeta"));
                    for (int i = 0; i < ab.getCarpetas().size(); i++) {
                        if (i == p) {
                            ab.getCarpetas().get(p).getArchivos().add(a);
                            
                        }
                    }
                }
            }
            
            ab.setArchivos(a);
            ab.escribirArchivo();
            
            JOptionPane.showInputDialog("Archivo agregado exitosamente");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error y no se guardaron los datos");
        }
    }//GEN-LAST:event_bt_crearAMouseClicked

    private void bt_crearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_crearCMouseClicked
        try {
            ab.setCarpetas(CrearCarpeta());
            ab.escribirArchivo();
            JOptionPane.showInputDialog("Carpeta agregada exitosamente");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error y no se guardaron los datos");
        }
    }//GEN-LAST:event_bt_crearCMouseClicked

    private void jl__opcionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jl__opcionesValueChanged
        File fichero = null;
        FileInputStream entrada = null;
        ObjectInputStream objeto = null;
        
        DefaultTreeModel modelo = (DefaultTreeModel) Jt_listar.getModel();
        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) modelo.getRoot();
        DefaultMutableTreeNode nodoC, nodoA;
        
        if (jl__opciones.getSelectedIndex() == 0) {
            raiz.setUserObject("Mi Unidad");
            for (Carpeta c : ab.getCarpetas()) {
                nodoC = new DefaultMutableTreeNode(c.getNombre());
                
                //agregar archivos a las carpetas
                for (Archivo a : c.getArchivos()) {
                    for (Archivo ar : ab.getArchivos()) {
                        if (a.getNombre().equals(ar.getNombre())) {
                            nodoA = new DefaultMutableTreeNode(ar.getNombre());
                            nodoC.add(nodoA);
                        }else if (true) {
                            
                        }
                    }
                }
                
                raiz.add(nodoC);
            }
            
        }
    }//GEN-LAST:event_jl__opcionesValueChanged
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    
    public Carpeta CrearCarpeta() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carpeta");
        
        Carpeta c = new Carpeta(nombre);
        return c;
    }
    
    public String linkCarpeta() {
        String link = "";
        for (int i = 0; i < 5; i++) {
            int car = 48 + random.nextInt(74);
            while (car >= 58 && car <= 64 || car >= 91 && car <= 96) {
                car = 48 + random.nextInt(74);
            }
            link += (char) car;
        }
        return link;
    }
    
    public static String Imprimir(ArrayList<Carpeta> temp) {
        String cad = "";
        for (int i = 0; i < temp.size(); i++) {
            cad += "" + i + " - " + temp.get(i) + "\n";
        }
        
        return cad;
    }//Fin imprimir

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Jt_listar;
    private javax.swing.JButton bt_crearA;
    private javax.swing.JButton bt_crearC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jl__opciones;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;
    // End of variables declaration//GEN-END:variables
}
