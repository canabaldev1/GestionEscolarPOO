package Crud;

import Dominio.BloqueHorario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class BloqueHorarioCrud {
    public static HashMap<String, BloqueHorario> bloquesHorarios = new HashMap<>();
    
    public static void agregar (BloqueHorario bloqueHorario) throws Exception {
        if (bloquesHorarios.containsKey(bloqueHorario.getId())) {
            throw new Exception ("el bloque horario ya existe!");
        }
        bloquesHorarios.put(bloqueHorario.getId(), bloqueHorario );
    }

    public static BloqueHorario buscar (String bloqueHorario_id) throws Exception {
        if (!bloquesHorarios.containsKey(bloqueHorario_id)) {
            throw new Exception ("el bloque horario no existe!");
        }
        return bloquesHorarios.get(bloqueHorario_id);
    }

    public static void editar (BloqueHorario bloqueHorario) throws Exception {
        if (!bloquesHorarios.containsKey(bloqueHorario.getId())) {
            throw new Exception ("el bloque horario no existe!");
        }
        bloquesHorarios.put(bloqueHorario.getId(), bloqueHorario);
    }
    
    public static void eliminar (String bloqueHorario_id) throws Exception {
        if (!bloquesHorarios.containsKey(bloqueHorario_id)) {
            throw new Exception ("el bloque horario no existe!");
        }
        bloquesHorarios.remove(bloqueHorario_id);
    }
    
    public static List<BloqueHorario> listarTodo () {
        return new ArrayList<>(bloquesHorarios.values());
    }
    
    public static int contarTodo () {
        return bloquesHorarios.size();
    }
}

