/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.awt.print.PrinterException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Programmer
 */
public class PrintStudent extends javax.swing.JFrame {

    private String s1,s2,ss2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18;
    private Connection conn;
    private Statement stm2;
    private ResultSet rs2 ;
    String url = "jdbc:mysql://localhost:3306/navyug_database?useSSL = true";
    private String username="";
    private String password="";
    public PrintStudent() {
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
            
          
            
            
            }catch(IOException e){ JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.ERROR_MESSAGE); }
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
    private void printTextPane(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String s12,String s13,String s14,String s15,String s16,String s17,String s18){
        
        String fullName = s2+" "+s3;
        
        jTextPane1.setText("<html>\n" +
"<style>\n" +
"td{\n" +
"\n" +
"	font-size:10;\n" +
"  \n" +
"\n" +
"}\n" +
"h2{\n" +
"	color: #0A73C3;\n" +
"	\n" +
"}\n" +
"\n" +
"\n" +
"</style>\n" +
"<body  >\n" +
"\n" +
"    <table width=\"350\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 350px; height: auto;   \">\n" +
"        <tr>\n" +
"        <td  width=\"350\">\n" +
"\n" +
"            <table width=\"350\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" class=\"table\">\n" +
"                <tr>\n" +
"                <td width=\"350\" class=\"cell\">\n" +
"                <table align=\"center\" style=\"width: 350px; height: auto;  \">\n" +
"                    <tr align=\"center\" style=\"border: 1px solid #ccc;\">\n" +
"                        <td class=\"auto-style3\">\n" +
"                            <table>\n" +
"                                <tr>\n" +
"                                    <td >\n" +
"                                        <div class=\"header\">\n" +
"                                            <h2>AVSK Happy Public Sec School</h2>\n" +
"                                        </div>\n" +
"                                    </td>\n" +
"                                </tr>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                       \n" +
"                    </tr>\n" +
"                </table>\n" +
"                <br />\n" +
"                <table align=\"center\" style=\"width: 350px; height: auto;  border-radius: 5px 5px 5px 5px; padding-bottom: 15px;\">\n" +
"                    <tr align=\"center\">\n" +
"                        <td>\n" +
"                            <div class=\"header_sub\">\n" +
"                                <table>\n" +
"                                    <tr>\n" +
"                                        <td>\n" +
"                                            <h2>Student Details</h2>\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"                                </table>\n" +
"                                <table style=\"table-layout: fixed; class=\"tp01\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" width=\"350\">\n" +
"                                    <tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Admission No </strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s1+"</strong></td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Student Name</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+fullName+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Roll No</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s4+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Class</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s5+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Father's Name</strong></td>\n" +
"                                        <td  style=\"word-break:break-all; style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s6+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Father's Contact no</strong></td>\n" +
"                                        <td style=\"word-break:break-all; style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s7+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Father's Occupation</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s8+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Mother's Name</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s9+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Mother's Contact No</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s10+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Mother's Occupation</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s11+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Address</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s12+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Gender</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s13+"</strong></td>\n" +
"                                    </tr>\n" + 
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Caste</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s14+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Data of Brith</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s15+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Admission Date</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s16+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong></strong>Fees</td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s17+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Status</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;"+s18+"</strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong></strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong></strong></td>\n" +
"                                    </tr>\n" +
"									<tr>\n" +
"                                        <td style=\"padding-left: 10px; height: 15px;\" width=\"152\"><strong>Date</strong></td>\n" +
"                                        <td style=\"word-break:break-all;style=\"color:#666\"><strong>:&nbsp;&nbsp;____________________</strong></td>\n" +
"                                    </tr>\n" +
"                                   \n" +
"                                </table>\n" +
"                            </div>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table> \n" +
"                <br />\n" +
"               \n" +
"\n" +
"    </td>\n" +
"    </tr> \n" +
"    </table> \n" +
"</body>\n" +
"</html>");
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel69 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVSK Happy Public Sec School");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/logo.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 239, 154));

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/5.png"))); // NOI18N
        jButton2.setText("Search Student");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 204));
        jLabel69.setText("Print Student Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jTextPane1.print();
        } catch (PrinterException ex) {
            Logger.getLogger(PrintStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        s1 = "";s2 = "";s3 = "";s4 = "";s5 = "";s6 = "";s7 = "";s8 = "";s9 = "";s10 = "";s11 = "";s12 = "";s13 = "";s14 = "";s15 = "";s16 = "";s17 = "";s18 = "";
        String in = "";
        int flag5 = 0;
        in = JOptionPane.showInputDialog(this,"Please Enter Admission No");
        in = in.trim();
        if(!in.isEmpty()){
            jTextPane1.setText("");
            try{    conn = DriverManager.getConnection(url,username,password);
                stm2=conn.createStatement();
                rs2=stm2.executeQuery("Select admission_no from students_table");
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
                    rs2= stm2.executeQuery("SELECT  *  FROM students_table WHERE admission_no="+in+" ");
                    while(rs2.next()){
                        s1 = rs2.getString(1);
                        s2 = rs2.getString(2);
                        s3 = rs2.getString(3);
                        s4 = rs2.getString(4);

                        s5 = rs2.getString(5);
                        s6 = rs2.getString(6);
                        s7 = rs2.getString(7);
                        s8 = rs2.getString(8);
                        s9 = rs2.getString(9);
                        s10 = rs2.getString(10);
                        s11 = rs2.getString(11);
                        s12 = rs2.getString(12);
                        s13 = rs2.getString(13);
                        s14 = rs2.getString(14);
                        s15 = rs2.getString(15);
                        s16 = rs2.getString(16);
                        s17 = rs2.getString(17);
                        s18 = rs2.getString(18);

                    }
                    conn.close();
                    printTextPane(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18);
                }catch(SQLException p){JOptionPane.showMessageDialog(this,p,"Error",JOptionPane.ERROR_MESSAGE);}

            }else{ JOptionPane.showMessageDialog(this,"Data not found","Error",JOptionPane.ERROR_MESSAGE);}
        }else{ JOptionPane.showMessageDialog(this,"Field is empty","Error",JOptionPane.ERROR_MESSAGE);}

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PrintStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
