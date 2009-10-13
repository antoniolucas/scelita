package scelita;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import model.Client;
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
        EntityManager em = new EntityManager("jdbc:postgresql://localhost/ao_test", "postgres", "postgres");

        em.migrate(Client.class);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("saldo", 1.2f);

        Client c = em.create(Client.class,params);
//        c.setSaldo(1.2f);
        c.setReferencia("foobar");
        c.setName("Lucas");

        c.save();





    }

}
