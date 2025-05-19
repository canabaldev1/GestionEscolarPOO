package Crud;

import Dominio.Modalidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ModalidadCrud {

    public static HashMap<String, Modalidad> modalidades = new HashMap<>();

    public static void agregar(Modalidad modalidad) throws Exception {
        if (modalidades.containsKey(modalidad.getId())) {
            throw new Exception("la modalidad "+modalidad.getId()+" ya existe!");
        }
        modalidades.put(modalidad.getId(), modalidad);
    }

    public static Modalidad buscar(String modalidad_id) throws Exception {
        if (!modalidades.containsKey(modalidad_id)) {
            throw new Exception("la modalidad "+modalidad_id+" no existe!");
        }
        return modalidades.get(modalidad_id);
    }

    public static void editar(Modalidad modalidad) throws Exception {
        if (!modalidades.containsKey(modalidad.getId())) {
            throw new Exception("la modalidad "+modalidad.getId()+" no existe!");
        }
        modalidades.put(modalidad.getId(), modalidad);
    }

    public static void eliminar(String modalidad_id) throws Exception {
        if (!modalidades.containsKey(modalidad_id)) {
            throw new Exception("la modalidad "+modalidad_id+" no existe!");
        }
        modalidades.remove(modalidad_id);
    }

    public static List<Modalidad> listarTodo() {
        return new ArrayList<>(modalidades.values());
    }

    public static int contarTodo() {
        return modalidades.size();
    }
}
