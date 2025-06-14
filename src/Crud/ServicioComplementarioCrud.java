package Crud;

import Dominio.ServicioComplementario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ServicioComplementarioCrud {

    public static HashMap<String, ServicioComplementario> serviciosComplementarios = new HashMap<>();

    public static void agregar(ServicioComplementario servicioComplementario) throws Exception {
        if (serviciosComplementarios.containsKey(servicioComplementario.getId().toString())) {
            throw new Exception("el servicio complementario "+servicioComplementario.getId().toString()+" ya existe!");
        }
        serviciosComplementarios.put(servicioComplementario.getId().toString(), servicioComplementario);
    }

    public static ServicioComplementario buscar(String servicioComplementario_id) throws Exception {
        if (!serviciosComplementarios.containsKey(servicioComplementario_id)) {
            throw new Exception("el servicio complementario "+servicioComplementario_id+" no existe!");
        }
        return serviciosComplementarios.get(servicioComplementario_id);
    }

    public static void editar(ServicioComplementario servicioComplementario) throws Exception {
        if (!serviciosComplementarios.containsKey(servicioComplementario.getId().toString())) {
            throw new Exception("el servicio complementario "+servicioComplementario.getId().toString()+" no existe!");
        }
        serviciosComplementarios.put(servicioComplementario.getId().toString(), servicioComplementario);
    }

    public static void eliminar(String servicioComplementario_id) throws Exception {
        if (!serviciosComplementarios.containsKey(servicioComplementario_id)) {
            throw new Exception("el servicio complementario "+servicioComplementario_id+" no existe!");
        }
        serviciosComplementarios.remove(servicioComplementario_id);
    }

    public static List<ServicioComplementario> listarTodo() {
        return new ArrayList<>(serviciosComplementarios.values());
    }

    public static int contarTodo() {
        return serviciosComplementarios.size();
    }
}
