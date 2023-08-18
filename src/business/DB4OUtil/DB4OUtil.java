/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.DB4OUtil;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import business.ConfigureABusiness;
import business.Business;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.io.File;

/**
 *
 * @author zwei
 */
public class DB4OUtil {

    private static String getClassPath() {
        try {
            URL url = DB4OUtil.class.getProtectionDomain().getCodeSource().getLocation();
            URI uri = url.toURI();
            return new File(uri).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String DIRNAME = new File(getClassPath()).getParent();  // This gives the directory of the current class or JAR.
    private static final String FILENAME = DIRNAME + File.separator + "DataBank.db4o";

    //private static final String FILENAME = "D:/Northeastern University/Summer2023/INFO5100/Final/5100Final/National Vaccine Distribution System/dataBank/DataBank.db4o"; // path to the data store
    private static DB4OUtil dB4OUtil;

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(Business.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(Business system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }

    public Business retrieveSystem() {
        ObjectContainer conn = createConnection();
        ObjectSet<Business> systems = conn.query(Business.class); // Change to the object you want to save
        Business system;
        if (systems.size() == 0) {
            system = ConfigureABusiness.configure();// If there's no System in the record, create a new one
            conn.store(system);
            conn.commit();
        } else {
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
}
