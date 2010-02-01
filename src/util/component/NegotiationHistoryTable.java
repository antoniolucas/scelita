package util.component;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import mark.utils.el.annotation.AnnotationResolver;
import mark.utils.swing.table.ObjectTableModel;
import model.Client;
import model.Negotiation;

/**
 *
 * @author Lucas
 */
public class NegotiationHistoryTable extends JScrollPane implements Observer{

    ObjectTableModel<Negotiation> tableModel;
    JTable table;

    public NegotiationHistoryTable() {
        AnnotationResolver resolver = new AnnotationResolver(Negotiation.class);
         tableModel = new ObjectTableModel<Negotiation>(
                resolver, "negotiationDate,type,negotiationValue");
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setViewportView(table);
    }

    public NegotiationHistoryTable(Client client) {
        this();
        setData(client);
    }

    public void addItem(Negotiation negotiation){
        tableModel.add(negotiation);
    }

    public Negotiation getSelectedItem() {
        int row = table.getSelectedRow();
        if (row == -1) return null;
        else return getData().get(row);
    }
    public JTable getTable() {
        return table;
    }

    public ObjectTableModel<Negotiation> getTableModel() {
        return tableModel;
    }

    public List<Negotiation> getData() {
        return tableModel.getData();
    }

    public void setData(Client client) {
        tableModel.setData(Ebean.find(Negotiation.class).where(Expr.eq("client", client)).orderBy("negotiationDate ASC").findList());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null) {
            this.setData((Client) arg);
        }

    }

}

