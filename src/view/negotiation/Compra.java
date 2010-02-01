/*
 * Venda.java
 *
 * Created on Jan 12, 2010, 9:51:19 AM
 */

package view.negotiation;

import com.avaje.ebean.Ebean;
import java.awt.AWTKeyStroke;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import mark.utils.el.annotation.AnnotationResolver;
import mark.utils.swing.table.ObjectTableModel;
import model.Client;
import model.Negotiation;
import model.Product;
import net.sf.nachocalendar.components.DateField;
import util.component.MoneyField;
import util.component.MyDateField;
import view.client.FindOrNewClientPanel;

/**
 *
 * @author Lucas
 */
public class Compra extends javax.swing.JDialog implements Observer{
    Client client = new Client();
    ObjectTableModel<Product> tableModel;

    /** Creates new form Venda */
    public Compra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);

        AnnotationResolver resolver = new AnnotationResolver(Product.class);
        tableModel = new ObjectTableModel<Product>(
                resolver, "code:Código,description:Descrição,sellValue:Valor");
        initComponents();
        tableModel.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                Float v = 0.0f;
                for (Product p : tableModel.getData()){
                    v+= p.getSellValue();
                }
                valorVenda.setValue(v);
            }
        });
        this.pack();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateField = new DateField();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        observacao = new JTextArea();
        jLabel5 = new JLabel();
        cadastrar = new JButton();
        cancelar = new JButton();
        jLabel1 = new JLabel();
        jFormattedTextField1 = new JFormattedTextField(0);
        numeroParcelas = new JFormattedTextField(0);
        jLabel8 = new JLabel();
        findOrNewClientPanel1 = new FindOrNewClientPanel();
        valorVenda = new MoneyField();
        myDateField = new MyDateField();
        jPanel2 = new JPanel();
        jScrollPane2 = new JScrollPane();
        productsTable = new JTable(tableModel);
        jLabel7 = new JLabel();
        addProductButton = new JButton();
        removeProductButton = new JButton();

        dateField.setAntiAliased(true);
        dateField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                dateFieldKeyPressed(evt);
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Compra de Cliente");

        jLabel3.setText("Valor: ");

        jLabel4.setText("Observação:");

        observacao.setColumns(20);
        observacao.setRows(5);
        jScrollPane1.setViewportView(observacao);

        jLabel5.setText("Data da Compra:");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Dia Vencimento:");

        jFormattedTextField1.setToolTipText("Digite o dia de pagamento");

        numeroParcelas.setToolTipText("Digite o dia de pagamento");

        jLabel8.setText("Nº parcelas:");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(cadastrar)
                        .addGap(15, 15, 15)
                        .addComponent(cancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(findOrNewClientPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroParcelas, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(myDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(findOrNewClientPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(valorVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(myDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(numeroParcelas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(cadastrar)
                    .addComponent(cancelar)))
        );

        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        jScrollPane2.setViewportView(productsTable);

        jLabel7.setText("Produtos:");

        addProductButton.setText("Adicionar");
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        removeProductButton.setText("Remover");
        removeProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeProductButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(addProductButton)
                        .addGap(32, 32, 32)
                        .addComponent(removeProductButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(addProductButton)
                    .addComponent(removeProductButton))
                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Number value = (Number) valorVenda.getValue();
        System.out.println(value);
//        Date date = (Date)dateField.getValue();
        Date date = (Date) myDateField.getValue();
        Negotiation venda = new Negotiation(client,Negotiation.Type.COMPRA,value.floatValue(),date);
        venda.setProducts(tableModel.getData());
        Ebean.beginTransaction();
        try{
            client.compra(venda.getNegotiationValue());
            Ebean.save(client);//TODO ver se eh preciso salvar client
            Ebean.save(venda);
            Ebean.saveManyToManyAssociations(venda, "products");
            Ebean.commitTransaction();
        }finally{
            Ebean.endTransaction();
        }
}//GEN-LAST:event_cadastrarActionPerformed

    private void dateFieldKeyPressed(KeyEvent evt) {//GEN-FIRST:event_dateFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            dateField.setEnabled(false);
        }
        else{
            JFormattedTextField  jFormattedTextField2 =  dateField.getFormattedTextField();
                            System.out.println("sadfsd");
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE )
                    return;
                String untilNow = jFormattedTextField2.getText().trim();
                int length = untilNow.length();
                if ((evt.getKeyChar() == '/') && untilNow.endsWith("/"))
                    jFormattedTextField2.setText(untilNow.substring(0, length-1));//retira a '/' que acabou de ser digitada, pois ja havia uma
                if ((evt.getKeyChar() != '/') &&((length == 2) || (length == 5))) //Se a pessoa digitou a '/' nao faz nada
                    jFormattedTextField2.setText(untilNow + "/");//se nao digitou a '/', adicionamos uma =)

        }
}//GEN-LAST:event_dateFieldKeyPressed

    private void cancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void addProductButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        Product p = new Product();
        new CadastrarProduto(null, true, p).setVisible(true);
        if (p != null)
            tableModel.add(p);

    }//GEN-LAST:event_addProductButtonActionPerformed

    private void removeProductButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeProductButtonActionPerformed
        int row = productsTable.getSelectedRow();
        if (row != -1)
            tableModel.remove(row);
    }//GEN-LAST:event_removeProductButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Compra dialog = new Compra(new javax.swing.JFrame(), false);
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
    private JButton addProductButton;
    private JButton cadastrar;
    private JButton cancelar;
    private DateField dateField;
    private FindOrNewClientPanel findOrNewClientPanel1;
    private JFormattedTextField jFormattedTextField1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private MyDateField myDateField;
    private JFormattedTextField numeroParcelas;
    private JTextArea observacao;
    private JTable productsTable;
    private JButton removeProductButton;
    private MoneyField valorVenda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        this.client = (Client) arg;
    }

}