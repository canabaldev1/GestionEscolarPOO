package Crud;

import Dominio.ProfesorInfantil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ProfesorInfantilCrud {

    public static HashMap<String, ProfesorInfantil> profesoresInfantiles = new HashMap<>();

    public static void agregar(ProfesorInfantil profesorInfantil) throws Exception {
        if (profesoresInfantiles.containsKey(profesorInfantil.getId())) {
            throw new Exception("el profesor infantil "+profesorInfantil.getId()+" ya existe!");
        }
        profesoresInfantiles.put(profesorInfantil.getId(), profesorInfantil);
    }

    public static ProfesorInfantil buscar(String profesorInfantil_id) throws Exception {
        if (!profesoresInfantiles.containsKey(profesorInfantil_id)) {
            throw new Exception("el profesor infantil "+profesorInfantil_id+" no existe!");
        }
        return profesoresInfantiles.get(profesorInfantil_id);
    }

    public static void editar(ProfesorInfantil profesorInfantil) throws Exception {
        if (!profesoresInfantiles.containsKey(profesorInfantil.getId())) {
            throw new Exception("el profesor infantil "+profesorInfantil.getId()+" no existe!");
        }
        profesoresInfantiles.put(profesorInfantil.getId(), profesorInfantil);
    }

    public static void eliminar(String profesorInfantil_id) throws Exception {
        if (!profesoresInfantiles.containsKey(profesorInfantil_id)) {
            throw new Exception("el profesor infantil "+profesorInfantil_id+" no existe!");
        }
        profesoresInfantiles.remove(profesorInfantil_id);
    }

    public static List<ProfesorInfantil> listarTodo() {
        return new ArrayList<>(profesoresInfantiles.values());
    }

    public static int contarTodo() {
        return profesoresInfantiles.size();
    }
}

