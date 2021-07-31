/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.nodepath;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.mIndex;
import model.path;
import model.src;

/**
 *
 * @author asus
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    
    ArrayList<Integer> pathList = new ArrayList<>();
    ArrayList<Integer>[] adjList;
    private nodepath node = new nodepath();
    private DefaultTableModel table_model;
    private DefaultTableModel table_model2;
    private DefaultTableModel table_model3;
    private int v;
    
    public main() {
        initComponents();
    }

    public main(int v) {
        this.v = v;
    }
    
    private void initAdjList() {
       adjList = new ArrayList[v]; 
  
        for (int i = 0; i < v; i++) { 
            adjList[i] = new ArrayList<>(); 
        }
    }
    public void addEdge(int u, int v) 
    { 
        // Add v to u's list. 
        adjList[u].add(v); 
        
    }
    public void printAllPaths(int s, int d) { 
        boolean[] isVisited = new boolean[v+1];
        pathList.add(s); 
        printAllPathsUtil(s, d, isVisited, pathList); 
    }
    
    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList){
        isVisited[u] = true;
        try {
            if (u.equals(d)) {
                //System.out.println(localPathList);
                node.addSearch((src) localPathList);
                //for (int x = 0; x < node.getIndexSize();x++) {
                //    for(int y = 0; y <localPathList.size();y++){
                //        if(x == node.getIndexList().get(y).getIndex()){
                //            //System.out.print(node.getIndexList().get(x).getNode());
                //            if(x < localPathList.size()){
                                //System.out.print(" -> ");
                //            }
                //        }
                //    }
                //}
                isVisited[u] = false; 
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Util atas Error");
        }
        try {
            for (Integer i : adjList[u]) { 
                if (!isVisited[i]) {
                    localPathList.add(i);
                    printAllPathsUtil(i, d, isVisited, localPathList); 

                    localPathList.remove(i); 
                } 
            }
            isVisited[u] = false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Util Bawah Error");
        }     
    }
    void tampilDataIndex(){
        String[] column = {
            "Index","Simpul"
        };
        Object[][] datai = new Object[node.getIndexSize()][column.length];
        for (int i = 0; i < node.getIndexSize(); i++) {
            String[] rowData = {
                Integer.toString(node.getIndexList().get(i).getIndex()),
                node.getIndexList().get(i).getNode()
            };
            datai[i] = rowData;
        }
        table_model = new DefaultTableModel(datai, column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tIndex.setModel(table_model);
    }
    void tampilDataPath(){
        String[] column = {
            "Index Awal","Index Tujuan","Arah"
        };
        Object[][] datap = new Object[node.getPathSize()][column.length];
        for (int i = 0; i < node.getPathSize(); i++) {
            String[] rowData = {
                node.getPathList().get(i).getStart(),
                node.getPathList().get(i).getDesti(),
                node.getPathList().get(i).getnPath()
            };
            datap[i] = rowData;
        }
        table_model2 = new DefaultTableModel(datap, column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tPath.setModel(table_model2);
    }
    void tampilDataCari(){
        String[] column = {
            "Kesimpulan"
        };
        Object[][] datac = new Object[node.getSearchSize()][column.length];
        for (int i = 0; i < node.getSearchSize(); i++) {
            String[] rowData = {
              node.getSearchList().get(i).getKesimpulan()
            };
            datac[i] = rowData;
        }
        table_model3 = new DefaultTableModel(datac, column){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tDesti.setModel(table_model3);
    }
    void clearIndex(){
        tfIndex.setText(null);
    }
    void clearPath(){
        tfPathAwal.setText(null);
        tfPathAkhir.setText(null);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfIndex = new javax.swing.JTextField();
        bIndex = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tIndex = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfPathAwal = new javax.swing.JTextField();
        tfPathAkhir = new javax.swing.JTextField();
        bPath = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tPath = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfDesti = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tDesti = new javax.swing.JTable();
        LKes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nama Sampul");

        tfIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIndexActionPerformed(evt);
            }
        });

        bIndex.setText("Simpan Tujuan");
        bIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIndexActionPerformed(evt);
            }
        });

        tIndex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tIndex);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bIndex)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(548, 330));

        jLabel2.setText("Index Awal");

        jLabel3.setText("Index Tujuan");

        bPath.setText("Simpan Tujuan");
        bPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPathActionPerformed(evt);
            }
        });

        tPath.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tPath);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfPathAkhir))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(tfPathAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bPath, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfPathAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPathAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bPath)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel4.setText("Tujuan yang dicari");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pencarian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tDesti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tDesti);

        LKes.setText("KESIMPULAN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfDesti, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(LKes)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDesti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(LKes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIndexActionPerformed

    private void bIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIndexActionPerformed
        int a;
        a = node.getIndexSize();
        
        mIndex Index = new mIndex(
        a,
        tfIndex.getText().toUpperCase()
        );
        node.addIndex(Index);
        tampilDataIndex();
        clearIndex();
    }//GEN-LAST:event_bIndexActionPerformed

    private void bPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPathActionPerformed
        int s = Integer.parseInt(tfPathAwal.getText());
        int d = Integer.parseInt(tfPathAkhir.getText());
        String a = null;
        for(int m = 0; m < node.getIndexSize(); m++){
            if(m == s){
                for(int n = 0; n < node.getIndexSize(); n++){
                    if(n == d){
                        a = node.getIndexList().get(m).getNode()+" -> "+node.getIndexList().get(n).getNode();
                    }
                }
            }
        }
        
        path Path = new path(
            tfPathAwal.getText(),
            tfPathAkhir.getText(),
            a
        );
        node.addPath(Path);
        tampilDataPath();
        
        clearPath();
    }//GEN-LAST:event_bPathActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int s =0;
        String d0 = tfDesti.getText().toUpperCase();
        int d = 0;
        for(int p = 0; p<node.getIndexSize();p++){
            if(node.getIndexList().equals(d0)){
               d = node.getIndexList().get(p).getIndex();
            }
        }
        ArrayList<String> local = new ArrayList<>();
        String dump = "A -->";
        int e = 0;
        String e0 ="";
        
        
        for(int x= 0; x < node.getIndexSize();x++){
            for(int y = 0; y < node.getPathSize();y++){
                if(x == Integer.parseInt(node.getPathList().get(y).getStart())){
                    for(int z = 0; z < 1; z++){
                        if(z == Integer.parseInt(node.getPathList().get(z).getStart())){
                            e = Integer.parseInt(node.getPathList().get(y).getDesti());
                            e0 = node.getIndexList().get(e).getNode();
                            dump = dump+""+e0+" ->";
                            //if(y==d){
                            //   dump = dump+""+tfDesti.getText();  
                            //}
                            local.add(dump);
                            src Search = new src(
                                local.get(y)
                            );
                            node.addSearch(Search);
                        }
                    }
                }
            }
        }
        
        tampilDataCari();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LKes;
    private javax.swing.JButton bIndex;
    private javax.swing.JButton bPath;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tDesti;
    private javax.swing.JTable tIndex;
    private javax.swing.JTable tPath;
    private javax.swing.JTextField tfDesti;
    private javax.swing.JTextField tfIndex;
    private javax.swing.JTextField tfPathAkhir;
    private javax.swing.JTextField tfPathAwal;
    // End of variables declaration//GEN-END:variables
}
