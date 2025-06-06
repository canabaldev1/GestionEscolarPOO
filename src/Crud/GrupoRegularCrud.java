package Crud;

import Dominio.GrupoRegular;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class GrupoRegularCrud {
    public static HashMap<String, GrupoRegular> gruposRegulares = new HashMap<>();
    
    public static void agregar (GrupoRegular grupoRegular) throws Exception {
        if (gruposRegulares.containsKey(grupoRegular.getId().toString())) {
            throw new Exception ("el grupo regular "+grupoRegular.getId().toString()+" ya existe!");
        }
        gruposRegulares.put(grupoRegular.getId().toString(), grupoRegular );
    }

    public static GrupoRegular buscar (String grupoRegular_id) throws Exception {
        if (!gruposRegulares.containsKey(grupoRegular_id)) {
            throw new Exception ("el grupo regular "+grupoRegular_id+" no existe!");
        }
        return gruposRegulares.get(grupoRegular_id);
    }

    public static void editar (GrupoRegular grupoRegular) throws Exception {
        if (!gruposRegulares.containsKey(grupoRegular.getId().toString())) {
            throw new Exception ("el grupo regular "+grupoRegular.getId().toString()+" no existe!");
        }
        gruposRegulares.put(grupoRegular.getId().toString(), grupoRegular);
    }
    
    public static void eliminar (String grupoRegular_id) throws Exception {
        if (!gruposRegulares.containsKey(grupoRegular_id)) {
            throw new Exception ("el grupo regular "+grupoRegular_id+" no existe!");
        }
        gruposRegulares.remove(grupoRegular_id);
    }
    
    public static List<GrupoRegular> listarTodo () {
        return new ArrayList<>(gruposRegulares.values());
    }
    
    public static int contarTodo () {
        return gruposRegulares.size();
    }
}
