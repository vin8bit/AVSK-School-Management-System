/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Programmer
 */
public class StaffTable extends javax.swing.JFrame {

    /**
     * Creates new form StaffTable
     */
    String url = "jdbc:mysql://localhost:3306/navyug_database?useSSL = true";
    String username;
    String password;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    DefaultTableModel model;
    static String[] row = new String[14];
     String columns[]={"Staff ID","Fisrt Name","Last Name","D.O.B","Phone No","Father & Husband Name","Gender","Email-ID","Qualification","Designation","Salary","Joining Date","Address","Status"};
    String array[][] = new String[0][0];
    TableRowSorter<TableModel> rsorter;
    
    
 //////////////////************TextAreaRenderer Class***********////////
            public class TextAreaRenderer extends JTextArea implements TableCellRenderer {

              public TextAreaRenderer() {
                setLineWrap(true);
                setWrapStyleWord(true);
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 162, 232), 1));
                    }
             public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
                setText((String)obj);
                return this;
              }

            }
     //////////////////************TextAreaRenderer Up Class***********////////        
    public StaffTable() {
        
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
        setLocationRelativeTo(null);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(6).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(7).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(8).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(9).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(10).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(11).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(12).setCellRenderer(new TextAreaRenderer());
        jTable1.getColumnModel().getColumn(13).setCellRenderer(new TextAreaRenderer());
        rsorter = new TableRowSorter<TableModel>(jTable1.getModel());
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(150);
       // jTable1.getColumnModel().getColumn(13).setPreferredWidth(50);
       // jTable1.getColumnModel().getColumn(16).setPreferredWidth(50);
        jTable1.setRowSorter(rsorter);
        java.util.List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        rsorter.setSortKeys(sortKeys);
       
        
        String sql = "SELECT * FROM staff_table";
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
                                String s7 =resultSet.getString(7);
                                String s8 =resultSet.getString(8);
                                String s9 =resultSet.getString(9);
                                String s10 =resultSet.getString(10);
                                String s11 =resultSet.getString(11);
                                String s12 =resultSet.getString(12);
                                String s13 =resultSet.getString(13);
                                String s14 =resultSet.getString(14);
                                
                                
                                row[0]=s1;
                                row[1]=s2;
                                row[2]=s3;
                                row[3]=s4;
                                row[4]=s5;
                                row[5]=s6;
                                row[6]=s7;
                                row[7]=s8;
                                row[8]=s9;
                                row[9]=s10;
                                row[10]=s11;
                                row[11]=s12;
                                row[12]=s13;
                                row[13]=s14;
                                
                                model.addRow(row);
                            }  
                            
			connection.close();	
				
			}catch(SQLException |ClassNotFoundException e){ 
                        JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			} 
        l1.setText("Total Staff");
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
        searchText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        designation1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AVSK Happy Public Sec School");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/logo.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 239, 154));

        jPanel2.setBackground(new java.awt.Color(255, 239, 154));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/schoolmanagementsystem/icons/5.png"))); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Staff Details ");

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Active","Resigned","Terminated","On-Hold","Suspended"}));
        status.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusItemStateChanged(evt);
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

        designation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","  Principal","  Vice – principal","  Senior Teacher","  Teacher","  Junior Teacher","  Computer Teacher","  Physical Education Teacher","  Art & Craft","  Drawing Teacher","  Music Teacher","  Senior Administration Executive","  Junior Accountant","  Office Assistant","  Data Entry Operator","  Receptionist","  Security Guard","  Peon","  Plumber","  Electrician ","  Others"}));
        designation1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                designation1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(designation1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status, 0, 207, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(l2)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(designation1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        );

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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        String text=searchText.getText().trim();
            if(text.length()==0){
            rsorter.setRowFilter(null);  
            }
            rsorter.setRowFilter(RowFilter.regexFilter(text));
    }//GEN-LAST:event_searchButtonActionPerformed

    private void statusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusItemStateChanged
        // TODO add your handling code here:
         rsorter.setRowFilter(null);  
        if(evt.getStateChange()==ItemEvent.SELECTED){
            String text  = (String) evt.getItem();
            int occurrance = 0;
                String occurr = (String) evt.getItem();
                for(int row = 0; row < model.getRowCount(); row++) {
                  
                        if (jTable1.getValueAt(row, 13).equals(occurr) )
                            occurrance++;
                    }
               
                
                l1.setText(text); l2.setText(String.valueOf(occurrance));
               
            if(text.length()==0){
            rsorter.setRowFilter(null); 
             l1.setText("Total Staffs");
            l2.setText(String.valueOf(model.getRowCount()));
            }
            rsorter.setRowFilter(RowFilter.regexFilter(text));
        }
        
        
        
    }//GEN-LAST:event_statusItemStateChanged

    private void designation1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_designation1ItemStateChanged
        // TODO add your handling code here:
         rsorter.setRowFilter(null);  
        if(evt.getStateChange()==ItemEvent.SELECTED){
            String text  = (String) evt.getItem();
            int occurrance = 0;
                String occurr = (String) evt.getItem();
                for(int row = 0; row < model.getRowCount(); row++) {
                    
                        if (jTable1.getValueAt(row, 9).equals(occurr) )
                            occurrance++;
                    }
             
                
                l1.setText(text); l2.setText(String.valueOf(occurrance));
                
            if(text.length()==0){
            rsorter.setRowFilter(null); 
             l1.setText("Total Staffs");
            l2.setText(String.valueOf(model.getRowCount()));
            }
            rsorter.setRowFilter(RowFilter.regexFilter(text));
        }
        
    }//GEN-LAST:event_designation1ItemStateChanged

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
            java.util.logging.Logger.getLogger(StaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> designation1;
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
    private javax.swing.JTextField searchText;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
