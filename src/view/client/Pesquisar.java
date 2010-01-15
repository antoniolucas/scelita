/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Pesquisar.java
 *
 * Created on Jan 5, 2010, 12:11:00 AM
 */

package view.client;

import controller.GenericController;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Phone;
import org.openide.util.Exceptions;

/**
 *
 * @author bem
 */
public class Pesquisar extends javax.swing.JDialog {
    private Client client;
    private Client[] clients;

    /** Creates new form Pesquisar */
    public Pesquisar(java.awt.Frame parent, boolean modal, Client c) {
        super(parent, modal);
        client = c;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.title")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.jLabel1.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.jTextField1.text")); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.jButton1.text")); // NOI18N

        clientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Referência", "Endereço", "Telefones", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        clientsTable.setColumnSelectionAllowed(true);
        clientsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(clientsTable);
        clientsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        clientsTable.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.clientsTable.columnModel.title0")); // NOI18N
        clientsTable.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.clientsTable.columnModel.title1")); // NOI18N
        clientsTable.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.clientsTable.columnModel.title2")); // NOI18N
        clientsTable.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.clientsTable.columnModel.title3")); // NOI18N
        clientsTable.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.clientsTable.columnModel.title4")); // NOI18N

        jButton2.setText(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.jButton2.text")); // NOI18N

        jButton3.setText(org.openide.util.NbBundle.getMessage(Pesquisar.class, "Pesquisar.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, 0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, 0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, 0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        try {
            System.out.println(jTextField1.getText());
            buscarClientes(jTextField1.getText());
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarClientes(String name) throws SQLException{
//        Client [] clients = GenericController.em.find(Client.class, "name LIKE ? OR nickname LIKE ?" , name, name);
        //clients = GenericController.em.find(Client.class, "upper(name) LIKE upper(?)","%"+name+"%");
        DefaultTableModel model = (DefaultTableModel) clientsTable.getModel();
        model.setRowCount(0);//erases all previous data
        for (Client c : clients){
            String phones = "";
            for (Phone p : c.getPhones())
                phones += p.getNumber() + " / " ;
            phones = phones.length() < 3 ? phones : phones.substring(0,phones.length()-3);
            Object [] row = {c.getName(),c.getReference(),c.getAddress(),phones,c.getSaldo()};
            model.addRow(row);
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pesquisar dialog = new Pesquisar(new javax.swing.JFrame(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
