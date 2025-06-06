package Crud;

import Dominio.Clase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ClaseCrud {
    public static HashMap<String, Clase> clases = new HashMap<>();
    
    public static void agregar (Clase clase) throws Exception {
        if (clases.containsKey(clase.getId().toString())) {
            throw new Exception ("la clase "+clase.getId().toString()+" ya existe!");
        }
        clases.put(clase.getId().toString(), clase );
    }

    public static Clase buscar (String clase_id) throws Exception {
        if (!clases.containsKey(clase_id)) {
            throw new Exception ("la clase "+clase_id+" no existe!");
        }
        return clases.get(clase_id);
    }

    public static void editar (Clase clase) throws Exception {
        if (!clases.containsKey(clase.getId().toString())) {
            throw new Exception ("la clase "+clase.getId().toString()+" no existe!");
        }
        clases.put(clase.getId().toString(), clase);
    }
    
    public static void eliminar (String clase_id) throws Exception {
        if (!clases.containsKey(clase_id)) {
            throw new Exception ("la clase "+clase_id+" no existe!");
        }
        clases.remove(clase_id);
    }
    
    public static List<Clase> listarTodo () {
        return new ArrayList<>(clases.values());
    }
    
    public static int contarTodo () {
        return clases.size();
    }
}
