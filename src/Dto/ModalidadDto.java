package Dto;

import CrudBD.ModalidadCrudBD;
import Dominio.Modalidad;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class ModalidadDto {
    
    public static Modalidad buscar(Long id) {

        ModalidadCrudBD modalidadCrud = new ModalidadCrudBD();
        try {
            Modalidad modalidadBuscado = modalidadCrud.buscar(id);
            return modalidadBuscado;

        } catch (Exception e) {
            return new Modalidad();
        }
    }

    public static void guardar(Modalidad modalidad) throws Exception {
        ModalidadCrudBD modalidadCrud = new ModalidadCrudBD();
        modalidadCrud.guardar(modalidad);
    }

    public static void editar(Modalidad modalidad) throws Exception {
        ModalidadCrudBD modalidadCrud = new ModalidadCrudBD();
        modalidadCrud.actualizar(modalidad);
    }

    public static void eliminar(Long id) throws Exception {
        ModalidadCrudBD modalidadCrud = new ModalidadCrudBD();
        modalidadCrud.eliminar(id);
    }

    public static List<Modalidad> listarTodo() throws Exception {
        ModalidadCrudBD modalidadCrud = new ModalidadCrudBD();
        return modalidadCrud.listarTodos();
    }
}
