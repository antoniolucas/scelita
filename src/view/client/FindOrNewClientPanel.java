/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FindOrNewClientPanel.java
 *
 * Created on Jan 25, 2010, 8:13:53 PM
 */

package view.client;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Client;
import util.GuiUtils;
import util.MyObservable;

/**
 *
 * @author bem
 */
public class FindOrNewClientPanel extends javax.swing.JPanel {
    Client client;
    MyObservable observable;
    /** Creates new form FindOrNewClientPanel */
    public FindOrNewClientPanel() {
        initComponents();
        observable = new MyObservable();
        client = new Client();
    }

    public FindOrNewClientPanel(Client client) {
        initComponents();
        this.client = client;
    }

   public synchronized void addObserver(Observer o) {
       observable.addObserver(o);
   }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        buscarClientButton = new JButton();
        jLabel2 = new JLabel();
        clientNameText = new JTextField();
        cadastrarNovoCliente = new JButton();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setName("Form");
        setLayout(new GridBagLayout());

        buscarClientButton.setText("Buscar");
        buscarClientButton.setName("buscarClientButton"); // NOI18N
        buscarClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buscarClientButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = -9;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(6, 18, 12, 0);
        add(buscarClientButton, gridBagConstraints);

        jLabel2.setText("Selecione o cliente:");
        jLabel2.setName("jLabel2"); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(12, 0, 0, 0);
        add(jLabel2, gridBagConstraints);

        clientNameText.setEditable(false);
        clientNameText.setName("clientNameText"); // NOI18N
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 215;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.insets = new Insets(12, 20, 0, 12);
        add(clientNameText, gridBagConstraints);

        cadastrarNovoCliente.setText("novo cliente");
        cadastrarNovoCliente.setName("cadastrarNovoCliente"); // NOI18N
        cadastrarNovoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cadastrarNovoClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = -9;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = new Insets(6, 20, 12, 0);
        add(cadastrarNovoCliente, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClientButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buscarClientButtonActionPerformed
        //        FieldResolver[] cols = new AnnotationResolver(Client.class).
        //                resolve("name:Nome,reference:Referencia,address:Endereço");
        //        SelectTable st = new SelectTable(cols, Ebean.find(Client.class).orderBy("name ASC").findList());
        //        st.addObjectSelectListener(new ObjectSelectListener() {
        //
        //            @Override
        //            public void notifyObjectSelected(SelectEvent selectevent) {
        //                client = (Client) selectevent.getObject();
        //                Client p = (Client) selectevent.getObject();
        //                System.out.println(p.getName());
        //                System.out.println(p.getSaldo());
        //                clientNameText.setText(client.toString());
        //            }
        //        });
        //        st.setButtonsText("Filtrar", "OK", "Cancelar");
        //        st.showSelectTable();


        client = GuiUtils.getClient();
        if (client != null){
            clientNameText.setText(client.toString());
            notifyObservers();
        }

}//GEN-LAST:event_buscarClientButtonActionPerformed

    private void cadastrarNovoClienteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cadastrarNovoClienteActionPerformed
        client = new Client();
        Cadastro cadastroView = new Cadastro(new JFrame(),true,client);
        cadastroView.setAlwaysOnTop(true);
        cadastroView.setVisible(true);
        if (client != null){
            clientNameText.setText(client.toString());
            notifyObservers();
        }
    }//GEN-LAST:event_cadastrarNovoClienteActionPerformed

    private void notifyObservers(){
            observable.setChanged();
            observable.notifyObservers(client);
            observable.clearChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buscarClientButton;
    private JButton cadastrarNovoCliente;
    private JTextField clientNameText;
    private JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
