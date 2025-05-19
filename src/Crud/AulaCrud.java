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
        if (aulas.containsKey(aula.getId())) {
            throw new Exception ("el aula ya existe!");
        }
        aulas.put(aula.getId(), aula );
    }

    public static Aula buscar (String aula_id) throws Exception {
        if (!aulas.containsKey(aula_id)) {
            throw new Exception ("el aula no existe!");
        }
        return aulas.get(aula_id);
    }

    public static void editar (Aula aula) throws Exception {
        if (!aulas.containsKey(aula.getId())) {
            throw new Exception ("el aula no existe!");
        }
        aulas.put(aula.getId(), aula);
    }
    
    public static void eliminar (String aula_id) throws Exception {
        if (!aulas.containsKey(aula_id)) {
            throw new Exception ("el aula no existe!");
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

