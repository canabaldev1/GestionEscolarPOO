package Crud;

import Dominio.GrupoInfantil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class GrupoInfantilCrud {
    public static HashMap<String, GrupoInfantil> gruposInfantiles = new HashMap<>();
    
    public static void agregar (GrupoInfantil grupoInfantil) throws Exception {
        if (gruposInfantiles.containsKey(grupoInfantil.getId())) {
            throw new Exception ("el grupo infantil "+grupoInfantil.getId()+" ya existe!");
        }
        gruposInfantiles.put(grupoInfantil.getId(), grupoInfantil );
    }

    public static GrupoInfantil buscar (String grupoInfantil_id) throws Exception {
        if (!gruposInfantiles.containsKey(grupoInfantil_id)) {
            throw new Exception ("el grupo infantil "+grupoInfantil_id+" no existe!");
        }
        return gruposInfantiles.get(grupoInfantil_id);
    }

    public static void editar (GrupoInfantil grupoInfantil) throws Exception {
        if (!gruposInfantiles.containsKey(grupoInfantil.getId())) {
            throw new Exception ("el grupo infantil "+grupoInfantil.getId()+" no existe!");
        }
        gruposInfantiles.put(grupoInfantil.getId(), grupoInfantil);
    }
    
    public static void eliminar (String grupoInfantil_id) throws Exception {
        if (!gruposInfantiles.containsKey(grupoInfantil_id)) {
            throw new Exception ("el grupo infantil "+grupoInfantil_id+" no existe!");
        }
        gruposInfantiles.remove(grupoInfantil_id);
    }
    
    public static List<GrupoInfantil> listarTodo () {
        return new ArrayList<>(gruposInfantiles.values());
    }
    
    public static int contarTodo () {
        return gruposInfantiles.size();
    }
}
