/*
 * CookieJarViewer2.java
 *
 * Created on September 30, 2003, 10:08 PM
 */

package org.owasp.webscarab.ui.swing;

import org.owasp.webscarab.model.Cookie;
import org.owasp.webscarab.model.CookieJar;

import org.owasp.webscarab.util.swing.TableRow;
import org.owasp.webscarab.util.swing.ListTableModelAdaptor;
import org.owasp.webscarab.util.swing.TableSorter;

import javax.swing.ListModel;

import java.util.Date;

/**
 *
 * @author  rdawes
 */
public class CookieJarViewer extends javax.swing.JFrame {
    
    private CookieJar _cookieJar;
    private ListTableModelAdaptor _ltma = new ListTableModelAdaptor(null, new CookieRow());
    
    /** Creates new form CookieJarViewer2 */
    public CookieJarViewer(CookieJar cookiejar) {
        initComponents();
        cookieTable.setModel(new TableSorter(_ltma, cookieTable.getTableHeader()));

        _cookieJar = cookiejar;
        cookieComboBox.setModel(new ListComboBoxModel(cookiejar.getCookieList()));
        String cookie = (String) cookieComboBox.getSelectedItem();
        _ltma.setListModel(_cookieJar.getCookieList(cookie));
    }
                                                                                
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        cookieComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        cookieTable = new javax.swing.JTable();
        closeButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabel1.setText("Cookies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jLabel1, gridBagConstraints);

        cookieComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cookieComboBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(cookieComboBox, gridBagConstraints);

        cookieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        cookieTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(cookieTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(closeButton, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void cookieComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cookieComboBoxActionPerformed
        String cookie = (String) cookieComboBox.getSelectedItem();
        _ltma.setListModel(_cookieJar.getCookieList(cookie));
    }//GEN-LAST:event_cookieComboBoxActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
    }//GEN-LAST:event_exitForm
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox cookieComboBox;
    private javax.swing.JTable cookieTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    private class CookieRow implements TableRow {
        
        private String[] _columnNames = new String[] {
            "Date", "Value", "Secure", "MaxAge", "Comment"
        };
        
        private Class[] _columnClasses = new Class[] {
            Date.class, String.class, Boolean.class, String.class, String.class
        };
        
        public int getColumnCount() {
            return _columnNames.length;
        }
        
        public String getColumnName(int column) {
            return _columnNames[column];
        }
        
        public Class getColumnClass(int column) {
            return _columnClasses[column];
        }
        
        public Object getValueAt(Object object, int columnIndex) {
            Cookie cookie = (Cookie) object;
            switch (columnIndex) {
                case 0: return cookie.getDate();
                case 1: return cookie.getValue();
                case 2: return Boolean.valueOf(cookie.getSecure());
                case 3: return cookie.getMaxAge();
                case 4: return cookie.getComment();
            }
            return null;
        }
        
        public boolean isFieldEditable(Object object, int column) {
            return false;
        }
        
        public void setValueAt(Object aValue, Object object, int column) {
        }
        
    }
    
}
