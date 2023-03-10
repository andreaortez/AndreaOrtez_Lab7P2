package andreaortez_lab7p2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Frame extends javax.swing.JFrame {

    Random random = new Random();
    AdminBinario ab = new AdminBinario("./files");

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
        jl1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jl2 = new javax.swing.JTree();
        pb1 = new javax.swing.JProgressBar();
        pb2 = new javax.swing.JProgressBar();
        bt_crearA = new javax.swing.JButton();
        bt_crearC = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl1.setFont(new java.awt.Font("Dubai", 0, 36)); // NOI18N
        jl1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mi Unidad", "Destacados", "Papelera" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jl1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 240, 210));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jl2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jl2);

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
            String extension = JOptionPane.showInputDialog("Ingrese la extensión del archivo");
            double tamaño = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del archivo"));

            String link = "";
            for (int i = 0; i < 10; i++) {
                int car = 48 + random.nextInt(122);
                while (car >= 58 && car <= 64) {
                    car = 48 + random.nextInt(122);
                }
                link += car;
            }

            String linkF = "dive.google.com/" + link;
            ab.setArchivos(new Archivo(nombre, linkF, extension, tamaño));
            ab.escribirArchivo();

            JOptionPane.showInputDialog("Archivo agregado exitosamente");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error y no se guardaron los datos");
        }
    }//GEN-LAST:event_bt_crearAMouseClicked

    private void bt_crearCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_crearCMouseClicked
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carpeta");

            String link = "";
            for (int i = 0; i < 10; i++) {
                int car = 48 + random.nextInt(122);
                while (car >= 58 && car <= 64) {
                    car = 48 + random.nextInt(122);
                }
                link += car;
            }

            String linkF = "dive.google.com/" + link;
            ab.setCarpetas(new Carpeta(nombre));
            ab.escribirArchivo();

            JOptionPane.showInputDialog("Archivo agregado exitosamente");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error y no se guardaron los datos");
        }
    }//GEN-LAST:event_bt_crearCMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_crearA;
    private javax.swing.JButton bt_crearC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jl1;
    private javax.swing.JTree jl2;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;
    // End of variables declaration//GEN-END:variables
}
