/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionclient;

import Admission.AdmissionInterface;
import Admission.IAdmin;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author INTELAMD
 */
public class RegistrationITIPA extends javax.swing.JFrame {
AdmissionInterface ai; 
IAdmin student;
    /**
     * Creates new form RegistrationITIPA
     */
    public RegistrationITIPA() {
        initComponents();
        
        try 
        {
            Registry myRegistry = LocateRegistry.getRegistry("localhost", 1099);
            ai = (AdmissionInterface) myRegistry.lookup("Admission");
            student = (IAdmin) myRegistry.lookup("stu");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane,"Error: " + e);
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Form for IT Major");
        autoidv();
        autoids();
    }
    public void autoidv()
    {
        try
        {
            txtVocational.setText(ai.autoIdVocational());
        }
        catch (Exception e)
        {
            System.out.println("Auto Generated Id Error : " + e);
        }
    }
    
    public void autoids()
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
    
    public void addStudent()
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
            student.setVocational(txtVocational.getText());
            student.setMajor(txtMajor.getText());

            int i = student.doInsert();
            if(i > 0) 
            {
                addVocational();
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
    
     public void addVocational()
    {
        try 
        {     
//            String IdSains = txtVocational.getText();
//            float indo = Float.parseFloat(txtIndonesian.getText());
//            float eng = Float.parseFloat(txtEnglish.getText());
//            float math = Float.parseFloat(txtMathematics.getText());
//            float physic = Float.parseFloat(txtPhisics.getText());
//            float chemistry = Float.parseFloat(txtChemistry.getText());
//            float bio = Float.parseFloat(txtBio.getText());
//            try 
//            {
//                int i = ai.doInsertStudent(IdSains,indo,eng,math,physic,chemistry,bio);
//                if (i > 0) 
//                {
//                    JOptionPane.showMessageDialog(rootPane, "Success! Data Has Been Saved");
////                this.clear();
//                } 
//                else 
//                {
//                    JOptionPane.showMessageDialog(rootPane, "Warning! Data Not Valid");
//                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane,"Error: " + e);
            }
    }
     
    public void inputNumber(JTextField txt, KeyEvent evt)
    {
        if(evt.getKeyChar()== 12)
        {
            if(txt.getText().indexOf(12)!=-1)
            {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        else if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!=12)
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }
    
    public void cleartext()
    {
        txtName.setText("");
        cbGender.setSelectedIndex(0);
        Calendar.setDate(null);
        txtEmail.setText("");
        txtPhone.setText("");
        taAddress.setText("");
        txtSchool.setText("");
        txtIndonesian.setText("");
        txtEnglish.setText("");
        txtVocational.setText("");
        txtMathematics.setText("");
        txtPhisics.setText("");
        txtChemistry.setText("");
        txtBio.setText("");
        
        autoids();
        autoidv();
    }
    
    void inputValue (JTextField txt, KeyEvent evt)
    {
        if(evt.getKeyChar()== 3)
        {
            if(txt.getText().indexOf(3)!=-1)
            {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
        else if(!Character.isDigit(evt.getKeyChar())&&evt.getKeyChar()!= 3)
        {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
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

        lblTitle = new javax.swing.JLabel();
        poster = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNoReg = new javax.swing.JLabel();
        txtNoReg = new javax.swing.JFormattedTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSchool = new javax.swing.JFormattedTextField();
        lblAge = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JFormattedTextField();
        lblAddress = new javax.swing.JLabel();
        lblMajor = new javax.swing.JLabel();
        txtMajor = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAddress = new javax.swing.JTextArea();
        cbGender = new javax.swing.JComboBox<>();
        lblIdStudent = new javax.swing.JLabel();
        txtIdStudent = new java.awt.TextField();
        Calendar = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        lblEnglish = new javax.swing.JLabel();
        txtEnglish = new javax.swing.JFormattedTextField();
        lblMath = new javax.swing.JLabel();
        txtMathematics = new javax.swing.JFormattedTextField();
        lblPysic = new javax.swing.JLabel();
        txtPhisics = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        lblIndo = new javax.swing.JLabel();
        txtIndonesian = new javax.swing.JFormattedTextField();
        lblChemistry = new javax.swing.JLabel();
        txtChemistry = new javax.swing.JFormattedTextField();
        lblVocational = new javax.swing.JLabel();
        txtVocational = new javax.swing.JFormattedTextField();
        lblBiology = new javax.swing.JLabel();
        txtBio = new javax.swing.JFormattedTextField();
        btnRegis = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        panelJudul = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1800, 800));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitle.setText("Admission Academic Year 2016 / 2017");

        poster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/penerimaan.jpg"))); // NOI18N
        poster.setMaximumSize(new java.awt.Dimension(500, 450));
        poster.setName(""); // NOI18N
        poster.setVerifyInputWhenFocusTarget(false);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        lblNoReg.setText("No Registration");

        lblName.setText("Full Name");

        jLabel1.setText("School's Name");

        lblAge.setText("Birth Date");

        lblGender.setText("Gender");

        lblEmail.setText("Email");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel2.setText("Phone No");

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

        lblAddress.setText("Address");

        lblMajor.setText("ID Major");

        txtMajor.setEditable(false);
        txtMajor.setText("MAJOR003");
        txtMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMajorActionPerformed(evt);
            }
        });

        taAddress.setColumns(20);
        taAddress.setRows(5);
        jScrollPane1.setViewportView(taAddress);

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- None -", "Male", "Female" }));

        lblIdStudent.setText("ID Student");

        txtIdStudent.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAge)
                            .addComponent(lblGender)
                            .addComponent(lblEmail)
                            .addComponent(jLabel2)
                            .addComponent(lblName)
                            .addComponent(lblAddress)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSchool)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail)
                            .addComponent(cbGender, 0, 250, Short.MAX_VALUE)
                            .addComponent(Calendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMajor)
                            .addComponent(lblNoReg)
                            .addComponent(lblIdStudent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoReg, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtMajor)
                            .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoReg)
                    .addComponent(txtNoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMajor)
                    .addComponent(txtMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdStudent)
                    .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAge)
                    .addComponent(Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lblEnglish.setText("English");

        txtEnglish.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnglishKeyTyped(evt);
            }
        });

        lblMath.setText("Mathematics");

        txtMathematics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMathematicsActionPerformed(evt);
            }
        });
        txtMathematics.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMathematicsKeyTyped(evt);
            }
        });

        lblPysic.setText("Phisics");

        txtPhisics.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhisicsKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Humanst521 Lt BT", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("Enter The Value of National Exam Here! ");

        lblIndo.setText("Indonesian");

        txtIndonesian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIndonesianActionPerformed(evt);
            }
        });
        txtIndonesian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndonesianKeyTyped(evt);
            }
        });

        lblChemistry.setText("Chemistry");

        txtChemistry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChemistryKeyTyped(evt);
            }
        });

        lblVocational.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblVocational.setText("ID Sains");

        txtVocational.setEditable(false);
        txtVocational.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVocationalActionPerformed(evt);
            }
        });

        lblBiology.setText("Biology");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIndo)
                            .addComponent(lblEnglish)
                            .addComponent(lblMath))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEnglish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIndonesian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblVocational, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(txtVocational, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChemistry)
                            .addComponent(lblPysic)
                            .addComponent(lblBiology))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMathematics, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhisics, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtChemistry, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVocational, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVocational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIndo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIndonesian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnglish)
                    .addComponent(txtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMath)
                    .addComponent(txtMathematics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhisics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPysic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChemistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChemistry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiology)
                    .addComponent(txtBio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnRegis.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        btnRegis.setText("REGIS NOW");
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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
                    .addContainerGap(463, Short.MAX_VALUE)))
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
                        .addGap(45, 45, 45)
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTitle)
                        .addGap(38, 38, 38)
                        .addComponent(poster, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        inputNumber(txtPhone, evt);
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMajorActionPerformed

    private void txtEnglishKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnglishKeyTyped
        inputValue(txtEnglish, evt);
    }//GEN-LAST:event_txtEnglishKeyTyped

    private void txtMathematicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMathematicsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMathematicsActionPerformed

    private void txtMathematicsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMathematicsKeyTyped
        inputValue(txtMathematics, evt);
    }//GEN-LAST:event_txtMathematicsKeyTyped

    private void txtPhisicsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhisicsKeyTyped
        inputValue(txtPhisics, evt);
    }//GEN-LAST:event_txtPhisicsKeyTyped

    private void txtIndonesianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIndonesianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIndonesianActionPerformed

    private void txtIndonesianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndonesianKeyTyped
        inputValue(txtIndonesian, evt);
    }//GEN-LAST:event_txtIndonesianKeyTyped

    private void txtChemistryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChemistryKeyTyped
        inputValue(txtChemistry, evt);
    }//GEN-LAST:event_txtChemistryKeyTyped

    private void txtVocationalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVocationalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVocationalActionPerformed

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        String noreg = txtNoReg.getText();
        String idmajor = txtMajor.getText();
        String idstudent = txtIdStudent.getText();
        String name = txtName.getText();
        String gender = cbGender.getSelectedItem().toString();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();
        String address = taAddress.getText();
        String school = txtSchool.getText();
        String vocational = txtVocational.getText();
        String indo = txtIndonesian.getText();
        String eng = txtEnglish.getText();
        String math = txtMathematics.getText();
        String teory = txtPhisics.getText();
        String practice = txtChemistry.getText();

        if(idstudent.equals("") || name.equals("") || email.equals("") || phone.equals("") || school.equals("") || vocational.equals("") || address.equals("") || indo.equals("") || eng.equals("") || math.equals("") || teory.equals("") || practice.equals("") || gender.equals("- None -"))
        {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Data Field Can Not Be Empty");

            autoids();
            autoidv();
        }
        else
        {
            addStudent();
            //  updateQuota();
            cleartext();
            autoids();
            autoidv();
        }

        //        else
        //        {
            //            if (email.equals("Email Benar"))
            //            {
                //                //JOptionPane.showMessageDialog(null, "Sukssssssssseeeeeeeeeeeeeeeesssssssss");
                //                Confirmation cf = new Confirmation();
                //                cf.setVisible(true);
                //                this.dispose();
                //            }
            //            else
            //            {
                //                Toolkit.getDefaultToolkit().beep();
                //                JOptionPane.showMessageDialog(rootPane, "Enter Your Valid Email");
                //            }
            //        }

    }//GEN-LAST:event_btnRegisActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try 
        {
            String[] data = ai.caridataAdmin();
            Home hm = new Home(data[0]);
            hm.setVisible(true);
            this.dispose();
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrationITIPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationITIPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationITIPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationITIPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationITIPA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Calendar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegis;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBiology;
    private javax.swing.JLabel lblChemistry;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEnglish;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIdStudent;
    private javax.swing.JLabel lblIndo;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblMath;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNoReg;
    private javax.swing.JLabel lblPysic;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVocational;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JLabel poster;
    private javax.swing.JTextArea taAddress;
    private javax.swing.JFormattedTextField txtBio;
    private javax.swing.JFormattedTextField txtChemistry;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JFormattedTextField txtEnglish;
    private java.awt.TextField txtIdStudent;
    private javax.swing.JFormattedTextField txtIndonesian;
    private javax.swing.JFormattedTextField txtMajor;
    private javax.swing.JFormattedTextField txtMathematics;
    private javax.swing.JFormattedTextField txtName;
    private javax.swing.JFormattedTextField txtNoReg;
    private javax.swing.JFormattedTextField txtPhisics;
    private javax.swing.JFormattedTextField txtPhone;
    private javax.swing.JFormattedTextField txtSchool;
    private javax.swing.JFormattedTextField txtVocational;
    // End of variables declaration//GEN-END:variables
}
