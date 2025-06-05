package Infraestructura.Configuracion.BD;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lm-carlos
 */
public class ConexionBD {
    private static EntityManagerFactory conexion;
    
    public static EntityManagerFactory conectar () {
        if (conexion == null) {
            conexion = Persistence.createEntityManagerFactory("ConfiguracionBD");
        }
        return conexion;
    }
    
    public static void desconectar() {
        if (conexion != null && conexion.isOpen() ) {
            conexion.close();
        }
        conexion = null;
    }
}
