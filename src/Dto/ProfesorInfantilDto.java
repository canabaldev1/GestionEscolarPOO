package Dto;

import CrudBD.ProfesorInfantilCrudBD;
import Dominio.ProfesorInfantil;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ProfesorInfantilDto {
    public static ProfesorInfantil buscar(Long id) {

        ProfesorInfantilCrudBD profesorInfantilCrud = new ProfesorInfantilCrudBD();
        try {
            ProfesorInfantil profesorInfantilBuscado = profesorInfantilCrud.buscar(id);
            return profesorInfantilBuscado;

        } catch (Exception e) {
            return new ProfesorInfantil();
        }
    }

    public static void guardar(ProfesorInfantil profesorInfantil) throws Exception {
        ProfesorInfantilCrudBD profesorInfantilCrud = new ProfesorInfantilCrudBD();
        profesorInfantilCrud.guardar(profesorInfantil);
    }

    public static void editar(ProfesorInfantil profesorInfantil) throws Exception {
        ProfesorInfantilCrudBD profesorInfantilCrud = new ProfesorInfantilCrudBD();
        profesorInfantilCrud.actualizar(profesorInfantil);
    }

    public static void eliminar(Long id) throws Exception {
        ProfesorInfantilCrudBD profesorInfantilCrud = new ProfesorInfantilCrudBD();
        profesorInfantilCrud.eliminar(id);
    }

    public static List<ProfesorInfantil> listarTodo() throws Exception {
        ProfesorInfantilCrudBD profesorInfantilCrud = new ProfesorInfantilCrudBD();
        return profesorInfantilCrud.listarTodos();
    }
}
