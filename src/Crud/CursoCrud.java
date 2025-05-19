package Crud;

import Dominio.Curso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class CursoCrud {
    public static HashMap<String, Curso> cursos = new HashMap<>();
    
    public static void agregar (Curso curso) throws Exception {
        if (cursos.containsKey(curso.getId())) {
            throw new Exception ("el curso "+curso.getId()+" ya existe!");
        }
        cursos.put(curso.getId(), curso );
    }

    public static Curso buscar (String curso_id) throws Exception {
        if (!cursos.containsKey(curso_id)) {
            throw new Exception ("el curso "+curso_id+" no existe!");
        }
        return cursos.get(curso_id);
    }

    public static void editar (Curso curso) throws Exception {
        if (!cursos.containsKey(curso.getId())) {
            throw new Exception ("el curso "+curso.getId()+" no existe!");
        }
        cursos.put(curso.getId(), curso);
    }
    
    public static void eliminar (String curso_id) throws Exception {
        if (!cursos.containsKey(curso_id)) {
            throw new Exception ("el curso "+curso_id+" no existe!");
        }
        cursos.remove(curso_id);
    }
    
    public static List<Curso> listarTodo () {
        return new ArrayList<>(cursos.values());
    }
    
    public static int contarTodo () {
        return cursos.size();
    }
}
