/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Programmer
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    private String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
    private String us1,us2,us3,us4,us5,us6,us7,us8,us9,us10,us11,us12,us13,us14;
    private String f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19;
    private String uf1,uf2,uf3,uf4,uf5,uf6,uf7,uf8,uf9,uf10,uf11,uf12,uf13,uf14,uf15,uf16,uf17,uf18,uf19;
    private String fees1,fees2,fees3,fees4,fees5,fees6,fees7,fees8,fees9,fees10,fees11,fees12,fees13;
    private String ff13="",ff5="",ff8="",ff11="",ff14="";
    private String uff13="",uff5="",uff8="",uff11="",uff14="",uff18;
    private String ss7 = "",ss9 = "",ss10 = "";
    private String uss7 = "",uss9 = "",uss10 = "",uss11 = "";
    Pattern letterPattern = Pattern.compile("^[\\p{L} .'-]+$");
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;
    private Pattern patternPhone;
    private Matcher matcherPhone;
    private Pattern patternSalary;
    private Matcher matcherSalary;
    private Pattern patternId;
    private Matcher matcherId;
    private String username="";
    private String password="";
    private Connection conn;
    private Statement stm2;
    private ResultSet rs2 ;
    PreparedStatement preparedStmt;
    Connection conpaid;
    
  

    private PreparedStatement stm;
    String url = "jdbc:mysql://localhost:3306/navyug_database?useSSL = true";
    String id="";
    String in;
    String sin;
    String fin;
    int nid=0;
    String aid="";
    int anid =0;
    String fid="";
    int fnid =0;
    ///**********Srudents**********////
    private Pattern patternAdmissionId;
    private Matcher matcherAdmissionId;
    private Pattern patternRollNo;
    private Matcher matcherRollNo;
    private Pattern patternFees;
    private Matcher matcherFees;
    int xx=0;
    int yy=0;
    ////**********Fees*****///
    private Pattern patternFee1;
    private Matcher matcherFee1;
    private Pattern patternFee2;
    private Matcher matcherFee2;
    private Pattern patternFee3;
    private Matcher matcherFee3;
    private Pattern patternFee4;
    private Matcher matcherFee4;
    private Pattern patternFee5;
    private Matcher matcherFee5;
    private Pattern patternFee6;
    private Matcher matcherFee6;
    private Pattern patternFee7;
    private Matcher matcherFee7;
    
    String monthName[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
    String month="";
    String year = "";
    String monthYear="";
    String newMonths1;
    String newYears2;
    public AdminFrame() {
        
        
        Calendar cal = Calendar.getInstance();
        month=monthName[cal.get(Calendar.MONTH)];
        int intYear=cal.get(Calendar.YEAR);
        year = String.valueOf(intYear);
        monthYear = month+year;

        
        pattern = Pattern.compile(EMAIL_PATTERN);
        patternPhone = Pattern.compile("[0-9]{6,10}");
        patternSalary = Pattern.compile("[0-9]{4,8}");
        patternId = Pattern.compile("[0-9]{4,10}");
        
        ///**********Srudents**********////
        patternAdmissionId = Pattern.compile("[0-9]{4,10}");
         patternRollNo = Pattern.compile("[0-9]{1,3}");
         patternFees = Pattern.compile("[0-9]{2,6}");
         
         ////********fees*****//////
         patternFee1 = Pattern.compile("[0-9]{1,10}");
         patternFee2 = Pattern.compile("[0-9]{1,8}");
         patternFee3 = Pattern.compile("[0-9]{1,8}");
         patternFee4 = Pattern.compile("[0-9]{1,8}");
         patternFee5 = Pattern.compile("[0-9]{1,8}");
         patternFee6 = Pattern.compile("[0-9]{1,8}");
         patternFee7 = Pattern.compile("[0-9]{1,8}");
    
         try{               
                Class.forName("com.mysql.cj.jdbc.Driver");
                
         }catch(ClassNotFoundException e){ JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }
            try{
            FileReader file = new FileReader("user.dll");
            char data[] =new  char[24];
            int charsread = file.read(data);
            username = new String (data,0,charsread);
            file.close();
            FileReader file4 = new FileReader("pass.dll");
            char data2[] =new  char[24];
            int charsread2 = file4.read(data2);
            password = new String (data2,0,charsread2);
            file4.close();
            
            FileReader file5 = new FileReader("uniqueId.dll");
            char data5[] =new  char[10];
            int charsread5 = file5.read(data5);
            String num = new String (data5,0,charsread5);
            file5.close();
            nid = 1+Integer.parseInt(num);
            id = String.valueOf(nid);
            
            FileReader file6 = new FileReader("admissionid.dll");
            char data6[] =new  char[10];
            int charsread6 = file6.read(data6);
            String num2 = new String (data6,0,charsread6);
            file6.close();
            anid = 1+Integer.parseInt(num2);
            aid = String.valueOf(anid);
            
            FileReader file7 = new FileReader("fees.dll");
            char data7[] =new  char[10];
            int charsread7 = file7.read(data7);
            String num7 = new String (data7,0,charsread7);
            file7.close();
            fnid = 1+Integer.parseInt(num7);
            fid = String.valueOf(fnid);
            
            
            
            }catch(IOException e){ JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }
        initComponents();
        idText.setText(id);
        sNText.setText(fid);
        admissionText.setText(aid);
        setLocationRelativeTo(null);
        buttonGroup1 = new javax.swing.ButtonGroup();buttonGroup1.add(male);buttonGroup1.add(female);
        buttonGroup2 = new javax.swing.ButtonGroup();buttonGroup2.add(male1);buttonGroup2.add(female1);
        buttonGroup3 = new javax.swing.ButtonGroup();buttonGroup3.add(sMale);buttonGroup3.add(sFemale);
        buttonGroup4 = new javax.swing.ButtonGroup();buttonGroup4.add(sMale1);buttonGroup4.add(sFemale1);
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fNameText = new javax.swing.JTextField();
        lNameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fatherText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        qualification = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        designation = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        salaryText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressText = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dobText = new com.toedter.calendar.JDateChooser();
        joiningText = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        idText1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fNameText1 = new javax.swing.JTextField();
        dobText1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        lNameText1 = new javax.swing.JTextField();
        phoneText1 = new javax.swing.JTextField();
        fatherText1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        male1 = new javax.swing.JRadioButton();
        female1 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        emailText1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        qualification1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        designation1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        salaryText1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        joiningText1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressText1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        admissionText = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        sFirstNameText = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        rollText = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        sLastNameText = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        class2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        sFatherText = new javax.swing.JTextField();
        sFatherContact = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        fatherOccupation = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        sMotherContactText = new javax.swing.JTextField();
        sMotherText = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        motherOccupation = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        sMale = new javax.swing.JRadioButton();
        sFemale = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        caste = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sAddressText = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        sdob = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        admissionDate = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        feesText = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        admissionText1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        sFirstNameText1 = new javax.swing.JTextField();
        sLastNameText1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        class3 = new javax.swing.JComboBox<>();
        rollText1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        sFatherText1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        sFatherContact1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        fatherOccupation1 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        sMotherText1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        sMotherContactText1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        motherOccupation1 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        sMale1 = new javax.swing.JRadioButton();
        sFemale1 = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        caste1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        sAddressText1 = new javax.swing.JTextArea();
        jLabel63 = new javax.swing.JLabel();
        sdob1 = new com.toedter.calendar.JDateChooser();
        admissionDate1 = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        feesText1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        studentStatus = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        sNText = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        feeDate = new com.toedter.calendar.JDateChooser();
        feeStudent = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        feeFather = new javax.swing.JTextField();
        feeClass = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        feeAdmission = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        feeRoll = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel87 = new javax.swing.JLabel();
        tuitionFee = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        annualFee = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        admissionFee = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        lateFee = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        otherFee = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        totalFee = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        newMonth = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        newYear = new javax.swing.JComboBox<>();
        jButton23 = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        x = new javax.swing.JLabel();
        mini = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nav Yug Happy Public Sec School");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/logo.png")).getImage());
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0), 10));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jTabbedPane2.setForeground(new java.awt.Color(153, 0, 51));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseDragged(evt);
            }
        });
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 51));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 239, 154));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Staff Id :");

        idText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idText.setForeground(new java.awt.Color(255, 0, 102));
        idText.setToolTipText("Only 4 to 10 digits");
        idText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idTextFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("First Name :");

        fNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fNameText.setForeground(new java.awt.Color(0, 51, 255));
        fNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fNameTextFocusLost(evt);
            }
        });

        lNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lNameText.setForeground(new java.awt.Color(0, 51, 255));
        lNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lNameTextFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Last Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Father's Name/Husband's Name :");

        fatherText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fatherText.setForeground(new java.awt.Color(0, 51, 255));
        fatherText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fatherTextFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Gender :");

        male.setText("Male");
        male.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                maleItemStateChanged(evt);
            }
        });

        female.setText("Female");
        female.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                femaleItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Phone No :");

        phoneText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneText.setForeground(new java.awt.Color(0, 51, 255));
        phoneText.setToolTipText("Only 6 to 10 digits");
        phoneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneTextFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("E-mail ID :");

        emailText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailText.setForeground(new java.awt.Color(0, 51, 255));
        emailText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Qualification :");

        qualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","10th","12th","B Com","B Ed","B Pharma","B Sc","BBA","BCA","BDS","BE / B Tech","CA / ICWA","CS / ICSA","Diploma","Graduate","ITI","LLB","M Com","M Sc","MBA / PGDBM","MBBS","MCA","ME / M Tech","MSW","Ph D","Post Graduate","Other" }));
        qualification.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                qualificationItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Designation :");

        designation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  Principal","  Vice – principal","  Senior Teacher","  Teacher","  Junior Teacher","  Computer Teacher","  Physical Education Teacher","  Art & Craft","  Drawing Teacher","  Music Teacher","  Senior Administration Executive","  Junior Accountant","  Office Assistant","  Data Entry Operator","  Receptionist","  Security Guard","  Peon","  Plumber","  Electrician ","  Others"}));
        designation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                designationItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Salary :");

        salaryText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryText.setForeground(new java.awt.Color(0, 51, 255));
        salaryText.setToolTipText("Only 4 to 8 digits");
        salaryText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                salaryTextFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Address :");

        addressText.setColumns(20);
        addressText.setForeground(new java.awt.Color(0, 51, 255));
        addressText.setRows(5);
        addressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressTextFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(addressText);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/4.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/2.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Joining Date :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("D.O.B :");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 0, 0));
        jLabel14.setText("ADD NEW STAFF FORM");

        dobText.setForeground(new java.awt.Color(0, 51, 255));
        dobText.setDateFormatString("dd-MM-yyyy");

        joiningText.setForeground(new java.awt.Color(0, 51, 255));
        joiningText.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fatherText, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(male)
                                .addGap(18, 18, 18)
                                .addComponent(female)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dobText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(joiningText, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(dobText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(fatherText, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(male)
                        .addComponent(female))
                    .addComponent(emailText))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(joiningText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add New Staff", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 239, 154));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 0, 0));
        jLabel15.setText("Update & Change Status Staff Form");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 380, 32));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Staff Id :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, 28));

        idText1.setEditable(false);
        idText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idText1.setForeground(new java.awt.Color(255, 0, 102));
        idText1.setToolTipText("Only 4 to 10 digits");
        idText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idText1FocusLost(evt);
            }
        });
        jPanel5.add(idText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 98, 28));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("First Name :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 32));

        fNameText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fNameText1.setForeground(new java.awt.Color(0, 51, 255));
        fNameText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fNameText1FocusLost(evt);
            }
        });
        jPanel5.add(fNameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 208, 30));

        dobText1.setForeground(new java.awt.Color(0, 51, 255));
        dobText1.setDateFormatString("dd-MM-yyyy");
        jPanel5.add(dobText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 208, 27));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("D.O.B :");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 87, 32));

        lNameText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lNameText1.setForeground(new java.awt.Color(0, 51, 255));
        lNameText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lNameText1FocusLost(evt);
            }
        });
        jPanel5.add(lNameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 190, 32));

        phoneText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneText1.setForeground(new java.awt.Color(0, 51, 255));
        phoneText1.setToolTipText("Only 6 to 10 digits");
        phoneText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneText1FocusLost(evt);
            }
        });
        jPanel5.add(phoneText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 190, 32));

        fatherText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fatherText1.setForeground(new java.awt.Color(0, 51, 255));
        fatherText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fatherText1FocusLost(evt);
            }
        });
        jPanel5.add(fatherText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 392, 32));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Father's Name/Husband's Name :");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 32));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Gender :");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 94, 32));

        male1.setText("Male");
        male1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                male1ItemStateChanged(evt);
            }
        });
        jPanel5.add(male1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        female1.setText("Female");
        female1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                female1ItemStateChanged(evt);
            }
        });
        jPanel5.add(female1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("E-mail ID :");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 80, 32));

        emailText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailText1.setForeground(new java.awt.Color(0, 51, 255));
        emailText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailText1FocusLost(evt);
            }
        });
        jPanel5.add(emailText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 282, 32));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Qualification :");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, 32));

        qualification1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","10th","12th","B Com","B Ed","B Pharma","B Sc","BBA","BCA","BDS","BE / B Tech","CA / ICWA","CS / ICSA","Diploma","Graduate","ITI","LLB","M Com","M Sc","MBA / PGDBM","MBBS","MCA","ME / M Tech","MSW","Ph D","Post Graduate","Other" }));
        qualification1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                qualification1ItemStateChanged(evt);
            }
        });
        jPanel5.add(qualification1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 182, 35));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Designation :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 100, 32));

        designation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  Principal","  Vice – principal","  Senior Teacher","  Teacher","  Junior Teacher","  Computer Teacher","  Physical Education Teacher","  Art & Craft","  Drawing Teacher","  Music Teacher","  Senior Administration Executive","  Junior Accountant","  Office Assistant","  Data Entry Operator","  Receptionist","  Security Guard","  Peon","  Plumber","  Electrician ","  Others"}));
        designation1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                designation1ItemStateChanged(evt);
            }
        });
        jPanel5.add(designation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 200, 35));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Salary :");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 81, 32));

        salaryText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salaryText1.setForeground(new java.awt.Color(0, 51, 255));
        salaryText1.setToolTipText("Only 4 to 8 digits");
        salaryText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                salaryText1FocusLost(evt);
            }
        });
        jPanel5.add(salaryText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 182, 32));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Joining Date :");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 100, 32));

        joiningText1.setForeground(new java.awt.Color(0, 51, 255));
        joiningText1.setDateFormatString("dd-MM-yyyy");
        jPanel5.add(joiningText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 200, 27));

        addressText1.setColumns(20);
        addressText1.setForeground(new java.awt.Color(0, 51, 255));
        addressText1.setRows(5);
        addressText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressText1FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(addressText1);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 500, 104));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Address :");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 94, 32));

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/8.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 105, 37));

        jButton4.setBackground(new java.awt.Color(255, 255, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/2.png"))); // NOI18N
        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 105, 37));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Last Name :");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 32));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Phone No :");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, 32));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Status :");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 78, 32));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Active","Resigned","Terminated","On-Hold","Suspended"}));
        status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusItemStateChanged(evt);
            }
        });
        jPanel5.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 207, 35));

        jButton5.setBackground(new java.awt.Color(204, 0, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/5.png"))); // NOI18N
        jButton5.setText("Search Staff");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 37));

        jTabbedPane1.addTab("Update & Status", jPanel5);

        jPanel2.setBackground(new java.awt.Color(255, 239, 154));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel8.setBackground(new java.awt.Color(102, 204, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton11.setBackground(new java.awt.Color(102, 204, 0));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/6.png"))); // NOI18N
        jButton11.setText("Show All Record");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setText("All Staff Details");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(102, 204, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton12.setBackground(new java.awt.Color(102, 204, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton12.setText("Print Staff Details");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel72.setText("Single Staff Record");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(102, 204, 0));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton17.setBackground(new java.awt.Color(102, 204, 0));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton17.setText("Print Staff Details");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel71.setText("All Active Staff");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton17)
                        .addGap(180, 180, 180))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Other", jPanel2);

        jTabbedPane2.addTab("", new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/1.png")), jTabbedPane1, "Staff Form"); // NOI18N

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 239, 154));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 0));
        jLabel30.setText("ADMISSION FORM");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 233, 32));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Admission No :");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 69, 86, 28));

        admissionText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admissionText.setForeground(new java.awt.Color(255, 0, 51));
        admissionText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                admissionTextFocusLost(evt);
            }
        });
        jPanel4.add(admissionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 68, 209, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("First Name :");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 118, -1, 32));

        sFirstNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFirstNameText.setForeground(new java.awt.Color(0, 51, 255));
        sFirstNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFirstNameTextFocusLost(evt);
            }
        });
        jPanel4.add(sFirstNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 119, 209, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Roll No :");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 110, -1, 32));

        rollText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rollText.setForeground(new java.awt.Color(0, 51, 255));
        rollText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rollTextFocusLost(evt);
            }
        });
        jPanel4.add(rollText, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 113, 219, 32));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Last Name :");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 166, 86, 28));

        sLastNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sLastNameText.setForeground(new java.awt.Color(0, 51, 255));
        sLastNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sLastNameTextFocusLost(evt);
            }
        });
        jPanel4.add(sLastNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 165, 209, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("Class :");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 163, 80, 32));

        class2.setForeground(new java.awt.Color(0, 102, 255));
        class2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  I-A","  I-B","  I-C","  I-D","  I-E","  I-F","  II-A","  II-B","  II-C","  II-D","  II-E","  II-F","  III-A","  III-B","  III-C","  III-D","  III-E","  III-F","  IV-A","  IV-B","  IV-C","  IV-D","  IV-E","  IV-F","  V-A","  V-B","  V-C","  V-D","  V-E","  V-F","  VI-A","  VI-B","  VI-C","  VI-D","  VI-E","  VI-F","  VII-A","  VII-B","  VII-C","  VII-D","  VII-E","  VII-F","  VIII-A","  VIII-B","  VIII-C","  VIII-D","  VIII-E","  VIII-F","  IX-A","  IX-B","  IX-C","  IX-D","  IX-E","  IX-F","  X-A","  X-B","  X-C","  X-D","  X-E","  X-F","  XI-A","  XI-B","  XI-C","  XI-D","  XI-E","  XI-F","  XII-A","  XII-B","  XII-C","  XII-D","  XII-E","  XII-F" }));
        class2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                class2ItemStateChanged(evt);
            }
        });
        jPanel4.add(class2, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 160, 219, 35));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setText("Father's Name");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 214, 98, 28));

        sFatherText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFatherText.setForeground(new java.awt.Color(0, 51, 255));
        sFatherText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFatherTextFocusLost(evt);
            }
        });
        jPanel4.add(sFatherText, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 213, 578, 30));

        sFatherContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFatherContact.setForeground(new java.awt.Color(0, 51, 255));
        sFatherContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFatherContactFocusLost(evt);
            }
        });
        jPanel4.add(sFatherContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 255, 186, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("Father's Contact No :");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 256, 131, 28));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setText("Father's Occupation :");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 254, 132, 32));

        fatherOccupation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Businessman","Salaried(govt)","Salaried (other than govt)","Self employed","Unemployed","Other" }));
        fatherOccupation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fatherOccupationItemStateChanged(evt);
            }
        });
        fatherOccupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherOccupationActionPerformed(evt);
            }
        });
        jPanel4.add(fatherOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 254, 219, 35));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("Mother's Name");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 295, 100, 28));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("Mother's Contact No :");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 333, 131, 28));

        sMotherContactText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sMotherContactText.setForeground(new java.awt.Color(0, 51, 255));
        sMotherContactText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sMotherContactTextFocusLost(evt);
            }
        });
        jPanel4.add(sMotherContactText, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 332, 186, 30));

        sMotherText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sMotherText.setForeground(new java.awt.Color(0, 51, 255));
        sMotherText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sMotherTextFocusLost(evt);
            }
        });
        jPanel4.add(sMotherText, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 295, 576, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("Mother's Occupation :");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 331, 131, 32));

        motherOccupation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Housewife","Businessman","Salaried(govt)","Salaried (other than govt)","Self employed","Unemployed","Other" }));
        motherOccupation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                motherOccupationItemStateChanged(evt);
            }
        });
        motherOccupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherOccupationActionPerformed(evt);
            }
        });
        jPanel4.add(motherOccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 331, 219, 35));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("Gender :");
        jPanel4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 372, 70, 32));

        sMale.setText("Male");
        sMale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sMaleItemStateChanged(evt);
            }
        });
        jPanel4.add(sMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 373, -1, 30));

        sFemale.setText("Female");
        sFemale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sFemaleItemStateChanged(evt);
            }
        });
        jPanel4.add(sFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 373, -1, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("Caste :");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 372, 77, 32));

        caste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","GENERAL","OBC","SC","ST","OTHER" }));
        caste.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                casteItemStateChanged(evt);
            }
        });
        caste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casteActionPerformed(evt);
            }
        });
        jPanel4.add(caste, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 372, 219, 35));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("Address :");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 372, 94, 32));

        sAddressText.setColumns(20);
        sAddressText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sAddressText.setForeground(new java.awt.Color(0, 102, 255));
        sAddressText.setRows(5);
        sAddressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sAddressTextFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(sAddressText);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 330, 120));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Date of Birth :");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, -1, -1));

        sdob.setForeground(new java.awt.Color(0, 51, 255));
        sdob.setDateFormatString("dd-MM-yyyy");
        jPanel4.add(sdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 220, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("Admission Date :");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        admissionDate.setForeground(new java.awt.Color(0, 51, 255));
        admissionDate.setDateFormatString("dd-MM-yyyy");
        jPanel4.add(admissionDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 220, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Fees :");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 86, 28));

        feesText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        feesText.setForeground(new java.awt.Color(0, 51, 255));
        feesText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                feesTextFocusLost(evt);
            }
        });
        jPanel4.add(feesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 220, 30));

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/2.png"))); // NOI18N
        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 120, 40));

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/4.png"))); // NOI18N
        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 120, 40));

        jTabbedPane3.addTab("Admission Form", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 239, 154));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admissionText1.setEditable(false);
        admissionText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admissionText1.setForeground(new java.awt.Color(255, 0, 51));
        admissionText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                admissionText1FocusLost(evt);
            }
        });
        jPanel6.add(admissionText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 71, 209, 30));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 0, 0));
        jLabel48.setText("Update Student  Form");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 13, 233, 32));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel49.setText("Admission No :");
        jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 72, 86, 28));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel50.setText("First Name :");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 121, -1, 32));

        sFirstNameText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFirstNameText1.setForeground(new java.awt.Color(0, 51, 255));
        sFirstNameText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFirstNameText1FocusLost(evt);
            }
        });
        jPanel6.add(sFirstNameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 122, 209, 30));

        sLastNameText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sLastNameText1.setForeground(new java.awt.Color(0, 51, 255));
        sLastNameText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sLastNameText1FocusLost(evt);
            }
        });
        jPanel6.add(sLastNameText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 168, 209, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Last Name :");
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 169, 86, 28));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("Roll No :");
        jPanel6.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 113, -1, 32));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setText("Class :");
        jPanel6.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 166, 80, 32));

        class3.setForeground(new java.awt.Color(0, 102, 255));
        class3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  I-A","  I-B","  I-C","  I-D","  I-E","  I-F","  II-A","  II-B","  II-C","  II-D","  II-E","  II-F","  III-A","  III-B","  III-C","  III-D","  III-E","  III-F","  IV-A","  IV-B","  IV-C","  IV-D","  IV-E","  IV-F","  V-A","  V-B","  V-C","  V-D","  V-E","  V-F","  VI-A","  VI-B","  VI-C","  VI-D","  VI-E","  VI-F","  VII-A","  VII-B","  VII-C","  VII-D","  VII-E","  VII-F","  VIII-A","  VIII-B","  VIII-C","  VIII-D","  VIII-E","  VIII-F","  IX-A","  IX-B","  IX-C","  IX-D","  IX-E","  IX-F","  X-A","  X-B","  X-C","  X-D","  X-E","  X-F","  XI-A","  XI-B","  XI-C","  XI-D","  XI-E","  XI-F","  XII-A","  XII-B","  XII-C","  XII-D","  XII-E","  XII-F" }));
        class3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                class3ItemStateChanged(evt);
            }
        });
        jPanel6.add(class3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 219, 35));

        rollText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rollText1.setForeground(new java.awt.Color(0, 51, 255));
        rollText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rollText1FocusLost(evt);
            }
        });
        jPanel6.add(rollText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 116, 219, 32));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel54.setText("Father's Name");
        jPanel6.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 217, 98, 28));

        sFatherText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFatherText1.setForeground(new java.awt.Color(0, 51, 255));
        sFatherText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFatherText1FocusLost(evt);
            }
        });
        jPanel6.add(sFatherText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 216, 578, 30));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel55.setText("Father's Contact No :");
        jPanel6.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 259, 131, 28));

        sFatherContact1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sFatherContact1.setForeground(new java.awt.Color(0, 51, 255));
        sFatherContact1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sFatherContact1FocusLost(evt);
            }
        });
        jPanel6.add(sFatherContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 258, 186, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel56.setText("Father's Occupation :");
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 257, 132, 32));

        fatherOccupation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Businessman","Salaried(govt)","Salaried (other than govt)","Self employed","Unemployed","Other" }));
        fatherOccupation1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fatherOccupation1ItemStateChanged(evt);
            }
        });
        fatherOccupation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fatherOccupation1ActionPerformed(evt);
            }
        });
        jPanel6.add(fatherOccupation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 257, 219, 35));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel57.setText("Mother's Name");
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 298, 100, 28));

        sMotherText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sMotherText1.setForeground(new java.awt.Color(0, 51, 255));
        sMotherText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sMotherText1FocusLost(evt);
            }
        });
        jPanel6.add(sMotherText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 298, 576, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel58.setText("Mother's Contact No :");
        jPanel6.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 336, 131, 28));

        sMotherContactText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sMotherContactText1.setForeground(new java.awt.Color(0, 51, 255));
        sMotherContactText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sMotherContactText1FocusLost(evt);
            }
        });
        jPanel6.add(sMotherContactText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 335, 186, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel59.setText("Mother's Occupation :");
        jPanel6.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 334, 131, 32));

        motherOccupation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Housewife","Businessman","Salaried(govt)","Salaried (other than govt)","Self employed","Unemployed","Other" }));
        motherOccupation1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                motherOccupation1ItemStateChanged(evt);
            }
        });
        motherOccupation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motherOccupation1ActionPerformed(evt);
            }
        });
        jPanel6.add(motherOccupation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 335, 219, 35));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel60.setText("Address :");
        jPanel6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 375, 94, 32));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel61.setText("Gender :");
        jPanel6.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 375, 70, 32));

        sMale1.setText("Male");
        sMale1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sMale1ItemStateChanged(evt);
            }
        });
        jPanel6.add(sMale1, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 376, -1, 30));

        sFemale1.setText("Female");
        sFemale1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sFemale1ItemStateChanged(evt);
            }
        });
        jPanel6.add(sFemale1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 376, -1, 30));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel62.setText("Caste :");
        jPanel6.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 375, 77, 32));

        caste1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","GENERAL","OBC","SC","ST","Other" }));
        caste1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                caste1ItemStateChanged(evt);
            }
        });
        caste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caste1ActionPerformed(evt);
            }
        });
        jPanel6.add(caste1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 376, 219, 35));

        sAddressText1.setColumns(20);
        sAddressText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sAddressText1.setForeground(new java.awt.Color(0, 102, 255));
        sAddressText1.setRows(5);
        sAddressText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sAddressText1FocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(sAddressText1);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 413, 330, 120));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel63.setText("Date of Birth :");
        jPanel6.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 433, -1, -1));

        sdob1.setForeground(new java.awt.Color(0, 51, 255));
        sdob1.setDateFormatString("dd-MM-yyyy");
        jPanel6.add(sdob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 423, 220, 30));

        admissionDate1.setForeground(new java.awt.Color(0, 51, 255));
        admissionDate1.setDateFormatString("dd-MM-yyyy");
        jPanel6.add(admissionDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 463, 220, 30));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel64.setText("Admission Date :");
        jPanel6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 473, -1, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel65.setText("Fees :");
        jPanel6.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 503, 86, 28));

        feesText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        feesText1.setForeground(new java.awt.Color(0, 51, 255));
        feesText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                feesText1FocusLost(evt);
            }
        });
        jPanel6.add(feesText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 503, 220, 30));

        jButton8.setBackground(new java.awt.Color(204, 0, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/5.png"))); // NOI18N
        jButton8.setText("Search Student");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 56, 149, 40));

        jButton9.setBackground(new java.awt.Color(255, 255, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/8.png"))); // NOI18N
        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 120, 40));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel67.setText("Status :");
        jPanel6.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 542, 63, 32));

        studentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Active","Left","Passed-Out","Deid","Suspended","Restricted" }));
        studentStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studentStatusItemStateChanged(evt);
            }
        });
        studentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentStatusActionPerformed(evt);
            }
        });
        jPanel6.add(studentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 542, 222, 35));

        jButton10.setBackground(new java.awt.Color(255, 255, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/2.png"))); // NOI18N
        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 120, 40));

        jTabbedPane3.addTab("Update Form", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 239, 154));

        jPanel10.setBackground(new java.awt.Color(102, 204, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton13.setBackground(new java.awt.Color(102, 204, 0));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/6.png"))); // NOI18N
        jButton13.setText("Show All Record");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("All Student Details");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel11.setBackground(new java.awt.Color(102, 204, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton14.setBackground(new java.awt.Color(102, 204, 0));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton14.setText("Print Student Details");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setText("Single Student Record");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jButton14)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel13.setBackground(new java.awt.Color(102, 204, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton16.setBackground(new java.awt.Color(102, 204, 0));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton16.setText("Print Student Details");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel70.setText("All Active Student");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addGap(179, 179, 179))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Other", jPanel7);

        jTabbedPane2.addTab("", new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/7.png")), jTabbedPane3, "Student Form"); // NOI18N

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel16.setBackground(new java.awt.Color(255, 239, 154));
        jPanel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel17.setBackground(new java.awt.Color(255, 204, 51));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Fill Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 11), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("S. No. :");

        sNText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sNText.setForeground(new java.awt.Color(204, 0, 0));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Data :");

        feeDate.setDateFormatString("dd-MM-yyyy");

        feeStudent.setEditable(false);
        feeStudent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        feeStudent.setForeground(new java.awt.Color(0, 0, 255));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Name of the Student :");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Father's Name :");

        feeFather.setEditable(false);
        feeFather.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        feeFather.setForeground(new java.awt.Color(0, 0, 255));

        feeClass.setEditable(false);
        feeClass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        feeClass.setForeground(new java.awt.Color(0, 0, 255));
        feeClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeClassActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel78.setText("Class  :");

        feeAdmission.setEditable(false);
        feeAdmission.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        feeAdmission.setForeground(new java.awt.Color(0, 0, 255));
        feeAdmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeAdmissionActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("Admission No :");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Roll No  :");

        feeRoll.setEditable(false);
        feeRoll.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        feeRoll.setForeground(new java.awt.Color(0, 0, 255));
        feeRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeRollActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 204, 255));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("Tuition Fee:");

        tuitionFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tuitionFee.setForeground(new java.awt.Color(0, 0, 255));
        tuitionFee.setText("0");
        tuitionFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tuitionFeeFocusLost(evt);
            }
        });
        tuitionFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tuitionFeeKeyReleased(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Annual Charge :");

        annualFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        annualFee.setForeground(new java.awt.Color(0, 0, 255));
        annualFee.setText("0");
        annualFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                annualFeeFocusLost(evt);
            }
        });
        annualFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                annualFeeKeyReleased(evt);
            }
        });

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("Admission Fee  :");

        admissionFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        admissionFee.setForeground(new java.awt.Color(0, 0, 255));
        admissionFee.setText("0");
        admissionFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                admissionFeeFocusLost(evt);
            }
        });
        admissionFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                admissionFeeKeyReleased(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("Late Fee Charge   :");

        lateFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lateFee.setForeground(new java.awt.Color(0, 0, 255));
        lateFee.setText("0");
        lateFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lateFeeFocusLost(evt);
            }
        });
        lateFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lateFeeKeyReleased(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("Other Charge   :");

        otherFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        otherFee.setForeground(new java.awt.Color(0, 0, 255));
        otherFee.setText("0");
        otherFee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                otherFeeFocusLost(evt);
            }
        });
        otherFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otherFeeKeyReleased(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("Total  Fee  :");

        totalFee.setEditable(false);
        totalFee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalFee.setForeground(new java.awt.Color(0, 0, 255));
        totalFee.setText("0");

        jButton15.setBackground(new java.awt.Color(0, 204, 51));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/5.png"))); // NOI18N
        jButton15.setText("Search Student");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(feeFather)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(feeRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addComponent(sNText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(192, 192, 192)
                                        .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addComponent(feeAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(feeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(feeClass))
                                            .addComponent(feeDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(annualFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(tuitionFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(admissionFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(otherFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lateFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalFee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sNText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeClass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feeFather, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(feeRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(feeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(feeAdmission, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tuitionFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(annualFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lateFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(otherFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admissionFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(totalFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnSubmit.setBackground(new java.awt.Color(255, 255, 0));
        btnSubmit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/4.png"))); // NOI18N
        btnSubmit.setText("Save ");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 255, 0));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/2.png"))); // NOI18N
        jButton19.setText("Reset");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 0, 102));
        jLabel96.setText("Submit Fees Form");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jTabbedPane4.addTab("Submit Fees Form", jPanel16);

        jPanel18.setBackground(new java.awt.Color(255, 239, 154));

        jPanel19.setBackground(new java.awt.Color(102, 204, 0));
        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton18.setBackground(new java.awt.Color(102, 204, 0));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton18.setText("Print Student Details");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel80.setText("Current month single student details");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jButton18)
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel20.setBackground(new java.awt.Color(102, 204, 0));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton20.setBackground(new java.awt.Color(102, 204, 0));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton20.setText("Print Student Details");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel81.setText("Current month all paid student details");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addGap(177, 177, 177))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel21.setBackground(new java.awt.Color(102, 204, 0));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton21.setBackground(new java.awt.Color(102, 204, 0));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton21.setText("Print Student Details");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setText("Current month Unpaid Student details");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel23.setBackground(new java.awt.Color(255, 153, 0));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        newMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec" }));
        newMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                newMonthItemStateChanged(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("Month");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Year");

        newYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "2018","2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050" }));
        newYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                newYearItemStateChanged(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 204, 51));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton23.setText("Show Table");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setText("Show Month Paid Student Details ");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel84)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(newMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newYear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel93)
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel84)
                        .addComponent(newYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel85)))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Other", jPanel18);

        jTabbedPane2.addTab("", new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/feeeees.png")), jTabbedPane4); // NOI18N
        jTabbedPane4.getAccessibleContext().setAccessibleName("Submit Fees");

        jTabbedPane6.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel12.setBackground(new java.awt.Color(255, 239, 154));

        jPanel15.setBackground(new java.awt.Color(102, 204, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Logout.setBackground(new java.awt.Color(102, 204, 0));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/exit.png"))); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(Logout)
                .addGap(33, 33, 33))
        );

        jPanel22.setBackground(new java.awt.Color(255, 204, 0));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel83.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(153, 51, 0));
        jLabel83.setText("Developed by AVSK Developers ");

        jLabel95.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 0, 255));
        jLabel95.setText("avskdevelopers.com");

        jLabel97.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(153, 51, 0));
        jLabel97.setText("For any assistance feel free to contact at");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel83)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("", jPanel12);

        jTabbedPane2.addTab("", new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/exit.png")), jTabbedPane6); // NOI18N

        x.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        x.setText(" X");
        x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                xMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                xMouseExited(evt);
            }
        });

        mini.setFont(new java.awt.Font("Wide Latin", 1, 18)); // NOI18N
        mini.setText(" -");
        mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniMouseClicked(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 51, 51));
        jLabel69.setText("AVSK Happy Public Sec School");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mini, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x)
                    .addComponent(mini)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        admissionText1.setText("");
        sdob1.setCalendar(null);
        admissionDate1.setCalendar(null);
        sLastNameText1.setText("");
        sFirstNameText1.setText("");
        rollText1.setText("");
        class3.setSelectedIndex(0);
        sFatherText1.setText("");
        sFatherContact1.setText("");
        fatherOccupation1.setSelectedIndex(0);
        sMotherText1.setText("");
        sMotherContactText1.setText("");
        motherOccupation1.setSelectedIndex(0);
        sMale1.setSelected(true);
        uff13 = "Male";
        sAddressText1.setText("");
        caste1.setSelectedIndex(0);
        studentStatus.setSelectedIndex(0);

        feesText1.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void studentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentStatusActionPerformed

    private void studentStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentStatusItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uff18  = (String) evt.getItem();
        }
    }//GEN-LAST:event_studentStatusItemStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        uf1 = "";uf2 = "";uf3 = "";uf4 = "";uf5 = "";uf6 = "";uf7 = "";uf8 = "";uf9 = "";uf10 = "";uf11 = "";uf12 = "";uf13 = "";
        uf14 = "";uf15 = "";uf16 = "";uf17 = "";uf18="";
        int suFlag =0;
       
        uf1 = admissionText1.getText().trim();
        uf2 = sFirstNameText1.getText().trim();
        uf3 = sLastNameText1.getText().trim();
        uf4 = rollText1.getText().trim();
        uf5 = uff5;
        uf6 = sFatherText1.getText().trim();
        uf7 = sFatherContact1.getText().trim();
        uf8 = uff8;

        uf9 = sMotherText1.getText().trim();
        uf10 = sMotherContactText1.getText().trim();
        uf11 = uff11;
        uf12 = sAddressText1.getText().trim();
        uf13 = uff13;
        uf14 = uff14;
        uf15 = ((JTextField)sdob1.getDateEditor().getUiComponent()).getText().trim();
        uf16 = ((JTextField)admissionDate1.getDateEditor().getUiComponent()).getText().trim();
        uf17 = feesText1.getText().trim();
        uf18 = uff18;

        if(uf1.isEmpty()||uf2.isEmpty()||uf3.isEmpty()||uf4.isEmpty()||uf5.isEmpty()||uf6.isEmpty()||uf7.isEmpty()||uf8.isEmpty()||uf9.isEmpty()||uf10.isEmpty()||uf11.isEmpty()||uf12.isEmpty()||uf13.isEmpty()||uf14.isEmpty()||uf15.isEmpty()||uf16.isEmpty()||uf17.isEmpty()||uf18.isEmpty()){
            JOptionPane.showMessageDialog(this,"Some field is empty !","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            matcherAdmissionId = patternAdmissionId.matcher(uf1);
            if (!matcherAdmissionId.matches()) {
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Admission No only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(uf2.length()>30){ suFlag = 1; JOptionPane.showMessageDialog(this, "First name only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if (!(letterPattern.matcher(uf2).matches())){
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(uf3.length()>20){ suFlag = 1; JOptionPane.showMessageDialog(this, "Last name only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }

            if (!(letterPattern.matcher(uf3).matches())){
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcherRollNo = patternRollNo.matcher(uf4);
            if (!matcherRollNo.matches()) {
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Roll No only 1 to 3 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(uf6.length()>50){ suFlag = 1; JOptionPane.showMessageDialog(this, "Father name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }

            if (!(letterPattern.matcher(uf6).matches())){
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcherPhone = patternPhone.matcher(uf7);
            if (!matcherPhone.matches()) {
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(uf9.length()>50){ suFlag = 1; JOptionPane.showMessageDialog(this, "Mother name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if (!(letterPattern.matcher(uf9).matches())){
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Mother's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherPhone = patternPhone.matcher(uf10);
            if (!matcherPhone.matches()) {
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Mother Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFees = patternFees.matcher(uf17);
            if (!matcherFees.matches()) {
                suFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Fees only 2 to 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(uf12.length()>100){JOptionPane.showMessageDialog(this, "Address only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(suFlag==0){ updateStudentDate();}

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int flag5 = 0;
        sin = JOptionPane.showInputDialog(this,"Please Enter Admission No");
        sin = sin.trim();
        if(!sin.isEmpty()){
            try{    conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select admission_no from students_table");
                while (rs2.next()){
                    if(sin.equals(rs2.getString(1))){
                        flag5=1; break;
                    }
                }
                conn.close();
            }catch(SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);}
            if(flag5 == 1){
                try{
                    conn = DriverManager.getConnection(url,username,password);
                    stm2=conn.createStatement();
                    rs2= stm2.executeQuery("SELECT  *  FROM students_table WHERE admission_no="+sin+" ");
                    while(rs2.next()){
                        admissionText1.setText(rs2.getString(1));
                        sFirstNameText1.setText(rs2.getString(2));
                        sLastNameText1.setText(rs2.getString(3));
                        rollText1.setText(rs2.getString(4));
                        class3.setSelectedItem(rs2.getString(5));
                        sFatherText1.setText(rs2.getString(6));
                        sFatherContact1.setText(rs2.getString(7));
                        fatherOccupation1.setSelectedItem(rs2.getString(8));
                        sMotherText1.setText(rs2.getString(9));
                        sMotherContactText1.setText(rs2.getString(10));
                        motherOccupation1.setSelectedItem(rs2.getString(11));
                        sAddressText1.setText(rs2.getString(12));
                        fatherText1.setText(rs2.getString(6));

                        String radio = rs2.getString(13);
                        if(radio.equals("Male")){ sMale1.setSelected(true);}
                        else{ sFemale1.setSelected(true);}

                        caste1.setSelectedItem(rs2.getString(14));
                        String date = rs2.getString(15);
                        String date3 = rs2.getString(16);
                        try{
                            java.util.Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                            sdob1.setDate(date2);
                            java.util.Date date4 = new SimpleDateFormat("dd-MM-yyyy").parse(date3);
                            admissionDate1.setDate(date4);
                        }catch(ParseException dd){ }
                        feesText1.setText(rs2.getString(17));
                        studentStatus.setSelectedItem(rs2.getString(18));

                    }
                    conn.close();
                }catch(SQLException p){JOptionPane.showMessageDialog(this,p,"Error",JOptionPane.ERROR_MESSAGE);}

            }else{ JOptionPane.showMessageDialog(this,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
        }else{ JOptionPane.showMessageDialog(this,"Field is empty","Error",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void feesText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_feesText1FocusLost
        String check = feesText1.getText().trim();
        if(!check.isEmpty()){
            matcherFees = patternFees.matcher(check);
            if (!matcherFees.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Fees only 2 to 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_feesText1FocusLost

    private void sAddressText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sAddressText1FocusLost
        String check = sAddressText1.getText().trim();
        if(check.length()>100){JOptionPane.showMessageDialog(this, "Only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_sAddressText1FocusLost

    private void caste1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caste1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caste1ActionPerformed

    private void caste1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_caste1ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uff14  = (String) evt.getItem();
        }
    }//GEN-LAST:event_caste1ItemStateChanged

    private void sFemale1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sFemale1ItemStateChanged
        if(evt.getItemSelectable()==sFemale1){
            uff13 = "Female";
        }
    }//GEN-LAST:event_sFemale1ItemStateChanged

    private void sMale1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sMale1ItemStateChanged
        if(evt.getItemSelectable()==sMale1){
            uff13 = "Male";
        }
    }//GEN-LAST:event_sMale1ItemStateChanged

    private void motherOccupation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motherOccupation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motherOccupation1ActionPerformed

    private void motherOccupation1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_motherOccupation1ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uff11  = (String) evt.getItem();
        }
    }//GEN-LAST:event_motherOccupation1ItemStateChanged

    private void sMotherContactText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sMotherContactText1FocusLost
        String check = sMotherContactText1.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Mother Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sMotherContactText1FocusLost

    private void sMotherText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sMotherText1FocusLost
        String check = sMotherText1.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Mother's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sMotherText1FocusLost

    private void fatherOccupation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherOccupation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fatherOccupation1ActionPerformed

    private void fatherOccupation1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fatherOccupation1ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uff8  = (String) evt.getItem();
        }
    }//GEN-LAST:event_fatherOccupation1ItemStateChanged

    private void sFatherContact1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFatherContact1FocusLost
        String check = sFatherContact1.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Father Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFatherContact1FocusLost

    private void sFatherText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFatherText1FocusLost
        String check = sFatherText1.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Father's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFatherText1FocusLost

    private void rollText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rollText1FocusLost
        String check = rollText1.getText().trim();
        if(!check.isEmpty()){
            matcherRollNo = patternRollNo.matcher(check);
            if (!matcherRollNo.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Roll No only 1 to 3 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_rollText1FocusLost

    private void class3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_class3ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uff5  = (String) evt.getItem();
        }
    }//GEN-LAST:event_class3ItemStateChanged

    private void sLastNameText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sLastNameText1FocusLost
        String check = sLastNameText1.getText().trim();
        if(check.length()>20){JOptionPane.showMessageDialog(this, "Only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sLastNameText1FocusLost

    private void sFirstNameText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFirstNameText1FocusLost
        String check = sFirstNameText1.getText().trim();
        if(check.length()>30){JOptionPane.showMessageDialog(this, "Only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFirstNameText1FocusLost

    private void admissionText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admissionText1FocusLost
        // TODO add your handling code here:
        String check = admissionText1.getText().trim();
        if(!check.isEmpty()){
            matcherAdmissionId = patternAdmissionId.matcher(check);
            if (!matcherAdmissionId.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Admission No only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_admissionText1FocusLost

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        f1 = "";f2 = "";f3 = "";f4 = "";f5 = "";f6 = "";f7 = "";f8 = "";f9 = "";f10 = "";f11 = "";f12 = "";f13 = "";
        f14 = "";f15 = "";f16 = "";f17 = "";
        int sFlag =0;
        
        f1 = admissionText.getText().trim();
        f2 = sFirstNameText.getText().trim();
        f3 = sLastNameText.getText().trim();
        f4 = rollText.getText().trim();
        f5 = ff5;
        f6 = sFatherText.getText().trim();
        f7 = sFatherContact.getText().trim();
        f8 = ff8;

        f9 = sMotherText.getText().trim();
        f10 = sMotherContactText.getText().trim();
        f11 = ff11;
        f12 = sAddressText.getText().trim();
        f13 = ff13;
        f14 = ff14;
        f15 = ((JTextField)sdob.getDateEditor().getUiComponent()).getText().trim();
        f16 = ((JTextField)admissionDate.getDateEditor().getUiComponent()).getText().trim();
        f17 = feesText.getText().trim();

        if(f1.isEmpty()||f2.isEmpty()||f3.isEmpty()||f4.isEmpty()||f5.isEmpty()||f6.isEmpty()||f7.isEmpty()||f8.isEmpty()||f9.isEmpty()||f10.isEmpty()||f11.isEmpty()||f12.isEmpty()||f13.isEmpty()||f14.isEmpty()||f15.isEmpty()||f16.isEmpty()||f17.isEmpty()){
            JOptionPane.showMessageDialog(this,"Some field is empty !","Error",JOptionPane.ERROR_MESSAGE);
        }else{ 
            ////********Check duplicate Staff id ******///
            try{
                conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select admission_no from students_table");
                while (rs2.next())
                {
                    if(f1.equals(rs2.getString(1)))
                    {
                        sFlag=1;
                        JOptionPane.showMessageDialog(this,"Admission No already exists","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                conn.close();
            }catch(SQLException ep){JOptionPane.showMessageDialog(this,ep,"Error",JOptionPane.ERROR_MESSAGE);}

            ////////*********Check Admission form Validation **************/////
            matcherAdmissionId = patternAdmissionId.matcher(f1);
            if (!matcherAdmissionId.matches()) {
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Admission No only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(f2.length()>30){ sFlag = 1; JOptionPane.showMessageDialog(this, "First name only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if (!(letterPattern.matcher(f2).matches())){
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(f3.length()>20){ sFlag = 1; JOptionPane.showMessageDialog(this, "Last name only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }

            if (!(letterPattern.matcher(f3).matches())){
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcherRollNo = patternRollNo.matcher(f4);
            if (!matcherRollNo.matches()) {
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Roll No only 1 to 3 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(f6.length()>50){ sFlag = 1; JOptionPane.showMessageDialog(this, "Father name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }

            if (!(letterPattern.matcher(f6).matches())){
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcherPhone = patternPhone.matcher(f7);
            if (!matcherPhone.matches()) {
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(f9.length()>50){ sFlag = 1; JOptionPane.showMessageDialog(this, "Mother name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if (!(letterPattern.matcher(f9).matches())){
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Mother's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherPhone = patternPhone.matcher(f10);
            if (!matcherPhone.matches()) {
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Mother Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFees = patternFees.matcher(f17);
            if (!matcherFees.matches()) {
                sFlag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Fees only 2 to 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(f12.length()>100){JOptionPane.showMessageDialog(this, "Address only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(sFlag==0){ saveStudentData();}

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
            FileReader file6 = new FileReader("admissionid.dll");
            char data6[] =new  char[10];
            int charsread6 = file6.read(data6);
            String num2 = new String (data6,0,charsread6);
            file6.close();
            anid = 1+Integer.parseInt(num2);
            aid = String.valueOf(anid);
            admissionText.setText(aid);
        }catch(IOException | NumberFormatException f){}
        sdob.setCalendar(null);
        admissionDate.setCalendar(null);
        sLastNameText.setText("");
        sFirstNameText.setText("");
        rollText.setText("");
        class2.setSelectedIndex(0);
        sFatherText.setText("");
        sFatherContact.setText("");
        fatherOccupation.setSelectedIndex(0);
        sMotherText.setText("");
        sMotherContactText.setText("");
        motherOccupation.setSelectedIndex(0);
        sMale.setSelected(true);
        ff13 = "Male";
        sAddressText.setText("");
        caste.setSelectedIndex(0);

        feesText.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void feesTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_feesTextFocusLost
        String check = feesText.getText().trim();
        if(!check.isEmpty()){
            matcherFees = patternFees.matcher(check);
            if (!matcherFees.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Fees only 2 to 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_feesTextFocusLost

    private void sAddressTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sAddressTextFocusLost
        String check = sAddressText.getText().trim();
        if(check.length()>100){JOptionPane.showMessageDialog(this, "Only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_sAddressTextFocusLost

    private void casteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casteActionPerformed

    private void casteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_casteItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ff14  = (String) evt.getItem();
        }
    }//GEN-LAST:event_casteItemStateChanged

    private void sFemaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sFemaleItemStateChanged
        if(evt.getItemSelectable()==sFemale){
            ff13 = "Female";
        }
    }//GEN-LAST:event_sFemaleItemStateChanged

    private void sMaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sMaleItemStateChanged
        if(evt.getItemSelectable()==sMale){
            ff13 = "Male";
        }
    }//GEN-LAST:event_sMaleItemStateChanged

    private void motherOccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motherOccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motherOccupationActionPerformed

    private void motherOccupationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_motherOccupationItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ff11  = (String) evt.getItem();
        }
    }//GEN-LAST:event_motherOccupationItemStateChanged

    private void sMotherTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sMotherTextFocusLost
        String check = sMotherText.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Mother's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sMotherTextFocusLost

    private void sMotherContactTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sMotherContactTextFocusLost
        String check = sMotherContactText.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Mother Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sMotherContactTextFocusLost

    private void fatherOccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fatherOccupationActionPerformed

    }//GEN-LAST:event_fatherOccupationActionPerformed

    private void fatherOccupationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fatherOccupationItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ff8  = (String) evt.getItem();
        }
    }//GEN-LAST:event_fatherOccupationItemStateChanged

    private void sFatherContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFatherContactFocusLost
        String check = sFatherContact.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Father Contact No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFatherContactFocusLost

    private void sFatherTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFatherTextFocusLost
        String check = sFatherText.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Father's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFatherTextFocusLost

    private void class2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_class2ItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ff5  = (String) evt.getItem();
        }
    }//GEN-LAST:event_class2ItemStateChanged

    private void sLastNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sLastNameTextFocusLost
        String check = sLastNameText.getText().trim();
        if(check.length()>20){JOptionPane.showMessageDialog(this, "Only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sLastNameTextFocusLost

    private void rollTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rollTextFocusLost
        String check = rollText.getText().trim();
        if(!check.isEmpty()){
            matcherRollNo = patternRollNo.matcher(check);
            if (!matcherRollNo.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Roll No only 1 to 3 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_rollTextFocusLost

    private void sFirstNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sFirstNameTextFocusLost
        String check = sFirstNameText.getText().trim();
        if(check.length()>30){JOptionPane.showMessageDialog(this, "Only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_sFirstNameTextFocusLost

    private void admissionTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admissionTextFocusLost
        // TODO add your handling code here:
        String check = admissionText.getText().trim();
        if(!check.isEmpty()){
            matcherAdmissionId = patternAdmissionId.matcher(check);
            if (!matcherAdmissionId.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Admission No only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_admissionTextFocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int flag5 = 0;
        in = JOptionPane.showInputDialog(this,"Please Enter Staff ID");
        in = in.trim();
        if(!in.isEmpty()){
            try{    conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select staff_id from staff_table");
                while (rs2.next()){
                    if(in.equals(rs2.getString(1))){
                        flag5=1; break;
                    }
                }
                conn.close();
            }catch(SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);}
            if(flag5 == 1){
                try{
                    conn = DriverManager.getConnection(url,username,password);
                    stm2=conn.createStatement();
                    rs2= stm2.executeQuery("SELECT  *  FROM staff_table WHERE staff_id="+in+" ");
                    while(rs2.next()){
                        idText1.setText(rs2.getString(1));
                        fNameText1.setText(rs2.getString(2));
                        lNameText1.setText(rs2.getString(3));
                        String date = rs2.getString(4);
                        String date3 = rs2.getString(12);
                        try{
                            java.util.Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
                            dobText1.setDate(date2);
                            java.util.Date date4 = new SimpleDateFormat("dd-MM-yyyy").parse(date3);
                            joiningText1.setDate(date4);
                        }catch(ParseException dd){ }
                        phoneText1.setText(rs2.getString(5));
                        fatherText1.setText(rs2.getString(6));
                        String radio = rs2.getString(7);
                        if(radio.equals("Male")){ male1.setSelected(true);}
                        else{ female1.setSelected(true);}
                        emailText1.setText(rs2.getString(8));
                        qualification1.setSelectedItem(rs2.getString(9));
                        designation1.setSelectedItem(rs2.getString(10));
                        salaryText1.setText(rs2.getString(11));
                        addressText1.setText(rs2.getString(13));
                        status.setSelectedItem(rs2.getString(14));

                    }
                    conn.close();
                }catch(SQLException p){JOptionPane.showMessageDialog(this,p,"Error",JOptionPane.ERROR_MESSAGE);}

            }else{ JOptionPane.showMessageDialog(this,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
        }else{ JOptionPane.showMessageDialog(this,"Field is empty","Error",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uss11  = (String) evt.getItem();
        }
    }//GEN-LAST:event_statusItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dobText1.setCalendar(null);
        joiningText1.setCalendar(null);
        idText1.setText("");
        fNameText1.setText("");
        lNameText1.setText("");
        phoneText1.setText("");
        fatherText1.setText("");
        male1.setSelected(true);
        uss7 = "Male";
        emailText1.setText("");
        qualification1.setSelectedIndex(0);
        designation1.setSelectedIndex(0);
        salaryText1.setText("");
        addressText1.setText("");
        status.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        us1 = "";us2 = "";us3 = "";us4 = "";us5 = "";us6 = "";us7 = "";us8 = "";us9 = "";us10 = "";us11 = "";us12 = "";us13 = "";us14 = "";
        int flag2 =0;
        int flag9 = 0;
        
        us1 = idText1.getText().trim();
        us2 = fNameText1.getText().trim();
        us3 = lNameText1.getText().trim();
        us4 = ((JTextField)dobText1.getDateEditor().getUiComponent()).getText().trim();
        us5 = phoneText1.getText().trim();
        us6 = fatherText1.getText().trim();
        us7 = uss7;
        us8 = emailText1.getText().trim();
        us9 = uss9;
        us10 = uss10;
        us11 = salaryText1.getText().trim();
        us12 = ((JTextField)joiningText1.getDateEditor().getUiComponent()).getText().trim();
        us13 = addressText1.getText().trim();
        us14 = uss11;

        if(us1.isEmpty()||us2.isEmpty()||us3.isEmpty()||us4 == "null"||us5.isEmpty()||us6.isEmpty()||us7.isEmpty()||us8.isEmpty()||us9.isEmpty()||us10.isEmpty()||us11.isEmpty()||us12 == "null"||us13.isEmpty()||us14.isEmpty()){
            JOptionPane.showMessageDialog(this,"Some field is empty !","Error",JOptionPane.ERROR_MESSAGE);
        }else{                  //////******** check Textfields validation ******/////
            if(us2.length()>30){ flag9 = 1; JOptionPane.showMessageDialog(this, "First name only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(us3.length()>20){ flag9 = 1; JOptionPane.showMessageDialog(this, "Last name only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(us6.length()>50){ flag9 = 1; JOptionPane.showMessageDialog(this, "Father's name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(us8.length()>50){ flag9 = 1; JOptionPane.showMessageDialog(this, "E-mail only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(us13.length()>100){flag9 = 1;JOptionPane.showMessageDialog(this, "Address only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            matcherId = patternId.matcher(us1);
            if (!matcherId.matches()) {
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid Staff id only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!(letterPattern.matcher(us2).matches())){
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!(letterPattern.matcher(us3).matches())){
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherPhone = patternPhone.matcher(us5);
            if (!matcherPhone.matches()) {
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid Phone No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (!(letterPattern.matcher(us6).matches())){
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father's & Husband's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcher = pattern.matcher(us8);
            if(!matcher.matches()){
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid E-mail ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherSalary = patternSalary.matcher(us11);
            if (!matcherSalary.matches()) {
                flag9 = 1;
                JOptionPane.showMessageDialog(this, "Invalid Salary only 4 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(flag9==0){ updateStaffData();  }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addressText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressText1FocusLost
        // TODO add your handling code here:
        String check = addressText1.getText().trim();
        if(check.length()>100){JOptionPane.showMessageDialog(this, "Only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_addressText1FocusLost

    private void salaryText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salaryText1FocusLost
        // TODO add your handling code here:
        String check = salaryText1.getText().trim();
        if(!check.isEmpty()){
            matcherSalary = patternSalary.matcher(check);
            if (!matcherSalary.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Salary only 4 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_salaryText1FocusLost

    private void designation1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_designation1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uss10 = (String) evt.getItem();
        }
    }//GEN-LAST:event_designation1ItemStateChanged

    private void qualification1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_qualification1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            uss9  = (String) evt.getItem();
        }
    }//GEN-LAST:event_qualification1ItemStateChanged

    private void emailText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailText1FocusLost
        // TODO add your handling code here:
        String check = emailText1.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            matcher = pattern.matcher(check);
            if(!matcher.matches()){
                JOptionPane.showMessageDialog(this, "Invalid E-mail ID", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_emailText1FocusLost

    private void female1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_female1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getItemSelectable()==female1){
            uss7 = "Female";
        }
    }//GEN-LAST:event_female1ItemStateChanged

    private void male1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_male1ItemStateChanged
        // TODO add your handling code here:
        if(evt.getItemSelectable()==male1){
            uss7 = "Male";

        }
    }//GEN-LAST:event_male1ItemStateChanged

    private void fatherText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fatherText1FocusLost
        // TODO add your handling code here:
        String check = fatherText1.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Father's & Husband's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_fatherText1FocusLost

    private void phoneText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneText1FocusLost
        // TODO add your handling code here:
        String check = phoneText1.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Phone No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_phoneText1FocusLost

    private void lNameText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lNameText1FocusLost
        // TODO add your handling code here:
        String check = lNameText1.getText().trim();
        if(check.length()>20){JOptionPane.showMessageDialog(this, "Only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_lNameText1FocusLost

    private void fNameText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameText1FocusLost
        // TODO add your handling code here:
        String check = fNameText1.getText().trim();
        if(check.length()>30){JOptionPane.showMessageDialog(this, "Only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_fNameText1FocusLost

    private void idText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idText1FocusLost
        // TODO add your handling code here:
        String check = idText1.getText().trim();
        if(!check.isEmpty()){
            matcherId = patternId.matcher(check);
            if (!matcherId.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Staff id only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_idText1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //idText.setText("");
        try{
            FileReader file5 = new FileReader("uniqueId.dll");
            char data5[] =new  char[10];
            int charsread5 = file5.read(data5);
            String num = new String (data5,0,charsread5);
            file5.close();
            nid = 1+Integer.parseInt(num);
            id = String.valueOf(nid);
            idText.setText(id);
        }catch(IOException | NumberFormatException e){ }

        fNameText.setText("");
        lNameText.setText("");

        dobText.setCalendar(null);
        joiningText.setCalendar(null);
        phoneText.setText("");
        fatherText.setText("");
        male.setSelected(true);
        ss7 = "Male";
        emailText.setText("");
        qualification.setSelectedIndex(0);
        designation.setSelectedIndex(0);
        salaryText.setText("");
        addressText.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        s1 = "";s2 = "";s3 = "";s4 = "";s5 = "";s6 = "";s7 = "";s8 = "";s9 = "";s10 = "";s11 = "";s12 = "";s13 = "";
        int flag =0;
        
        s1 = idText.getText().trim();
        s2 = fNameText.getText().trim();
        s3 = lNameText.getText().trim();
        s4 = ((JTextField)dobText.getDateEditor().getUiComponent()).getText().trim();
        s5 = phoneText.getText().trim();
        s6 = fatherText.getText().trim();
        s7 = ss7;
        s8 = emailText.getText().trim();
        s9 = ss9;
        s10 = ss10;
        s11 = salaryText.getText().trim();
        s12 = ((JTextField)joiningText.getDateEditor().getUiComponent()).getText().trim();
        s13 = addressText.getText().trim();

        if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty()||s11.isEmpty()||s12.isEmpty()||s13.isEmpty()){
            JOptionPane.showMessageDialog(this,"Some field is empty !","Error",JOptionPane.ERROR_MESSAGE);
        }else{ 
            ////********Check duplicate Staff id ******///
            try{
                conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select staff_id from staff_table");
                while (rs2.next())
                {
                    if(s1.equals(rs2.getString(1)))
                    {
                        flag=1;
                        JOptionPane.showMessageDialog(this,"Staff id already exists","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                conn.close();
            }catch(SQLException ep){JOptionPane.showMessageDialog(this,ep,"Error",JOptionPane.ERROR_MESSAGE);}

            //////******** check Textfields validation ******/////
            if(s2.length()>30){ flag = 1; JOptionPane.showMessageDialog(this, "First name only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(s3.length()>20){ flag = 1; JOptionPane.showMessageDialog(this, "Last name only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(s6.length()>50){ flag = 1; JOptionPane.showMessageDialog(this, "Father's name only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(s8.length()>50){ flag = 1; JOptionPane.showMessageDialog(this, "E-mail only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            if(s13.length()>100){flag = 1;JOptionPane.showMessageDialog(this, "Address only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
            matcherId = patternId.matcher(s1);
            if (!matcherId.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Staff id only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!(letterPattern.matcher(s2).matches())){
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!(letterPattern.matcher(s3).matches())){
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherPhone = patternPhone.matcher(s5);
            if (!matcherPhone.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Phone No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if (!(letterPattern.matcher(s6).matches())){
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Father's & Husband's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }

            matcher = pattern.matcher(s8);
            if(!matcher.matches()){
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid E-mail ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherSalary = patternSalary.matcher(s11);
            if (!matcherSalary.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Salary only 4 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(flag==0){ saveData(); }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addressTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressTextFocusLost
        // TODO add your handling code here:
        String check = addressText.getText().trim();
        if(check.length()>100){JOptionPane.showMessageDialog(this, "Only 100 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
    }//GEN-LAST:event_addressTextFocusLost

    private void salaryTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salaryTextFocusLost
        // TODO add your handling code here:
        String check = salaryText.getText().trim();
        if(!check.isEmpty()){
            matcherSalary = patternSalary.matcher(check);
            if (!matcherSalary.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Salary only 4 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_salaryTextFocusLost

    private void designationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_designationItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ss10 = (String) evt.getItem();
        }
    }//GEN-LAST:event_designationItemStateChanged

    private void qualificationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_qualificationItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            ss9  = (String) evt.getItem();
        }
    }//GEN-LAST:event_qualificationItemStateChanged

    private void emailTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFocusLost
        // TODO add your handling code here:
        String check = emailText.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            matcher = pattern.matcher(check);
            if(!matcher.matches()){
                JOptionPane.showMessageDialog(this, "Invalid E-mail ID", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_emailTextFocusLost

    private void phoneTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneTextFocusLost
        // TODO add your handling code here:
        String check = phoneText.getText().trim();
        if(!check.isEmpty()){
            matcherPhone = patternPhone.matcher(check);
            if (!matcherPhone.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Phone No only 6 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_phoneTextFocusLost

    private void femaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_femaleItemStateChanged
        // TODO add your handling code here:
        if(evt.getItemSelectable()==female){
            ss7 = "Female";
        }
    }//GEN-LAST:event_femaleItemStateChanged

    private void maleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_maleItemStateChanged
        // TODO add your handling code here:
        if(evt.getItemSelectable()==male){
            ss7 = "Male";
        }
    }//GEN-LAST:event_maleItemStateChanged

    private void fatherTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fatherTextFocusLost
        // TODO add your handling code here:
        String check = fatherText.getText().trim();
        if(check.length()>50){JOptionPane.showMessageDialog(this, "Only 50 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Father's & Husband's Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_fatherTextFocusLost

    private void lNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lNameTextFocusLost
        // TODO add your handling code here:
        String check = lNameText.getText().trim();
        if(check.length()>20){JOptionPane.showMessageDialog(this, "Only 20 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid Last Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_lNameTextFocusLost

    private void fNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fNameTextFocusLost
        // TODO add your handling code here:

        String check = fNameText.getText().trim();
        if(check.length()>30){JOptionPane.showMessageDialog(this, "Only 30 characters allowed", "Error", JOptionPane.ERROR_MESSAGE); }
        if(!check.isEmpty()){
            if (!(letterPattern.matcher(check).matches())){
                JOptionPane.showMessageDialog(this, "Invalid First Name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_fNameTextFocusLost

    private void idTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idTextFocusLost
        // TODO add your handling code here:
        String check = idText.getText().trim();
        if(!check.isEmpty()){
            matcherId = patternId.matcher(check);
            if (!matcherId.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Staff id only 4 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_idTextFocusLost

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        StaffTable staffTable =  new StaffTable();
        staffTable.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        StudentTable studentTable  = new StudentTable();
        studentTable.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniMouseClicked
         setState(ICONIFIED);
    }//GEN-LAST:event_miniMouseClicked

    private void xMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseClicked
       System.exit(0);
    }//GEN-LAST:event_xMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        xx=0;
        yy=0;
        xx=evt.getX();
       yy=evt.getY();  
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
       this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        xx=evt.getX();
       yy=evt.getY();  
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jTabbedPane2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseDragged
         int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
       this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jTabbedPane2MouseDragged

    private void xMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseEntered
        x.setForeground(Color.red);
    }//GEN-LAST:event_xMouseEntered

    private void xMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xMouseExited
       x.setForeground(Color.black);
    }//GEN-LAST:event_xMouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        PrintStaff printStaff = new PrintStaff();
        printStaff.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        PrintStudent printStudent = new PrintStudent();
        printStudent.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        PrintStudentTable printst = new PrintStudentTable();
       printst.setVisible(true); 
       
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        PrintStaffTable printStaffTable = new PrintStaffTable();
        printStaffTable.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_LogoutActionPerformed

    private void feeClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeClassActionPerformed

    private void feeAdmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeAdmissionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeAdmissionActionPerformed

    private void feeRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeRollActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeRollActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       fees1 = "";fees2 = "";fees3 = "";fees4 = "";fees5 = "";fees6 = "";fees7 = "";fees8 = "";fees9 = "0";fees10 = "0";fees11 = "0";fees12 = "0";fees13 = "";
        int flag = 0;
        fees1 = sNText.getText().trim();
        fees2 = feeStudent.getText().trim();
        fees3 = feeClass.getText();
        fees4 = feeFather.getText();
        fees5 = feeRoll.getText();
        fees6 = feeAdmission.getText();
        fees7 = ((JTextField)feeDate.getDateEditor().getUiComponent()).getText().trim();
        fees8 = tuitionFee.getText().trim();
        fees9 = lateFee.getText().trim();
        fees10 = annualFee.getText().trim();
        fees11 = otherFee.getText().trim();
        fees12 = admissionFee.getText().trim();
        fees13 = totalFee.getText().trim();
        if(fees1.isEmpty()||fees2.isEmpty()||fees3.isEmpty()||fees4.isEmpty()||fees5.isEmpty()||fees6.isEmpty()||fees7.isEmpty()||fees8.isEmpty()||fees13.isEmpty()){
                JOptionPane.showMessageDialog(this,"Some textfield is empty","Error",JOptionPane.ERROR_MESSAGE);
       }else{
            if(fees13.equals("0")){
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid total fee 0 ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee1 = patternFee1.matcher(fees1);
            if (!matcherFee1.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid S.No only 1 to 10 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee2 = patternFee2.matcher(fees8);
            if (!matcherFee2.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Tuition fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee3 = patternFee3.matcher(fees9);
            if (!matcherFee3.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Late fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee4 = patternFee4.matcher(fees10);
            if (!matcherFee4.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Annual Charge only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee5 = patternFee5.matcher(fees11);
            if (!matcherFee5.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Other Charge only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee6 = patternFee6.matcher(fees12);
            if (!matcherFee6.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Admission fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
            matcherFee7 = patternFee7.matcher(fees13);
            if (!matcherFee7.matches()) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Total only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
            }
           
            if(flag == 0){
            try{
		String query2 = "CREATE TABLE "+ monthYear+" (s_no VARCHAR(10), name VARCHAR(50), class2 VARCHAR(8), father_name VARCHAR(50), roll_no VARCHAR(4), admission_no VARCHAR(10), date2 VARCHAR(12), tuition_fee VARCHAR(8), late_fee VARCHAR(8), annual_fee VARCHAR(8), other_fee VARCHAR(8), admission_fee VARCHAR(8), total VARCHAR(8) , PRIMARY KEY (admission_no))";
		Class.forName("com.mysql.cj.jdbc.Driver");
        	conpaid =DriverManager.getConnection(url,username,password);	
      		preparedStmt = conpaid.prepareStatement(query2);
      		preparedStmt.execute();
		conpaid.close();
		insertData();
		}catch(Exception e){  insertData(); }
            
            }
            }      
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        int flag5 = 0;
        fin = JOptionPane.showInputDialog(this,"Please Enter Admission No");
        fin = fin.trim();
        if(!fin.isEmpty()){
            try{    conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select admission_no from students_table");
                while (rs2.next()){
                    if(fin.equals(rs2.getString(1))){
                        flag5=1; break;
                    }
                }
                conn.close();
            }catch(SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE);}
            if(flag5 == 1){
                try{
                    conn = DriverManager.getConnection(url,username,password);
                    stm2=conn.createStatement();
                    rs2= stm2.executeQuery("SELECT  *  FROM students_table WHERE admission_no="+fin+" ");
                    while(rs2.next()){
                        feeAdmission.setText(rs2.getString(1));
                        String fullN = rs2.getString(2)+ " "+rs2.getString(3);
                        feeStudent.setText(fullN);
                        feeRoll.setText(rs2.getString(4));
                        feeClass.setText(rs2.getString(5));
                        feeFather.setText(rs2.getString(6));
                        }
                    conn.close();
                }catch(SQLException p){JOptionPane.showMessageDialog(this,p,"Error",JOptionPane.ERROR_MESSAGE);}

            }else{ JOptionPane.showMessageDialog(this,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
        }else{ JOptionPane.showMessageDialog(this,"Field is empty","Error",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       
        try{
            FileReader file7 = new FileReader("fees.dll");
            char data7[] =new  char[10];
            int charsread7 = file7.read(data7);
            String num7 = new String (data7,0,charsread7);
            file7.close();
            fnid = 1+Integer.parseInt(num7);
            fid = String.valueOf(fnid);
        }catch(IOException | NumberFormatException e){ }
        sNText.setText(fid);
       feeStudent.setText("");
       feeClass.setText("");
       feeFather.setText("");
       feeRoll.setText("");
       feeAdmission.setText("");
       feeDate.setCalendar(null);
       tuitionFee.setText("0");
       lateFee.setText("0");
       annualFee.setText("0");
       otherFee.setText("0");
       admissionFee.setText("0");
       totalFee.setText("0");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void tuitionFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tuitionFeeKeyReleased
        String k1 = tuitionFee.getText().trim();
        
    
        if(!k1.isEmpty()){
            matcherFee2 = patternFee2.matcher(k1);
            if (!matcherFee2.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Tuition fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                tuitionFee.setText("0");
            }else{ int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
            
            }
        }
    }//GEN-LAST:event_tuitionFeeKeyReleased

    private void lateFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lateFeeKeyReleased
        String k1 = lateFee.getText().trim();
     
    
        if(!k1.isEmpty()){
            matcherFee2 = patternFee2.matcher(k1);
            if (!matcherFee2.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Late fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                lateFee.setText("0");
            }else{ int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
            
            }
        }
    }//GEN-LAST:event_lateFeeKeyReleased

    private void annualFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_annualFeeKeyReleased
         String k1 = annualFee.getText().trim();

    
        if(!k1.isEmpty()){
            matcherFee2 = patternFee2.matcher(k1);
            if (!matcherFee2.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Annual fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                annualFee.setText("0");
            }else{ int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
            
            }
        }
    }//GEN-LAST:event_annualFeeKeyReleased

    private void otherFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otherFeeKeyReleased
        String k1 = otherFee.getText().trim();
        
    
        if(!k1.isEmpty()){
            matcherFee2 = patternFee2.matcher(k1);
            if (!matcherFee2.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Other fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                otherFee.setText("0");
            }else{ int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
            
            }
        }
    }//GEN-LAST:event_otherFeeKeyReleased

    private void admissionFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admissionFeeKeyReleased
         String k1 = admissionFee.getText().trim();
         
    
        if(!k1.isEmpty()){
            matcherFee2 = patternFee2.matcher(k1);
            if (!matcherFee2.matches()) {
                JOptionPane.showMessageDialog(this, "Invalid Admission fee only 1 to 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                admissionFee.setText("0");
            }else{ int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
            
            }
        }
    }//GEN-LAST:event_admissionFeeKeyReleased

    private void admissionFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_admissionFeeFocusLost
        String k1 = admissionFee.getText().trim();
         if(k1.isEmpty()){
            admissionFee.setText("0");
            int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
        }
    }//GEN-LAST:event_admissionFeeFocusLost

    private void otherFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherFeeFocusLost
        String k1 = otherFee.getText().trim();
         if(k1.isEmpty()){
            otherFee.setText("0");
            int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
        }
    }//GEN-LAST:event_otherFeeFocusLost

    private void annualFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_annualFeeFocusLost
         String k1 = annualFee.getText().trim();
         if(k1.isEmpty()){
            annualFee.setText("0");
            int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
        }
    }//GEN-LAST:event_annualFeeFocusLost

    private void lateFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lateFeeFocusLost
        String k1 = lateFee.getText().trim();
        if(k1.isEmpty()){
            lateFee.setText("0");
            int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
        }
    }//GEN-LAST:event_lateFeeFocusLost

    private void tuitionFeeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tuitionFeeFocusLost
        String k1 = tuitionFee.getText().trim();
         if(k1.isEmpty()){
            tuitionFee.setText("0");
            int i = Integer.parseInt(tuitionFee.getText().trim());
                   int i2 = Integer.parseInt(lateFee.getText().trim()); 
                   int i3 = Integer.parseInt(annualFee.getText().trim());
                   int i4 = Integer.parseInt(otherFee.getText().trim());
                   int i5 = Integer.parseInt(admissionFee.getText().trim());
                   int t = i+i2+i3+i4+i5;
                   String to = String.valueOf(t);
                   totalFee.setText(to);
        }
    }//GEN-LAST:event_tuitionFeeFocusLost

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        PrintPaid printPaid = new PrintPaid();
        printPaid.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        PaidTable paidTable = new PaidTable();
        paidTable.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
         UnpaidTable unpaidTable = new UnpaidTable();
        unpaidTable.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void newMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_newMonthItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            newMonths1  = (String) evt.getItem();
        }
    }//GEN-LAST:event_newMonthItemStateChanged

    private void newYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_newYearItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            newYears2  = (String) evt.getItem();
        }
    }//GEN-LAST:event_newYearItemStateChanged

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        ShowTable  showTable = new ShowTable(newMonths1+newYears2);
        showTable.setVisible(true);
    }//GEN-LAST:event_jButton23ActionPerformed
   
     public void insertData(){
	
		try        {
                   Class.forName("com.mysql.cj.jdbc.Driver");
                    conpaid =DriverManager.getConnection("jdbc:mysql://localhost:3306/navyug_database?useSSL=false",username,password);
                    stm =  conpaid.prepareStatement("insert into  "+ monthYear+" values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    stm.setString(1,fees1);
                    stm.setString(2,fees2);
                    stm.setString(3,fees3);	
                    stm.setString(4,fees4);
                    stm.setString(5,fees5);
                    stm.setString(6,fees6);
                    stm.setString(7,fees7);
                    stm.setString(8,fees8);
                    stm.setString(9,fees9);	
                    stm.setString(10,fees10);
                    stm.setString(11,fees11);
                    stm.setString(12,fees12);
                    stm.setString(13,fees13);
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Fees submited successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    try{
                    FileWriter fileadmin = new FileWriter("fees.dll");
                    fileadmin.write(fees1);
                    fileadmin.close();
                    
                    FileReader file55 = new FileReader("fees.dll");
                    char data55[] =new  char[10];
                    int charsread55 = file55.read(data55);
                    String num7 = new String (data55,0,charsread55);
                    file55.close();
                    fnid = 1+Integer.parseInt(num7);
                    fid = String.valueOf(fnid);
                    sNText.setText(fid);
                    }catch(IOException f){  }
                    
                   feeStudent.setText("");
                   feeClass.setText("");
                   feeFather.setText("");
                   feeRoll.setText("");
                   feeAdmission.setText("");
                   feeDate.setCalendar(null);
                   tuitionFee.setText("0");
                   lateFee.setText("0");
                   annualFee.setText("0");
                   otherFee.setText("0");
                   admissionFee.setText("0");
                   totalFee.setText("0");
                    conpaid.close();

                    }
            catch(ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }    
    
     }
    
    private void saveData(){
         try        {
                   
                    conn = DriverManager.getConnection(url,username,password);
                    stm =  conn.prepareStatement("insert into staff_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    stm.setString(1,s1);
                    stm.setString(2,s2);
                    stm.setString(3,s3);	
                    stm.setString(4,s4);
                    stm.setString(5,s5);
                    stm.setString(6,s6);
                    stm.setString(7,s7);
                    stm.setString(8,s8);
                    stm.setString(9,s9);	
                    stm.setString(10,s10);
                    stm.setString(11,s11);
                    stm.setString(12,s12);
                    stm.setString(13,s13);
                    stm.setString(14,"Active");
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Data Saved successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    ///********File read or write*******////
                    try{
                    FileWriter file3 = new FileWriter("uniqueId.dll");
                    file3.write(s1);
                    file3.close();
                    
                    FileReader file5 = new FileReader("uniqueId.dll");
                    char data5[] =new  char[10];
                    int charsread5 = file5.read(data5);
                    String num = new String (data5,0,charsread5);
                    file5.close();
                    nid = 1+Integer.parseInt(num);
                    id = String.valueOf(nid);
                    idText.setText(id);
                    }catch(IOException f){  }
                    
                    dobText.setCalendar(null);
                    joiningText.setCalendar(null);
                    fNameText.setText("");
                    lNameText.setText("");
                    phoneText.setText("");
                    fatherText.setText("");
                    male.setSelected(true);
                    ss7 = "Male";
                    emailText.setText("");
                    qualification.setSelectedIndex(0);
                    designation.setSelectedIndex(0);
                    salaryText.setText("");
                    addressText.setText("");
                    conn.close();

                    }
            catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }
        
        
    }
    
    private void updateStaffData(){
            try{ conn = DriverManager.getConnection(url,username,password);
                PreparedStatement ps = conn.prepareStatement("UPDATE staff_table SET staff_id = ?,first_name = ?, last_name = ?, dob1 = ?, phone_no = ?, father_name = ?, gender = ? , email_id = ? ,qualification = ?, designation = ?, salary = ?, joining_date = ? , address = ?, status = ? WHERE staff_id = "+us1+" ");

                // set the preparedstatement parameters
                ps.setString(1,us1);
                ps.setString(2,us2);
                ps.setString(3,us3);
                ps.setString(4,us4);
                ps.setString(5,us5);
                ps.setString(6,us6);
                ps.setString(7,us7);
                ps.setString(8,us8);
                ps.setString(9,us9);
                ps.setString(10,us10);
                ps.setString(11,us11);
                ps.setString(12,us12);
                ps.setString(13,us13);
                ps.setString(14,us14);
                // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Data Updated successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                ps.close();
           
                conn.close();
                dobText1.setCalendar(null);
                joiningText1.setCalendar(null);
                idText1.setText("");
                fNameText1.setText("");
                lNameText1.setText("");
                phoneText1.setText("");
                fatherText1.setText("");
                male1.setSelected(true);
                uss7 = "Male";
                emailText1.setText("");
                qualification1.setSelectedIndex(0);
                designation1.setSelectedIndex(0);
                salaryText1.setText("");
                addressText1.setText("");
                status.setSelectedIndex(0);
              }
              catch (SQLException se){JOptionPane.showMessageDialog(this,se,"Error",JOptionPane.ERROR_MESSAGE);}
    
    }
    
    private void saveStudentData(){
            try        {
                   
                    conn = DriverManager.getConnection(url,username,password);
                    stm =  conn.prepareStatement("insert into students_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    stm.setString(1,f1);
                    stm.setString(2,f2);
                    stm.setString(3,f3);	
                    stm.setString(4,f4);
                    stm.setString(5,f5);
                    stm.setString(6,f6);
                    stm.setString(7,f7);
                    stm.setString(8,f8);
                    stm.setString(9,f9);	
                    stm.setString(10,f10);
                    stm.setString(11,f11);
                    stm.setString(12,f12);
                    stm.setString(13,f13);
                    stm.setString(14,f14);
                    
                    stm.setString(15,f15);
                    stm.setString(16,f16);
                    stm.setString(17,f17);
                    stm.setString(18,"Active");
                    
                    stm.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Data Saved successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    ///********File read or write*******////
                    try{
                    FileWriter fileadmin = new FileWriter("admissionid.dll");
                    fileadmin.write(f1);
                    fileadmin.close();
                    
                    FileReader file55 = new FileReader("admissionid.dll");
                    char data55[] =new  char[10];
                    int charsread55 = file55.read(data55);
                    String num = new String (data55,0,charsread55);
                    file55.close();
                    anid = 1+Integer.parseInt(num);
                    aid = String.valueOf(anid);
                    admissionText.setText(aid);
                    }catch(IOException f){  }
                    sdob.setCalendar(null);
                    admissionDate.setCalendar(null);
                    sLastNameText.setText("");
                    sFirstNameText.setText("");
                    rollText.setText("");
                    class2.setSelectedIndex(0);
                    sFatherText.setText("");
                    sFatherContact.setText("");
                    fatherOccupation.setSelectedIndex(0);
                    sMotherText.setText("");
                    sMotherContactText.setText("");
                    motherOccupation.setSelectedIndex(0);
                    sMale.setSelected(true);
                    ff13 = "Male";
                    sAddressText.setText("");
                    caste.setSelectedIndex(0);

                    feesText.setText("");
                    
                    conn.close();

                    }
            catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }
    
    }
    
    private void updateStudentDate(){
            
             try{ conn = DriverManager.getConnection(url,username,password);
                PreparedStatement ps = conn.prepareStatement("UPDATE students_table SET admission_no = ?,first_name = ?, last_name = ?, roll_no = ?, class2 = ?, father_name = ?, father_no = ? , father_occupation = ? ,mother_name = ?, mother_no = ?, mother_occupation = ?, address = ? , gender = ?, caste = ? , dob = ? , admission_date = ? , fees = ? , status = ? WHERE admission_no = "+uf1+" ");
                    ps.setString(1,uf1);
                    ps.setString(2,uf2);
                    ps.setString(3,uf3);	
                    ps.setString(4,uf4);
                    ps.setString(5,uf5);
                    ps.setString(6,uf6);
                    ps.setString(7,uf7);
                    ps.setString(8,uf8);
                    ps.setString(9,uf9);	
                    ps.setString(10,uf10);
                    ps.setString(11,uf11);
                    ps.setString(12,uf12);
                    ps.setString(13,uf13);
                    ps.setString(14,uf14);
                    
                    ps.setString(15,uf15);
                    ps.setString(16,uf16);
                    ps.setString(17,uf17);
                    ps.setString(18,uf18);
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Data Updeted successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    
                    admissionText1.setText("");
                    sdob1.setCalendar(null);
                    admissionDate1.setCalendar(null);
                    sLastNameText1.setText("");
                    sFirstNameText1.setText("");
                    rollText1.setText("");
                    class3.setSelectedIndex(0);
                    sFatherText1.setText("");
                    sFatherContact1.setText("");
                    fatherOccupation1.setSelectedIndex(0);
                    sMotherText1.setText("");
                    sMotherContactText1.setText("");
                    motherOccupation1.setSelectedIndex(0);
                    sMale1.setSelected(true);
                    uff13 = "Male";
                    sAddressText1.setText("");
                    caste1.setSelectedIndex(0);
                    studentStatus.setSelectedIndex(0);

                    feesText1.setText("");
                    conn.close();

                
              }
              catch (SQLException se){JOptionPane.showMessageDialog(this,se,"Error",JOptionPane.ERROR_MESSAGE);}
    
    }
    
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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JTextArea addressText;
    private javax.swing.JTextArea addressText1;
    private com.toedter.calendar.JDateChooser admissionDate;
    private com.toedter.calendar.JDateChooser admissionDate1;
    private javax.swing.JTextField admissionFee;
    private javax.swing.JTextField admissionText;
    private javax.swing.JTextField admissionText1;
    private javax.swing.JTextField annualFee;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> caste;
    private javax.swing.JComboBox<String> caste1;
    private javax.swing.JComboBox<String> class2;
    private javax.swing.JComboBox<String> class3;
    private javax.swing.JComboBox<String> designation;
    private javax.swing.JComboBox<String> designation1;
    private com.toedter.calendar.JDateChooser dobText;
    private com.toedter.calendar.JDateChooser dobText1;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField emailText1;
    private javax.swing.JTextField fNameText;
    private javax.swing.JTextField fNameText1;
    private javax.swing.JComboBox<String> fatherOccupation;
    private javax.swing.JComboBox<String> fatherOccupation1;
    private javax.swing.JTextField fatherText;
    private javax.swing.JTextField fatherText1;
    private javax.swing.JTextField feeAdmission;
    private javax.swing.JTextField feeClass;
    private com.toedter.calendar.JDateChooser feeDate;
    private javax.swing.JTextField feeFather;
    private javax.swing.JTextField feeRoll;
    private javax.swing.JTextField feeStudent;
    private javax.swing.JTextField feesText;
    private javax.swing.JTextField feesText1;
    private javax.swing.JRadioButton female;
    private javax.swing.JRadioButton female1;
    private javax.swing.JTextField idText;
    private javax.swing.JTextField idText1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane6;
    private com.toedter.calendar.JDateChooser joiningText;
    private com.toedter.calendar.JDateChooser joiningText1;
    private javax.swing.JTextField lNameText;
    private javax.swing.JTextField lNameText1;
    private javax.swing.JTextField lateFee;
    private javax.swing.JRadioButton male;
    private javax.swing.JRadioButton male1;
    private javax.swing.JLabel mini;
    private javax.swing.JComboBox<String> motherOccupation;
    private javax.swing.JComboBox<String> motherOccupation1;
    private javax.swing.JComboBox<String> newMonth;
    private javax.swing.JComboBox<String> newYear;
    private javax.swing.JTextField otherFee;
    private javax.swing.JTextField phoneText;
    private javax.swing.JTextField phoneText1;
    private javax.swing.JComboBox<String> qualification;
    private javax.swing.JComboBox<String> qualification1;
    private javax.swing.JTextField rollText;
    private javax.swing.JTextField rollText1;
    private javax.swing.JTextArea sAddressText;
    private javax.swing.JTextArea sAddressText1;
    private javax.swing.JTextField sFatherContact;
    private javax.swing.JTextField sFatherContact1;
    private javax.swing.JTextField sFatherText;
    private javax.swing.JTextField sFatherText1;
    private javax.swing.JRadioButton sFemale;
    private javax.swing.JRadioButton sFemale1;
    private javax.swing.JTextField sFirstNameText;
    private javax.swing.JTextField sFirstNameText1;
    private javax.swing.JTextField sLastNameText;
    private javax.swing.JTextField sLastNameText1;
    private javax.swing.JRadioButton sMale;
    private javax.swing.JRadioButton sMale1;
    private javax.swing.JTextField sMotherContactText;
    private javax.swing.JTextField sMotherContactText1;
    private javax.swing.JTextField sMotherText;
    private javax.swing.JTextField sMotherText1;
    private javax.swing.JTextField sNText;
    private javax.swing.JTextField salaryText;
    private javax.swing.JTextField salaryText1;
    private com.toedter.calendar.JDateChooser sdob;
    private com.toedter.calendar.JDateChooser sdob1;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> studentStatus;
    private javax.swing.JTextField totalFee;
    private javax.swing.JTextField tuitionFee;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
