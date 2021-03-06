/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import Admission.IMajor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INTELAMD
 */
public class Confirmation extends javax.swing.JFrame 
{
    private IMajor major;
    DefaultTableModel model;
    
    public Confirmation()
    {
        initComponents();
        
        dispose();
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            major = (IMajor) myRegistry.lookup("major");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Confirmation Form");
        displayData();
    }
    public Confirmation(String name)
    {
        initComponents();
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            major = (IMajor) myRegistry.lookup("major");
            major.setnoreg(name);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        displayData();
        setLocationRelativeTo(this);
    }
    
    private void displayData() 
    {
        try
        {
            ArrayList data = major.display();
            for(int i = 0; i < data.size()-1; i+=16)
            {
                String Idstudent = (String)data.get(i);
                String noreg = (String)data.get(i+1);
                String name = (String)data.get(i+2);
                String birth = (String)data.get(i+3);
                String gender = (String)data.get(i+4);
                String email = (String)data.get(i+5);
                String phone = (String)data.get(i+6);
                String address = (String)data.get(i+7);
                String school = (String)data.get(i+8);
                String idmajor = (String)data.get(i+9);
                Float indo = Float.parseFloat(data.get(i+10).toString());
                Float eng = Float.parseFloat(data.get(i+11).toString());
                Float math = Float.parseFloat(data.get(i+12).toString());
                Float theory = Float.parseFloat(data.get(i+13).toString());
                Float practice = Float.parseFloat(data.get(i+14).toString());
                Float averange = Float.parseFloat(data.get(i+15).toString());
                
                
                String[] data_field = {Idstudent.trim(),noreg.trim(),name.trim(),birth.trim(),gender.trim(),email.trim(),phone.trim(),address.trim(),school.trim(),idmajor.trim(),indo.toString().trim(),eng.toString().trim(),math.toString().trim(),theory.toString().trim(),practice.toString().trim().valueOf(practice), averange.toString().trim()};
                
                model = (DefaultTableModel)tablejoin.getModel();
                model.addRow(data_field);
            }
        }
        catch(Exception ex) 
        {
            JOptionPane.showMessageDialog(null,"");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablejoin = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();
        panelJudul = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("CONGRATULATION YOU HAS BEEN REGISTRY AS STUDENT IN STMIK RAHARJA");

        tablejoin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Student", "No Registration", "Full Name", "Birth Date", "Gender", "Email", "Phone No", "Address", "School's Name", "Major", "Indonesian", "English", "Mathematics", "Vocational Theory", "Vocational Practice", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablejoin);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelJudulLayout.createSequentialGroup()
                    .addGap(462, 462, 462)
                    .addComponent(jLabel6)
                    .addContainerGap(482, Short.MAX_VALUE)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(27, 27, 27))
            .addComponent(panelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try 
        {
            LoginForm hm = new LoginForm();
            hm.show();
            this.dispose();
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Confirmation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTable tablejoin;
    // End of variables declaration//GEN-END:variables
}
