package Crud;

import Dominio.Beca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class BecaCrud {
    public static HashMap<String, Beca> becas = new HashMap<>();
    
    public static void agregar (Beca beca) throws Exception {
        if (becas.containsKey(beca.getId())) {
            throw new Exception ("la beca ya existe!");
        }
        becas.put(beca.getId(), beca );
    }

    public static Beca buscar (String beca_id) throws Exception {
        if (!becas.containsKey(beca_id)) {
            throw new Exception ("la beca no existe!");
        }
        return becas.get(beca_id);
    }

    public static void editar (Beca beca) throws Exception {
        if (!becas.containsKey(beca.getId())) {
            throw new Exception ("la beca no existe!");
        }
        becas.put(beca.getId(), beca);
    }
    
    public static void eliminar (String beca_id) throws Exception {
        if (!becas.containsKey(beca_id)) {
            throw new Exception ("la beca no existe!");
        }
        becas.remove(beca_id);
    }
    
    public static List<Beca> listarTodo () {
        return new ArrayList<>(becas.values());
    }
    
    public static int contarTodo () {
        return becas.size();
    }
}

