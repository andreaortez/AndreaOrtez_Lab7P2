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
    AdminCarpetas ac = new AdminCarpetas("./carpetas");
    AdminArchivos aa = new AdminArchivos("./archivos");
    String linkF = "dive.google.com/";

    public Frame() {
        initComponents();
        this.setLocationRelativeTo(null);
        aa.cargarArchivo();
        ac.cargarArchivo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pm_unidad = new javax.swing.JPopupMenu();
        destacar = new javax.swing.JMenuItem();
        eliminar = new javax.swing.JMenuItem();
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

        destacar.setText("Destacar");
        destacar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                destacarMouseClicked(evt);
            }
        });
        destacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destacarActionPerformed(evt);
            }
        });
        pm_unidad.add(destacar);

        eliminar.setText("Papelera");
        pm_unidad.add(eliminar);

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
        Jt_listar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jt_listarMouseClicked(evt);
            }
        });
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
                if (ac.getCarpetas().isEmpty()) {
                    Carpeta c = CrearCarpeta();
                    ac.setCarpetas(c);
                    ac.escribirArchivo();

                    ac.getCarpetas().add(c);
                    String linkC = linkCarpeta();

                    a = new Archivo(nombre, linkF + "/" + linkC + link, extension, tamaño);
                    c.getArchivos().add(a);
                } else {
                    int p = Integer.parseInt(JOptionPane.showInputDialog(Imprimir(ac.getCarpetas()) + "Ingrese posición de la carpeta"));
                    for (int i = 0; i < ac.getCarpetas().size(); i++) {
                        if (i == p) {
                            ac.getCarpetas().get(p).getArchivos().add(a);

                        }
                    }
                }
            }

            aa.setArchivos(a);
            aa.escribirArchivo();

            JOptionPane.showMessageDialog(this,"Archivo agregado exitosamente");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error y no se guardaron los datos");
        }
    }//GEN-LAST:event_bt_crearAMouseClicked

    private void bt_crearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_crearCMouseClicked
        try {
            ac.setCarpetas(CrearCarpeta());
            ac.escribirArchivo();
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
        Archivo[] archivos = new Archivo[aa.getArchivos().size()];
        int cont = 0;

        if (jl__opciones.getSelectedIndex() == 0) {
            raiz.setUserObject("Mi Unidad");
            for (Carpeta c : ac.getCarpetas()) {
                nodoC = new DefaultMutableTreeNode(c.getNombre());

                //agregar archivos a las carpetas
                for (Archivo a : c.getArchivos()) {
                    for (Archivo ar : aa.getArchivos()) {
                        if (a.getNombre().equals(ar.getNombre())) {
                            nodoA = new DefaultMutableTreeNode(ar.getNombre());
                            nodoC.add(nodoA);
                        } else {
                            archivos[cont] = ar;
                            cont++;
                        }
                    }
                }
                raiz.add(nodoC);

//                for (int i = 0; i < archivos.length; i++) {
//                    for (Archivo a : ab.getArchivos()) {
//                        if (a.getNombre().equals(archivos[i].getNombre())) {
//                            nodoA = new DefaultMutableTreeNode(a.getNombre());
//                            raiz.add(nodoA);
//                        }
//                    }
//                }      
            }

        }
    }//GEN-LAST:event_jl__opcionesValueChanged

    private void Jt_listarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jt_listarMouseClicked
        if (evt.isMetaDown()) {
            int row = Jt_listar.getClosestRowForLocation(evt.getX(), evt.getY());
            Jt_listar.setSelectionRow(row);
            Object v = Jt_listar.getSelectionPath().getLastPathComponent();
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)v;
            
            
            if (jl__opciones.getSelectedIndex()==0) {
                pm_unidad.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_Jt_listarMouseClicked

    private void destacarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_destacarMouseClicked
        
    }//GEN-LAST:event_destacarMouseClicked

    private void destacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destacarActionPerformed
        if (Jt_listar.getSelectionCount()>0) {
            
        }
    }//GEN-LAST:event_destacarActionPerformed

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
            cad += "" + i + " - " + temp.get(i).getNombre() + "\n";
        }

        return cad;
    }//Fin imprimir

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Jt_listar;
    private javax.swing.JButton bt_crearA;
    private javax.swing.JButton bt_crearC;
    private javax.swing.JMenuItem destacar;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jl__opciones;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;
    private javax.swing.JPopupMenu pm_unidad;
    // End of variables declaration//GEN-END:variables
}
