/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static schoolmanagementsystem.PaidTable.row;

/**
 *
 * @author Programmer
 */
public class UnpaidTable extends javax.swing.JFrame {

     String url = "jdbc:mysql://localhost:3306/navyug_database?useSSL = true";
    String username;
    String password;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    DefaultTableModel model;
    static String[] row = new String[7];
    String columns[]={"Admn No","Student Name","Roll No","Class","Father Name","Tuition fee","Status"};
    String array[][] = new String[0][0];
    TableRowSorter<TableModel> rsorter;
    String month="";
    String year = "";
    String monthYear="";
    String monthName[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
    
     //////////////////************TextAreaRenderer Class***********////////
            public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

              public TextAreaRenderer() {
                setLineWrap(true);
                setWrapStyleWord(true);
                setFont(new java.awt.Font("Helvetica",Font.BOLD,15));
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
               
                    }
             public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
                setText((String)obj);
                return this;
              }

            }
     //////////////////************TextAreaRenderer Up Class***********////////  
            
    public UnpaidTable() {
        Calendar cal = Calendar.getInstance();
            month=monthName[cal.get(Calendar.MONTH)];
            int intYear=cal.get(Calendar.YEAR);
            year = String.valueOf(intYear);
            monthYear = month+year;
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
        
        
        
         model = new DefaultTableModel(array,columns);
        initComponents();
         class3.setFont(new java.awt.Font("Helvetica",Font.BOLD,15));
        jTable1.getTableHeader().setFont(new Font("Arial Unicode MS",Font.BOLD,15));
        setLocationRelativeTo(null);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new UnpaidTable.TextAreaRenderer());
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new UnpaidTable.TextAreaRenderer());
      
        
       
        
       jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(90);
       
         
       
        rsorter = new TableRowSorter<TableModel>(jTable1.getModel());
        jTable1.setRowSorter(rsorter);
        java.util.List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
       
        
        String sql =  "select * from students_table where students_table.admission_no NOT IN (select admission_no from "+monthYear+")";
        try{
			Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(url,username,password);
			statement = connection.createStatement(); 
			resultSet= statement.executeQuery(sql);	
			
                            while(resultSet.next()){   
                                String s1 =resultSet.getString(1);
                                String s2 =resultSet.getString(2);
                                String s3 =resultSet.getString(3);
                                String s4 =resultSet.getString(4);
                                String s5 =resultSet.getString(5);
                                String s6 =resultSet.getString(6);
                                String s7 =resultSet.getString(18);
                               
                               
                              
                                
                                
                                row[0]=" "+s1;
                                row[1]=" "+s2+" "+s3;
                                row[2]=" "+s4;
                                row[3]=s5;
                                row[4]=" "+s6;
                                row[5]=" Unpaid";
                                row[6]=" "+s7;
                                
                              
                                
                                
                                model.addRow(row);
                            }  
                            
			connection.close();	
				
			}catch(SQLException |ClassNotFoundException e){ 
                        JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			} 
        l1.setText("Total Students");
        l2.setText(String.valueOf(model.getRowCount()));
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
        jPanel2 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        class3 = new javax.swing.JComboBox<>();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVSK Happy Public Sec School");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/logo.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 239, 154));

        jPanel2.setBackground(new java.awt.Color(255, 239, 154));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/3.png"))); // NOI18N
        searchButton.setText("Print");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Unpaid Student Details "+monthYear);

        class3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  I-A","  I-B","  I-C","  I-D","  I-E","  I-F","  II-A","  II-B","  II-C","  II-D","  II-E","  II-F","  III-A","  III-B","  III-C","  III-D","  III-E","  III-F","  IV-A","  IV-B","  IV-C","  IV-D","  IV-E","  IV-F","  V-A","  V-B","  V-C","  V-D","  V-E","  V-F","  VI-A","  VI-B","  VI-C","  VI-D","  VI-E","  VI-F","  VII-A","  VII-B","  VII-C","  VII-D","  VII-E","  VII-F","  VIII-A","  VIII-B","  VIII-C","  VIII-D","  VIII-E","  VIII-F","  IX-A","  IX-B","  IX-C","  IX-D","  IX-E","  IX-F","  X-A","  X-B","  X-C","  X-D","  X-E","  X-F","  XI-A","  XI-B","  XI-C","  XI-D","  XI-E","  XI-F","  XII-A","  XII-B","  XII-C","  XII-D","  XII-E","  XII-F" }));
        class3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                class3ItemStateChanged(evt);
            }
        });

        l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l1.setText("jLabel2");

        l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 0, 0));
        l2.setText("fsdf");

        jLabel69.setFont(new java.awt.Font("Engravers MT", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 204));
        jLabel69.setText("AVSK Happy Public Sec School");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(class3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(l2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(class3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 239, 154));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(model);
        jTable1.setRowHeight(70);
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        MessageFormat header = new MessageFormat("Nav Yug Happy Public Sec School Unpaid Student Details");
        MessageFormat footer = new MessageFormat("Page");

        try {
            // TODO add your handling code here:
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(PrintStudentTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void class3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_class3ItemStateChanged
        rsorter.setRowFilter(null);
        if(evt.getStateChange()==ItemEvent.SELECTED){
            String text  = (String) evt.getItem();
            int occurrance = 0;
            for(int row = 0; row < model.getRowCount(); row++) {

                if (jTable1.getValueAt(row, 3).equals(text) )
                occurrance++;

            }

            l1.setText(text); l2.setText(String.valueOf(occurrance));
           
            if(text.length()==0){
                rsorter.setRowFilter(null);
                l1.setText("Total Students");
                l2.setText(String.valueOf(model.getRowCount()));
            }
            rsorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_class3ItemStateChanged

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
            java.util.logging.Logger.getLogger(UnpaidTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnpaidTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnpaidTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnpaidTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnpaidTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> class3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
