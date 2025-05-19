package Crud;

import Dominio.Asignatura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AsignaturaCrud {
    public static HashMap<String, Asignatura> asignaturas = new HashMap<>();
    
    public static void agregar (Asignatura asignatura) throws Exception {
        if (asignaturas.containsKey(asignatura.getId())) {
            throw new Exception ("la asignatura "+asignatura.getId()+" ya existe!");
        }
        asignaturas.put(asignatura.getId(), asignatura );
    }

    public static Asignatura buscar (String asignatura_id) throws Exception {
        if (!asignaturas.containsKey(asignatura_id)) {
            throw new Exception ("la asignatura "+asignatura_id+" no existe!");
        }
        return asignaturas.get(asignatura_id);
    }

    public static void editar (Asignatura asignatura) throws Exception {
        if (!asignaturas.containsKey(asignatura.getId())) {
            throw new Exception ("la asignatura "+asignatura.getId()+" no existe!");
        }
        asignaturas.put(asignatura.getId(), asignatura);
    }
    
    public static void eliminar (String asignatura_id) throws Exception {
        if (!asignaturas.containsKey(asignatura_id)) {
            throw new Exception ("la asignatura "+asignatura_id+" no existe!");
        }
        asignaturas.remove(asignatura_id);
    }
    
    public static List<Asignatura> listarTodo () {
        return new ArrayList<>(asignaturas.values());
    }
    
    public static int contarTodo () {
        return asignaturas.size();
    }
}

