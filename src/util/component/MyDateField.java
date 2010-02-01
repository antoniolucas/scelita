package util.component;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Lucas
 */
public class MyDateField extends JFormattedTextField{
    static JFormattedTextField jFormattedTextField1;

    public MyDateField(){
        this(new Date());
    }


    public MyDateField(Date date){
        super(new DateFormatter(DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault())));
        this.setValue(date);
        this.setPreferredSize(new Dimension(85,19));
        this.setMinimumSize(new Dimension(85,  19));
        this.setMaximumSize(new Dimension(85,  19));
        jFormattedTextField1 =  this;
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String untilNow = jFormattedTextField1.getText().trim();
                int length = untilNow.length();
                System.out.println("releas " + untilNow + " " + length );
                if (Character.isLetter(evt.getKeyChar()))
                    jFormattedTextField1.setText(untilNow.replaceAll("[\\p{L}]", ""));
                else  if (length > 10)
                    jFormattedTextField1.setText(untilNow.substring(0, 10));
            }

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE )
                    return;
                String untilNow = jFormattedTextField1.getText().trim();
                int length = untilNow.length();
                System.out.println("press " + untilNow + " " + length );
                if ((evt.getKeyChar() == '/') && untilNow.endsWith("/"))
                    jFormattedTextField1.setText(untilNow.substring(0, length-1));//retira a '/' que acabou de ser digitada, pois ja havia uma
                if ((evt.getKeyChar() != '/') &&((length == 2) || (length == 5))) //Se a pessoa digitou a '/' nao faz nada
                    jFormattedTextField1.setText(untilNow + "/");//se nao digitou a '/', adicionamos uma =)

            }
        });
    }

}
