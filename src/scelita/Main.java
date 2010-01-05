package scelita;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;
import model.ClientClassification;
import model.Phone;
import net.java.ao.DBParam;
import net.java.ao.EntityManager;
import net.java.ao.Generator;


/**
 *
 * @author antoniolucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        try {
//            System.out.println(System.getProperty("user.dir"));
//            Scanner sc = new Scanner(new File("src/imagens.txt"));
//            ArrayList<String> imagens = new ArrayList<String>();
//            while(sc.hasNextLine()){
//                imagens.add(sc.nextLine());
//            }
//            for (String s : imagens)
//                System.out.println(s);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            Scanner sc = new Scanner(new File("src/imagens.txt"));
//            ArrayList<ArrayList<Integer>> imagens = new ArrayList<ArrayList<Integer>>();
//            while(sc.hasNextLine()){
//                ArrayList<Integer> im = new ArrayList<Integer>();
//                String linha = sc.nextLine();
//                StringTokenizer st = new StringTokenizer(linha);
//                while (st.hasMoreTokens())
//                    im.add(new Integer(st.nextToken()));
//                imagens.add(im);
//            }
//            for (ArrayList<Integer> i : imagens){
//                for (Integer in : i)
//                    System.out.print(in+ " ");
//                System.out.println();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }


        EntityManager em = new EntityManager("jdbc:postgresql://localhost/scelita", "postgres", "postgres");

//        em.migrate(ClientClassification.class, Client.class,Phone.class);
        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("saldo", 1.2f);
//        params.put("foo", 1.2f);

        Client c =  em.create(Client.class,params);
//        c.setSaldo(1.2f);
        c.setReferencia("foobar");
        c.setName("Lucas");

        c.save();
//




    }

}
