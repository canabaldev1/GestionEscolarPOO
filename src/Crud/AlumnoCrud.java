package Crud;

import Dominio.Alumno;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AlumnoCrud {

    public static HashMap<String, Alumno> alumnos = new HashMap<>();

    public static void agregar(Alumno alumno) throws Exception {
        if (alumnos.containsKey(alumno.getId())) {
            throw new Exception("el alumno "+alumno.getId()+" ya existe!");
        }
        alumnos.put(alumno.getId(), alumno);
    }

    public static Alumno buscar(String alumno_id) throws Exception {
        if (!alumnos.containsKey(alumno_id)) {
            throw new Exception("el alumno " + alumno_id + " no existe!");
        }
        return alumnos.get(alumno_id);
    }

    public static void editar(Alumno alumno) throws Exception {
        if (!alumnos.containsKey(alumno.getId())) {
            throw new Exception("el alumno " + alumno.getId() + " no existe!");
        }
        alumnos.put(alumno.getId(), alumno);
    }

    public static void eliminar(String alumno_id) throws Exception {
        if (!alumnos.containsKey(alumno_id)) {
            throw new Exception("el alumno " + alumno_id + " no existe!");
        }
        alumnos.remove(alumno_id);
    }

    public static List<Alumno> listarTodo() {
        return new ArrayList<>(alumnos.values());
    }

    public static int contarTodo() {
        return alumnos.size();
    }
}
