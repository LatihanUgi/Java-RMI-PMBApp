/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import Admission.IAdmin;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INTELAMD
 */
public class AdminStudent extends javax.swing.JFrame {
    DefaultTableModel model;
    IAdmin student; 
    /**
     * Creates new form AdminStudent
     */
    public AdminStudent() 
    {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Data Student Form");
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            student = (IAdmin) myRegistry.lookup("stu");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        setLocationRelativeTo(this);
        displayData();
        autoidm();
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    public AdminStudent(String name) 
    {
        initComponents();
        
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            student = (IAdmin) myRegistry.lookup("stu");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        lblname.setText(name);
        displayData();
        autoidm();
        setLocationRelativeTo(this);
    }

    private String getRecord() 
    {
        int baris = tableStudent.getSelectedRow();
        model = (DefaultTableModel) tableStudent.getModel();
        String id = model.getValueAt(baris,0).toString();
        return id;
    }
    
    private void cleartable()
    {
        model.setRowCount(0);
        displaySelectedData();
    }
    
    public void cleartext()
    {
        txtNoReg.setText("");
        txtName.setText("");
        cbGender.setSelectedIndex(0);
        Calendar.setDate(null);
        txtEmail.setText("");
        txtPhone.setText("");
        taAddress.setText("");
        txtSchool.setText("");
        txtSains.setText("");
        txtSocial.setText("");
        txtVocational.setText("");
        txtMajor.setText("");
        cbGender.requestFocus();
        
        autoidm();
    }
    
    public void autoidm()
    {
        try
        {
            txtIdStudent.setText(student.autoIdStudent());
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
            student.setIdStudent(txtIdStudent.getText());
            student.setNoReg(txtNoReg.getText());
            student.setName(txtName.getText());
            student.setBirth(((JTextField)Calendar.getDateEditor().getUiComponent()).getText());
            student.setGender(cbGender.getSelectedItem().toString());
            student.setEmail(txtEmail.getText());
            student.setPhone(txtPhone.getText());
            student.setAddress(taAddress.getText());
            student.setSchool(txtSchool.getText());
            student.setSains(txtSains.getText());
            student.setSocial(txtSocial.getText());
            student.setVocational(txtVocational.getText());
            student.setMajor(txtMajor.getText());

            int i = student.doInsert();
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
        String IdStudent = txtIdStudent.getText();
        String NoReg = txtNoReg.getText();
        String Name = txtName.getText();
        String Gender = cbGender.getSelectedItem().toString();
        String Email = txtEmail.getText();
        String Phone = txtPhone.getText();
        String Address = taAddress.getText();
        String School = txtSchool.getText();
        String Sains = txtSains.getText();
        String Social = txtSocial.getText();
        String Vocational = txtVocational.getText();
        String Major = txtMajor.getText();
        
        if(IdStudent.equals("") || NoReg.equals("") || Name.equals("") || Gender.equals("- None -") || Gender.equals("- None -") || Email.equals("") || Phone.equals("") || Address.equals("") || School.equals("") || Sains.equals("") || Social.equals("") || Vocational.equals("") || Major.equals(""))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Data Field Can Not Be Empty");
            autoidm();
        }
        
//        //else 
//       // {
//         //   if (Email.equals("Email Benar")) 
//         //   {
//           //     JOptionPane.showMessageDialog(null, "Sukssssssssseeeeeeeeeeeeeeeesssssssss");
//          //      Confirmation cf = new Confirmation();
//           //     cf.setVisible(true);
//          //      this.dispose();
//          //  } 
//          //  else 
//          //  {
//          //      Toolkit.getDefaultToolkit().beep();
//           //     JOptionPane.showMessageDialog(rootPane, "Enter Your Valid Email");
//          //  }
//       // }
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
            ArrayList data = student.display();
            for(int i = 0;i < data.size()-1;i+=13)
            {
                String ID_NewStudent = (String)data.get(i);
                String NoReg = (String)data.get(i+1);
                String FullName = (String)data.get(i+2);
                String BirthDate = (String)data.get(i+3);
                String Gender = (String)data.get(i+4);
                String Email = (String)data.get(i+5);
                String PhoneNo = (String)data.get(i+6);
                String Address = (String)data.get(i+7);
                String School = (String)data.get(i+8);
                String ID_Sains = (String)data.get(i+9);
                String ID_Social = (String)data.get(i+10);
                String ID_Vocational = (String)data.get(i+11);
                String ID_Major = (String)data.get(i+12);
                
                
                String[] data_field = {ID_NewStudent.trim(),NoReg.trim(),FullName.trim(),
                    BirthDate.trim(),Gender.trim(),Email.trim(),
                    PhoneNo.trim(),Address.trim(),School.trim(),
                    ID_Sains.trim(),ID_Social.trim(),ID_Vocational.trim(),ID_Major.trim()};
                
                model = (DefaultTableModel)tableStudent.getModel();
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
            student.setIdStudent(txtSearch.getText());
            student.setName(txtSearch.getText());
            
            ArrayList data = student.selecteddisplay();
            for(int i = 0;i < data.size()-1;i+=13)
            {
                String ID_NewStudent = (String)data.get(i);
                String NoReg = (String)data.get(i+1);
                String FullName = (String)data.get(i+2);
                String BirthDate = (String)data.get(i+3);
                String Gender = (String)data.get(i+4);
                String Email = (String)data.get(i+5);
                String PhoneNo = (String)data.get(i+6);
                String Address = (String)data.get(i+7);
                String School = (String)data.get(i+8);
                String ID_Sains = (String)data.get(i+9);
                String ID_Social = (String)data.get(i+10);
                String ID_Vocational = (String)data.get(i+11);
                String ID_Major = (String)data.get(i+12);
                
                
                String[] data_field =   {ID_NewStudent.trim(),NoReg.trim(),FullName.trim(),
                    BirthDate.trim(),Gender.trim(),Email.trim(),
                    PhoneNo.trim(),Address.trim(),School.trim(),
                    ID_Sains.trim(),ID_Social.trim(),ID_Vocational.trim(),ID_Major.trim()};
                
                model = (DefaultTableModel)tableStudent.getModel();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudent = new javax.swing.JTable();
        lblNoReg = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblBirth = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblSchool = new javax.swing.JLabel();
        lblSains = new javax.swing.JLabel();
        lblSocial = new javax.swing.JLabel();
        lblVocational = new javax.swing.JLabel();
        lblMajor = new javax.swing.JLabel();
        txtNoReg = new java.awt.TextField();
        txtName = new java.awt.TextField();
        txtEmail = new java.awt.TextField();
        txtSchool = new java.awt.TextField();
        txtSains = new java.awt.TextField();
        txtSocial = new java.awt.TextField();
        txtVocational = new java.awt.TextField();
        txtMajor = new java.awt.TextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAddress = new javax.swing.JTextArea();
        lblIdStudent = new javax.swing.JLabel();
        txtIdStudent = new java.awt.TextField();
        lblSeacrh = new javax.swing.JLabel();
        txtSearch = new java.awt.TextField();
        cbGender = new javax.swing.JComboBox<>();
        txtPhone = new javax.swing.JFormattedTextField();
        Calendar = new com.toedter.calendar.JDateChooser();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblname = new javax.swing.JLabel();
        panelJudul = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1800, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Student", "No Reg", "Full Name", "Birth Date", "Gender", "Email", "Phone No", "Address", "School", "Id Sains", "Id Social", "Id Vocational", "Id Major"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableStudent);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 1100, 230));

        lblNoReg.setText("No Reg");
        getContentPane().add(lblNoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        lblName.setText("Full Name");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        lblBirth.setText("Birth Date");
        getContentPane().add(lblBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        lblGender.setText("Gender");
        getContentPane().add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        lblEmail.setText("Email");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        lblPhone.setText("Phone No");
        getContentPane().add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        lblAddress.setText("Address");
        getContentPane().add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, -1, -1));

        lblSchool.setText("School");
        getContentPane().add(lblSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

        lblSains.setText("ID Sains");
        getContentPane().add(lblSains, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, -1, -1));

        lblSocial.setText("ID Social");
        getContentPane().add(lblSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 270, -1, -1));

        lblVocational.setText("ID Vocational");
        getContentPane().add(lblVocational, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, -1, -1));

        lblMajor.setText("ID Major");
        getContentPane().add(lblMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, -1, -1));

        txtNoReg.setEditable(false);
        getContentPane().add(txtNoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 173, -1));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 173, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 170, -1));
        getContentPane().add(txtSchool, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 170, -1));

        txtSains.setEditable(false);
        getContentPane().add(txtSains, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 230, 103, -1));

        txtSocial.setEditable(false);
        getContentPane().add(txtSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 270, 103, -1));

        txtVocational.setEditable(false);
        getContentPane().add(txtVocational, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 103, -1));

        txtMajor.setEditable(false);
        getContentPane().add(txtMajor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 350, 103, -1));

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 230, 80, 40));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 280, 80, 40));

        taAddress.setColumns(20);
        taAddress.setRows(5);
        jScrollPane2.setViewportView(taAddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 170, -1));

        lblIdStudent.setText("ID Student");
        getContentPane().add(lblIdStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        txtIdStudent.setEditable(false);
        getContentPane().add(txtIdStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 173, -1));

        lblSeacrh.setText("ID / Name Student");
        getContentPane().add(lblSeacrh, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 174, -1));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- None - ", "Male", "Female" }));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });
        getContentPane().add(cbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 170, -1));

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 170, -1));

        Calendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalendarMouseClicked(evt);
            }
        });
        getContentPane().add(Calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 170, -1));

        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 40, 20));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 330, 80, 40));
        getContentPane().add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

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
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        getContentPane().add(panelJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try 
        {
            student.setIdStudent(txtSearch.getText());
            student.setName(txtSearch.getText());

            String[] data = student.searchDataStudent();
            txtIdStudent.setText(data[0]);
            txtNoReg.setText(data[1]);
            txtName.setText(data[2]);
            Calendar.setDateFormatString(data[3]);
            cbGender.setSelectedItem(data[4]);
            txtEmail.setText(data[5]);
            txtPhone.setText(data[6]);
            taAddress.setText(data[7]);
            txtSchool.setText(data[8]);
            txtSains.setText(data[9]);
            txtSocial.setText(data[10]);
            txtVocational.setText(data[11]);
            txtMajor.setText(data[12]);
            
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

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:STU
    }//GEN-LAST:event_btnSearchMouseClicked

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        
    }//GEN-LAST:event_cbGenderActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try 
        {
            student.setIdStudent(txtIdStudent.getText());
            student.setName(txtName.getText());

            int hasil = student.doDelete();

            if (hasil > 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUKSES! Data Berhasil Dihapus");
                cleartable();
                displayData();
                cleartext();
                autoidm();
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
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

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        inputNumber (txtPhone, evt);
        //txtPhone.setText("");
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try 
        {
            student.setIdStudent(txtIdStudent.getText());
            student.setNoReg(txtNoReg.getText());
            student.setName(txtName.getText());
            student.setBirth(((JTextField)Calendar.getDateEditor().getUiComponent()).getText());
            student.setGender(cbGender.getSelectedItem().toString());
            student.setEmail(txtEmail.getText());
            student.setPhone(txtPhone.getText());
            student.setAddress(taAddress.getText());
            student.setSchool(txtSchool.getText());
            student.setSains(txtSains.getText());
            student.setSocial(txtSocial.getText());
            student.setVocational(txtVocational.getText());
            student.setMajor(txtMajor.getText());

            int hasil = student.doUpdate();
            if (hasil > 0 && !student.getGender().equals("- None -")) 
            {
                JOptionPane.showMessageDialog(rootPane, "SUCCESS! Data Has Been Updated");
                cleartable();
                cleartext();
                autoidm();
                displayData();
                txtSearch.setText("");
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
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

    private void CalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalendarMouseClicked
        
    }//GEN-LAST:event_CalendarMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        cleartext();
        autoidm();
        txtSearch.setText("");
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try 
        {
            String[] data = student.caridataAdmin();
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
            java.util.logging.Logger.getLogger(AdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIdStudent;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoReg;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSains;
    private javax.swing.JLabel lblSchool;
    private javax.swing.JLabel lblSeacrh;
    private javax.swing.JLabel lblSocial;
    private javax.swing.JLabel lblVocational;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JTextArea taAddress;
    private javax.swing.JTable tableStudent;
    private java.awt.TextField txtEmail;
    private java.awt.TextField txtIdStudent;
    private java.awt.TextField txtMajor;
    private java.awt.TextField txtName;
    private java.awt.TextField txtNoReg;
    private javax.swing.JFormattedTextField txtPhone;
    private java.awt.TextField txtSains;
    private java.awt.TextField txtSchool;
    private java.awt.TextField txtSearch;
    private java.awt.TextField txtSocial;
    private java.awt.TextField txtVocational;
    // End of variables declaration//GEN-END:variables
}
