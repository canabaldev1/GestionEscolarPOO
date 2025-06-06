package Crud;

import Dominio.ProfesorRegular;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ProfesorRegularCrud {

    public static HashMap<String, ProfesorRegular> profesoresRegulares = new HashMap<>();

    public static void agregar(ProfesorRegular profesorRegular) throws Exception {
        if (profesoresRegulares.containsKey(profesorRegular.getId().toString())) {
            throw new Exception("el profesor regular "+profesorRegular.getId().toString()+" ya existe!");
        }
        profesoresRegulares.put(profesorRegular.getId().toString(), profesorRegular);
    }

    public static ProfesorRegular buscar(String profesorRegular_id) throws Exception {
        if (!profesoresRegulares.containsKey(profesorRegular_id)) {
            throw new Exception("el profesor regular "+profesorRegular_id+" no existe!");
        }
        return profesoresRegulares.get(profesorRegular_id);
    }

    public static void editar(ProfesorRegular profesorRegular) throws Exception {
        if (!profesoresRegulares.containsKey(profesorRegular.getId().toString())) {
            throw new Exception("el profesor regular "+profesorRegular.getId().toString()+" no existe!");
        }
        profesoresRegulares.put(profesorRegular.getId().toString(), profesorRegular);
    }

    public static void eliminar(String profesorRegular_id) throws Exception {
        if (!profesoresRegulares.containsKey(profesorRegular_id)) {
            throw new Exception("el profesor regular "+profesorRegular_id+" no existe!");
        }
        profesoresRegulares.remove(profesorRegular_id);
    }

    public static List<ProfesorRegular> listarTodo() {
        return new ArrayList<>(profesoresRegulares.values());
    }

    public static int contarTodo() {
        return profesoresRegulares.size();
    }
}
