/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import Admission.IMajor; 
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INTELAMD
 */
public class AdminMajor extends javax.swing.JFrame {
    IMajor major;
    DefaultTableModel model;
    /**
     * Creates new form AdminMajor
     */
    public AdminMajor() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Data Major Form");
        
//        autoidm();
        BindTable();
    }
    public AdminMajor(String name)
    {
        initComponents();
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            major = (IMajor) myRegistry.lookup("major");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        lblname.setText(name);
        setLocationRelativeTo(this);
        displayData();
        autoidm();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    private void cleartable()
    {
        model.setRowCount(0);
        displayData();
    }
    
    public void cleartext()
    {
        txtSearch.setText("");
        txtId.setText("");
        txtDepartment.setText("");
        txtProgram.setText("");
        txtDesc.setText("");
        txtQuota.setText("");
        txtCost.setText("");
        
        autoidm();
    }
    
    public void autoidm()
    {
        try
        {
            txtId.setText(major.autoId());
        }
        catch (Exception e)
        {
            System.out.println("Auto Generated Id Error : " + e);
        }
    }
    
    public void add()
    {
        try 
        {            
            String IdMajor = txtId.getText();
            String Department = txtDepartment.getText();
            String Program = txtProgram.getText();
            String Description = txtDesc.getText();
            String Quota = txtQuota.getText();
            String Cost = txtCost.getText();

            int i = major.doInsert(IdMajor,Department,Program,Description,Quota,Cost);
            if(i > 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "Success! Data Has Been Saved");
//                this.clear();
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Warning! Data Not Valid");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
    }
    
    private void Validation()
    {
        String IdMajor = txtId.getText();
        String Department = txtDepartment.getText();
        String Program = txtProgram.getText();
        String Description = txtDesc.getText();
        String Quota = txtQuota.getText();
        String Cost = txtCost.getText();
        
        if(IdMajor.equals("") || Department.equals("") || Program.equals("") || Description.equals("") || Quota.equals("") || Cost.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Data Field Can Not Be Empty");
            autoidm();
        }
    }
    
    public void inputNumber(JTextField txt, KeyEvent evt)
    {
        if(evt.getKeyChar()== 12)
        {
            if(txt.getText().indexOf(12)!= -1)
            {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        else if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!= 12)
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Enter Your Valid Number");
        }
    }
    
    private String getRecord() 
    {
        int baris = tableMajor.getSelectedRow();
        model = (DefaultTableModel) tableMajor.getModel();
        String id = model.getValueAt(baris,0).toString();
        return id;
    }
    
    private void displayData() 
    {
        try
        {
            ArrayList data = major.displayMajor();
            for(int i = 0;i < data.size()-1;i+=6)
            {
                String IdMajor = (String) data.get(i);
                String Department = (String) data.get(i+1);
                String Program = (String) data.get(i+2);
                String Description = (String) data.get(i+3);
                String Quota = (String) data.get(i+4);
                String Cost = (String) data.get(i+5);
                
                
                String[] dataField = {IdMajor.trim(),Department.trim(),Program.trim(),Description.trim(),Quota.trim(),Cost.trim()};
                
                model = (DefaultTableModel)tableMajor.getModel();
                model.addRow(dataField);
            }
        }
        
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "ERROR! \nData Gagal Ditampilkan. \n\nProblem Encounter : \n" + ex.getMessage());
        }
    }
               

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblname = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        lblMajor = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblProgram = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblQuota = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        txtSearch = new java.awt.TextField();
        txtId = new java.awt.TextField();
        txtDepartment = new java.awt.TextField();
        txtProgram = new java.awt.TextField();
        txtDesc = new java.awt.TextField();
        txtQuota = new java.awt.TextField();
        txtCost = new java.awt.TextField();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMajor = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelJudul2 = new javax.swing.JPanel();
        logo2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1800, 800));

        lblSearch.setText("Search ID/Department");

        lblMajor.setText("ID Major");

        lblDepartment.setText("Department");

        lblProgram.setText("Program");

        lblDesc.setText("Description");

        lblQuota.setText("Quota");

        lblCost.setText("Cost");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tableMajor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Major", "Department", "Program", "Description", "Quota", "Cost"
            }
        ));
        jScrollPane1.setViewportView(tableMajor);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Upate");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        panelJudul2.setBackground(new java.awt.Color(0, 153, 51));
        panelJudul2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.png"))); // NOI18N
        logo2.setPreferredSize(new java.awt.Dimension(160, 160));

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STMIK Raharja");

        javax.swing.GroupLayout panelJudul2Layout = new javax.swing.GroupLayout(panelJudul2);
        panelJudul2.setLayout(panelJudul2Layout);
        panelJudul2Layout.setHorizontalGroup(
            panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudul2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(logo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1225, Short.MAX_VALUE))
            .addGroup(panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelJudul2Layout.createSequentialGroup()
                    .addGap(462, 462, 462)
                    .addComponent(jLabel2)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );
        panelJudul2Layout.setVerticalGroup(
            panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelJudul2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelJudul2Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel2)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblname))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSearch)
                                    .addComponent(lblMajor)
                                    .addComponent(lblDepartment)
                                    .addComponent(lblProgram)
                                    .addComponent(lblQuota)
                                    .addComponent(lblCost)
                                    .addComponent(lblDesc))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtProgram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblname))
                    .addComponent(panelJudul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMajor)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDepartment)
                            .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProgram)
                            .addComponent(txtProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesc)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuota)
                            .addComponent(txtQuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCost)
                            .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void BindTable()
    {
        try
        {
            ArrayList data = major.displayMajor();
            for(int i = 0; i<data.size()-1; i+= 6)
            {
                String IdMajor = (String)data.get(i);
                String Department = (String)data.get(i+1);
                String Program = (String)data.get(i+2);
                String Description = (String)data.get(i+3);
                String Quota = (String)data.get(i+4);
                String Cost = (String)data.get(i+5);
                
                String[] dataField = {IdMajor.trim(), Department.trim(), Program.trim(),Description.trim(),Quota.trim(),Cost.trim()};
                model = (DefaultTableModel)tableMajor.getModel();
                model.addRow(dataField);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try 
        {
            major.setIdMajor(txtSearch.getText());
            major.setDepartment(txtSearch.getText());

            String[] data = major.searchDataMajor();
            txtId.setText(data[0]);
            txtDepartment.setText(data[1]);
            txtProgram.setText(data[2]);
            txtDesc.setText(data[3]);
            txtQuota.setText(data[4]);
            txtCost.setText(data[5]);
            
            btnAdd.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Sorry, Data Empty");
            txtSearch.setText("");
            autoidm();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try 
        {
                
                if(major.getIdMajor().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "Data Cannot Be Null");
                }
                else
                {
                   add();
                   cleartable();
                   displayData();
                   cleartext();
                   autoidm();
                }
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try 
        {
            String IdMajor = txtId.getText();
            String Department = txtDepartment.getText();
            String Program = txtProgram.getText();
            String Description = txtDesc.getText();
            String Quota = txtQuota.getText();
            String Cost = txtCost.getText();

            int hasil = major.doUpdate(IdMajor,Department,Program,Description,Quota,Cost);
            if (hasil > 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUCCESS! Data Has Been Updated");
                cleartable();
                cleartext();
                autoidm();
                displayData();

                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
            } 
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "PERINGATAN! Harap Memasukkan Data Yang Sesuai");
            }
        } 
        catch (RemoteException e)
        {
            System.out.println("RemoteError : " + e);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try 
        {
            major.setIdMajor(txtId.getText());
            major.setDepartment(txtDepartment.getText());

            int hasil = major.doDelete();

            if (hasil > 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUKSES! Data Berhasil Dihapus");
                cleartable();
                displayData();
                cleartext();
                autoidm();
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
            } 
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Data Cannot Deleted");
            }
        } 
        catch (RemoteException e) 
        {
            System.out.println("RemoteException Error : " + e);
        }
        catch (Exception ex) 
        {
            System.out.println("Error : " + ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtSearch.setText("");
        cleartext();
        autoidm();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try
        {
            String[] data = major.caridataAdmin();
            Admin adm = new Admin(data[0]);
            adm.show();
            this.dispose();
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMajor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMajor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblProgram;
    private javax.swing.JLabel lblQuota;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel logo2;
    private javax.swing.JPanel panelJudul2;
    private javax.swing.JTable tableMajor;
    private java.awt.TextField txtCost;
    private java.awt.TextField txtDepartment;
    private java.awt.TextField txtDesc;
    private java.awt.TextField txtId;
    private java.awt.TextField txtProgram;
    private java.awt.TextField txtQuota;
    private java.awt.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
