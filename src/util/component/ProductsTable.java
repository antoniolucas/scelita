package util.component;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import mark.utils.el.annotation.AnnotationResolver;
import mark.utils.swing.table.ObjectTableModel;
import model.Negotiation;
import model.Product;

/**
 *
 * @author Lucas
 */
public class ProductsTable extends JScrollPane {

    ObjectTableModel<Product> tableModel;
    JTable table;

    public ProductsTable() {
        super();
        AnnotationResolver resolver = new AnnotationResolver(Product.class);
        tableModel = new ObjectTableModel<Product>(
                resolver, "code:Código,description:Descrição,sellValue:Valor");
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setViewportView(table);
    }

    public ProductsTable(Negotiation negotiation) {
        this();
        setData(negotiation);
    }

    public Product getSelectedItem() {
        int row = table.getSelectedRow();
        if (row == -1) return null;
        else return getData().get(row);
    }

    public void addItem(Product product) {
        tableModel.add(product);
    }

    public void removeItem(Product product) {
        tableModel.remove(product);
    }

    public JTable getTable() {
        return table;
    }

    public ObjectTableModel<Product> getTableModel() {
        return tableModel;
    }

    public List<Product> getData() {
        return tableModel.getData();
    }

    public void setData(Negotiation negotiation) {
        tableModel.setData(negotiation.getProducts());
//        tableModel.setData(Ebean.find(Product.class).where(Expr.eq("negotiation", negotiation)).findList());
    }


}
