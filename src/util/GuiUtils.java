package util;

import util.component.MyDateField;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import mark.utils.el.FieldResolver;
import mark.utils.el.annotation.AnnotationResolver;
import mark.utils.swing.ObjectSelectListener;
import mark.utils.swing.SelectEvent;
import mark.utils.swing.table.ObjectTableModel;
import mark.utils.swing.table.SelectTable;
import model.Client;
import model.Negotiation;
import model.Product;

/**
 *
 * @author Lucas
 */
public class GuiUtils {

    static Client client;

    public static Client getClient() {
        client = null;
        FieldResolver[] cols = new AnnotationResolver(Client.class).resolve("name:Nome,reference:Referencia,address:Endereço,saldo");
        SelectTable st = new SelectTable(cols, Ebean.find(Client.class).orderBy("name ASC").findList());
        st.addObjectSelectListener(new ObjectSelectListener() {

            @Override
            public void notifyObjectSelected(SelectEvent selectevent) {
                client = (Client) selectevent.getObject();
            }
        });
        st.setButtonsText("Filtrar", "OK", "Cancelar");
        st.showModal(new JFrame());
        return client;
    }


    /**
     * retorna uma tabela contendo as negociacoes de um determinado cliente
     * @param c o cliente cuja a historia é recuperada
     * @return
     */
    public static JScrollPane getClientNgotiationHistory(Client c){
        AnnotationResolver resolver = new AnnotationResolver(Negotiation.class);
        ObjectTableModel<Negotiation> tableModel = new ObjectTableModel<Negotiation>(
                resolver, "negotiationDate,type,negotiationValue");
        tableModel.setData(Ebean.find(Negotiation.class).where(Expr.eq("client", c)).orderBy("negotiationDate ASC").findList());
        JTable table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        return pane;

    }


    /**
     * retorna uma tabela contendo as negociacoes de um determinado cliente
     * @param c o cliente cuja a historia é recuperada
     * @return
     */
    public static JScrollPane getProductsFromNegotiation(Negotiation negotiation){
        AnnotationResolver resolver = new AnnotationResolver(Product.class);
        ObjectTableModel<Product> tableModel = new ObjectTableModel<Product>(
                resolver, "code:Código,description:Descrição,sellValue:Valor");
        tableModel.setData(Ebean.find(Product.class).where(Expr.eq("negotiation", negotiation)).findList());
        JTable table = new JTable(tableModel);
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        return pane;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel jPanel = new JPanel();
//        jPanel.add(getClientNgotiationHistory(Ebean.find(Client.class, 1)));
        jPanel.add(new MyDateField());
        frame.add(jPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
