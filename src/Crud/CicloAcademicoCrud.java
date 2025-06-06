package Crud;

import Dominio.CicloAcademico;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class CicloAcademicoCrud {
    public static HashMap<String, CicloAcademico> ciclosAcademicos = new HashMap<>();
    
    public static void agregar (CicloAcademico cicloAcademico) throws Exception {
        if (ciclosAcademicos.containsKey(cicloAcademico.getId().toString())) {
            throw new Exception ("el ciclo academico "+cicloAcademico.getId().toString()+" ya existe!");
        }
        ciclosAcademicos.put(cicloAcademico.getId().toString(), cicloAcademico );
    }

    public static CicloAcademico buscar (String cicloAcademico_id) throws Exception {
        if (!ciclosAcademicos.containsKey(cicloAcademico_id)) {
            throw new Exception ("el ciclo academicono "+cicloAcademico_id+" existe!");
        }
        return ciclosAcademicos.get(cicloAcademico_id);
    }

    public static void editar (CicloAcademico cicloAcademico) throws Exception {
        if (!ciclosAcademicos.containsKey(cicloAcademico.getId().toString())) {
            throw new Exception ("el ciclo academicono "+cicloAcademico.getId().toString()+" existe!");
        }
        ciclosAcademicos.put(cicloAcademico.getId().toString(), cicloAcademico);
    }
    
    public static void eliminar (String cicloAcademico_id) throws Exception {
        if (!ciclosAcademicos.containsKey(cicloAcademico_id)) {
            throw new Exception ("el ciclo academicono "+cicloAcademico_id+" existe!");
        }
        ciclosAcademicos.remove(cicloAcademico_id);
    }
    
    public static List<CicloAcademico> listarTodo () {
        return new ArrayList<>(ciclosAcademicos.values());
    }
    
    public static int contarTodo () {
        return ciclosAcademicos.size();
    }
}

