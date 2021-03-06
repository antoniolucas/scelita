/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * parcelas.java
 *
 * Created on Jan 21, 2010, 12:30:09 PM
 */

package view.negotiation;

import java.awt.BorderLayout;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.Client;
import model.Negotiation;
import net.miginfocom.swing.MigLayout;
import org.openide.util.NbBundle;
import util.component.MyDateField;

/**
 *
 * @author bem
 */
public class parcelas extends javax.swing.JDialog {

    public parcelas(java.awt.Frame parent, boolean modal,Client c, Negotiation n, int numParcelas) {
        this(parent, modal);
        Float valorParcela = (n.getNegotiationValue() / numParcelas);
        Float resto = (n.getNegotiationValue() % numParcelas);
        jPanel1.setLayout(new MigLayout("insets 10"));
        jPanel1.add(new JLabel("Data"));
        jPanel1.add(new JLabel("Valor"), "wrap");
        Calendar ca = new GregorianCalendar();
        ca.setTime(n.getNegotiationDate());
        if (c.getPaymentDay() < ca.get(Calendar.DAY_OF_MONTH)) ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DAY_OF_MONTH, c.getPaymentDay());
        jPanel1.add(new MyDateField(ca.getTime()));
        JFormattedTextField formattedTextField =  new JFormattedTextField(NumberFormat.getCurrencyInstance());
        formattedTextField.setValue(valorParcela.intValue() + resto);
        jPanel1.add(formattedTextField, "wrap");
        for (int i = 1 ; i < numParcelas ; i++){
            ca.add(Calendar.MONTH, 1);
            jPanel1.add(new MyDateField(ca.getTime()));
            formattedTextField =  new JFormattedTextField(NumberFormat.getCurrencyInstance());
            formattedTextField.setValue(valorParcela.intValue());
            jPanel1.add(formattedTextField, "wrap");
        }
        this.setLocationRelativeTo(null);
    }

    /** Creates new form parcelas */
    public parcelas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(NbBundle.getMessage(parcelas.class, "parcelas.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Client c = new Client();
                c.setPaymentDay(12);
                Negotiation n = new Negotiation();
                n.setNegotiationDate(new Date());
                n.setNegotiationValue(125f);
                parcelas dialog = new parcelas(new javax.swing.JFrame(), true, c, n, 4);
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
    private JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
