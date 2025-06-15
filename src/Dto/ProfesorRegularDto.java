package Dto;

import CrudBD.ProfesorRegularCrudBD;
import Dominio.ProfesorRegular;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ProfesorRegularDto {
    public static ProfesorRegular buscar(Long id) {

        ProfesorRegularCrudBD profesorRegularCrud = new ProfesorRegularCrudBD();
        try {
            ProfesorRegular profesorRegularBuscado = profesorRegularCrud.buscar(id);
            return profesorRegularBuscado;

        } catch (Exception e) {
            return new ProfesorRegular();
        }
    }

    public static void guardar(ProfesorRegular profesorRegular) throws Exception {
        ProfesorRegularCrudBD profesorRegularCrud = new ProfesorRegularCrudBD();
        profesorRegularCrud.guardar(profesorRegular);
    }

    public static void editar(ProfesorRegular profesorRegular) throws Exception {
        ProfesorRegularCrudBD profesorRegularCrud = new ProfesorRegularCrudBD();
        profesorRegularCrud.actualizar(profesorRegular);
    }

    public static void eliminar(Long id) throws Exception {
        ProfesorRegularCrudBD profesorRegularCrud = new ProfesorRegularCrudBD();
        profesorRegularCrud.eliminar(id);
    }

    public static List<ProfesorRegular> listarTodo() throws Exception {
        ProfesorRegularCrudBD profesorRegularCrud = new ProfesorRegularCrudBD();
        return profesorRegularCrud.listarTodos();
    }
}
