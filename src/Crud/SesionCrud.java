package Crud;

import Dominio.Sesion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class SesionCrud {

    public static HashMap<String, Sesion> sesiones = new HashMap<>();

    public static void agregar(Sesion sesion) throws Exception {
        if (sesiones.containsKey(sesion.getId())) {
            throw new Exception("la sesion ya existe!");
        }
        sesiones.put(sesion.getId(), sesion);
    }

    public static Sesion buscar(String sesion_id) throws Exception {
        if (!sesiones.containsKey(sesion_id)) {
            throw new Exception("la sesion no existe!");
        }
        return sesiones.get(sesion_id);
    }

    public static void editar(Sesion sesion) throws Exception {
        if (!sesiones.containsKey(sesion.getId())) {
            throw new Exception("la sesion no existe!");
        }
        sesiones.put(sesion.getId(), sesion);
    }

    public static void eliminar(String sesion_id) throws Exception {
        if (!sesiones.containsKey(sesion_id)) {
            throw new Exception("la sesion no existe!");
        }
        sesiones.remove(sesion_id);
    }

    public static List<Sesion> listarTodo() {
        return new ArrayList<>(sesiones.values());
    }

    public static int contarTodo() {
        return sesiones.size();
    }
}

