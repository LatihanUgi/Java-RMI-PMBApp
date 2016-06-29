/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import Admission.IAccount;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminAccount extends javax.swing.JFrame {

    private PreparedStatement stat;
    private ResultSet rs;
    private IAccount account;
    private Vector<Vector<String>> Account;
    private Vector<String> header;
    DefaultTableModel model;
    
    public AdminAccount() 
    {
        initComponents();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Data Account Form");
        BindCombo();
        BindTable();
    }
    public AdminAccount(String name)
    {
        initComponents();
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            account = (IAccount) myRegistry.lookup("account");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        lblname.setText(name);
        displayData();
        autoida();
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        setLocationRelativeTo(this);
    }
    private void cleartable()
    {
        model.setRowCount(0);
        displaySelectedData();
    }
    
    public void cleartext()
    {
        txtnoreg.setText("");
        txtuname.setText("");
        cbpos.setSelectedItem("- None -");
        txtpwd.setText("");
        
        autoida();
    }
    
    public void autoida()
    {
        try
        {
            txtnoreg.setText(account.autoNoReg());
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
            account.setNoReg(txtnoreg.getText());
            account.setUserName(txtuname.getText());
            account.setPassword(txtpwd.getText());
            account.setPosition(cbpos.getSelectedItem().toString());

            int i = account.doInsert();
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
        String NoReg = txtnoreg.getText();
        String UserName = txtuname.getText();
        String Password = txtpwd.getText();
        String Position = cbpos.getSelectedItem().toString();
        
        if(NoReg.equals("") || UserName.equals("") || Password.equals("") || Position.equals("- None -"))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Data Field Can Not Be Empty");
            autoida();
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
    
    private void displayData() 
    {
        try
        {
            ArrayList data = account.display();
            for(int i = 0;i < data.size()-1;i+=4)
            {
                String NoReg = (String)data.get(i);
                String UserName = (String)data.get(i+1);
                String Password = (String)data.get(i+2);
                String Position = (String)data.get(i+3);
                
                
                String[] data_field = {NoReg.trim(),UserName.trim(),Password.trim(),Position.trim()};
                
                model = (DefaultTableModel)tableAccount.getModel();
                model.addRow(data_field);
            }
        }
        
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "ERROR! \nData Gagal Ditampilkan. \n\nProblem Encounter : \n" + ex.getMessage());
        }
    }
    
    private void displaySelectedData() 
    {
        try
        {
            account.setNoReg(txtSearch.getText());
            account.setUserName(txtSearch.getText());
            
            ArrayList data = account.selecteddisplay();
            for(int i = 0;i < data.size()-1;i+=13)
            {
                String NoReg = (String)data.get(i);
                String UserName = (String)data.get(i+1);
                String Password = (String)data.get(i+2);
                String Position = (String)data.get(i+3);
                
                
                String[] data_field = {NoReg.trim(),UserName.trim(),Password.trim(),Position.trim()};
                
                model = (DefaultTableModel)tableAccount.getModel();
                model.addRow(data_field);
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

        lblnoreg = new javax.swing.JLabel();
        lbluname = new javax.swing.JLabel();
        lblpwd = new javax.swing.JLabel();
        lblpos = new javax.swing.JLabel();
        txtnoreg = new java.awt.TextField();
        txtuname = new java.awt.TextField();
        txtpwd = new java.awt.TextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbpos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAccount = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new java.awt.TextField();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        panelJudul = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblnoreg.setText("No Registration");

        lbluname.setText("User Name");

        lblpwd.setText("Password");

        lblpos.setText("Position");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
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

        cbpos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- None -", "Admin", "Student" }));
        cbpos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbposActionPerformed(evt);
            }
        });

        tableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Registration", "Username", "Password", "Position"
            }
        ));
        jScrollPane1.setViewportView(tableAccount);

        jLabel1.setText("Login as : ");

        jLabel2.setText("Search No Reg / Username");

        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        panelJudul.setBackground(new java.awt.Color(0, 153, 51));
        panelJudul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(160, 160));

        jLabel6.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("STMIK Raharja");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1636, Short.MAX_VALUE))
            .addGroup(panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelJudulLayout.createSequentialGroup()
                    .addGap(462, 462, 462)
                    .addComponent(jLabel6)
                    .addContainerGap(869, Short.MAX_VALUE)))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
            .addGroup(panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelJudulLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel6)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbluname)
                                    .addComponent(lblpwd)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblnoreg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbpos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtnoreg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtuname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtpwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSearch)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(lblpos))
                        .addGap(111, 111, 111)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblname))
                    .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblname))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnoreg, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(lblnoreg)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbluname)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpwd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbpos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpos))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void BindTable()
    {
        try
        {
            ArrayList data = account.display();
            for(int i = 0; i<data.size()-1; i+= 4)
            {
                String NoReg = (String) data.get(i);
                String Username = (String) data.get(i+1);
                String Password = (String) data.get(i+2);
                String Position = (String) data.get(i+3);
                
                String[] dataField = {NoReg.trim(), Username.trim(), Password.trim(),Position.trim()};
                model = (DefaultTableModel)tableAccount.getModel();
                model.addRow(dataField);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error : " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }
    void BindCombo() 
    {
        try 
        {
            ArrayList<String> data = account.display();
            int j = 0;
            while(data.size()>j)
            {
                cbpos.addItem(data.get(j));
                j++;
            }
        } 
        catch (RemoteException re) 
        {
            System.out.println("RemoteError : " + re);
        }
        catch (Exception e)
        {
            System.out.println("Error : " + e);
            e.printStackTrace();
            System.exit(1);
        }
    }
    private void cbposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbposActionPerformed
        
    }//GEN-LAST:event_cbposActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try 
        {
            account.setNoReg(txtSearch.getText());
            account.setUserName(txtSearch.getText());

            String[] data = account.searchDataAccount();
            txtnoreg.setText(data[0]);
            txtuname.setText(data[1]);
            txtpwd.setText(data[2]);
            cbpos.setSelectedItem(data[3]);
            
            txtSearch.setText("");
            btnAdd.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Sorry, Data Empty");
            txtSearch.setText("");
            autoida();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try 
        {
                account.setNoReg(txtnoreg.getText());
                account.setUserName(txtuname.getText());
                account.setPassword(txtpwd.getText());
                if(account.getNoReg().equals("") && account.getPosition().equals("- None -"))
                {
                    JOptionPane.showMessageDialog(rootPane, "Data Cannot Be Null");
                }
                else
                {
                   add();
                   cleartable();
                   displayData();
                   cleartext();
                   autoida();
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
            account.setNoReg(txtnoreg.getText());
            account.setUserName(txtuname.getText());
            account.setPassword(txtpwd.getText());
            account.setPosition(cbpos.getSelectedItem().toString());

            int hasil = account.doUpdate();
            if (hasil > 0 && !account.getPosition().equals("- None -")) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUCCESS! Data Has Been Updated");
                cleartable();
                cleartext();
                autoida();
                displayData();

                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
            } 
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Warning! Please Enter Your Valid Data");
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
            account.setNoReg(txtnoreg.getText());
            account.setUserName(txtuname.getText());

            int hasil = account.doDelete();

            if (hasil > 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUKSES! Data Berhasil Dihapus");
                cleartable();
                displayData();
                cleartext();
                autoida();
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
        cleartext();
        autoida();
        txtSearch.setText("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try 
        {
            String[] data = account.caridataAdmin();
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
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAccount().setVisible(true);
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
    private javax.swing.JComboBox<String> cbpos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnoreg;
    private javax.swing.JLabel lblpos;
    private javax.swing.JLabel lblpwd;
    private javax.swing.JLabel lbluname;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tableAccount;
    private java.awt.TextField txtSearch;
    private java.awt.TextField txtnoreg;
    private java.awt.TextField txtpwd;
    private java.awt.TextField txtuname;
    // End of variables declaration//GEN-END:variables
}
