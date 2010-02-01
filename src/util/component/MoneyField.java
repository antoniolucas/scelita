package util.component;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Lucas
 */
public class MoneyField extends JFormattedTextField{

    public MoneyField(){
        super(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.setPreferredSize(new Dimension(85, 19));
        this.setMinimumSize(new Dimension(85,  19));
        this.setMaximumSize(new Dimension(85, 19));
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JFormattedTextField field = (JFormattedTextField) evt.getComponent();
                String untilNow = field.getText().trim();
                if (Character.isLetter(evt.getKeyChar()))
                    field.setText(untilNow.replaceAll("[\\p{L}]", ""));//remove as letras

            }
        });

    }

    public MoneyField(Float value){
        this();
        this.setValue(value);
    }

    


    
}
