package Crud;

import Dominio.Aula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AulaCrud {
    public static HashMap<String, Aula> aulas = new HashMap<>();
    
    public static void agregar (Aula aula) throws Exception {
        if (aulas.containsKey(aula.getId().toString())) {
            throw new Exception ("el aula "+aula.getId().toString()+" ya existe!");
        }
        aulas.put(aula.getId().toString(), aula );
    }

    public static Aula buscar (String aula_id) throws Exception {
        if (!aulas.containsKey(aula_id)) {
            throw new Exception ("el aula "+aula_id+" no existe!");
        }
        return aulas.get(aula_id);
    }

    public static void editar (Aula aula) throws Exception {
        if (!aulas.containsKey(aula.getId().toString())) {
            throw new Exception ("el aula "+aula.getId().toString()+" no existe!");
        }
        aulas.put(aula.getId().toString(), aula);
    }
    
    public static void eliminar (String aula_id) throws Exception {
        if (!aulas.containsKey(aula_id)) {
            throw new Exception ("el aula "+aula_id+" no existe!");
        }
        aulas.remove(aula_id);
    }
    
    public static List<Aula> listarTodo () {
        return new ArrayList<>(aulas.values());
    }
    
    public static int contarTodo () {
        return aulas.size();
    }
}

