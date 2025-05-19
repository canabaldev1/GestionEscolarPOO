package Crud;

import Dominio.Administrativo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AdministrativoCrud {
    public static HashMap<String, Administrativo> administrativos = new HashMap<>();
    
    public static void agregar (Administrativo administrativo) throws Exception {
        if (administrativos.containsKey(administrativo.getId())) {
            throw new Exception ("el usuario administrativo ya existe!");
        }
        administrativos.put(administrativo.getId(), administrativo );
    }

    public static Administrativo buscar (String administrativo_id) throws Exception {
        if (!administrativos.containsKey(administrativo_id)) {
            throw new Exception ("el usuario administrativo no existe!");
        }
        return administrativos.get(administrativo_id);
    }

    public static void editar (Administrativo administrativo) throws Exception {
        if (!administrativos.containsKey(administrativo.getId())) {
            throw new Exception ("el usuario administrativo no existe!");
        }
        administrativos.put(administrativo.getId(), administrativo);
    }
    
    public static void eliminar (String administrativo_id) throws Exception {
        if (!administrativos.containsKey(administrativo_id)) {
            throw new Exception ("el usuario administrativo no existe!");
        }
        administrativos.remove(administrativo_id);
    }
    
    public static List<Administrativo> listarTodo () {
        return new ArrayList<>(administrativos.values());
    }
    
    public static int contarTodo () {
        return administrativos.size();
    }
}
