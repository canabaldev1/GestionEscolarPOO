package Dto;

import CrudBD.AdministrativoCrudBD;
import Dominio.Administrativo;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AdministrativoDto {
    public static Administrativo buscar(Long id) {

        AdministrativoCrudBD administrativoCrud = new AdministrativoCrudBD();
        try {
            Administrativo administrativoBuscado = administrativoCrud.buscar(id);
            return administrativoBuscado;

        } catch (Exception e) {
            return new Administrativo();
        }
    }

    public static void guardar(Administrativo administrativo) throws Exception {
        AdministrativoCrudBD administrativoCrud = new AdministrativoCrudBD();
        administrativoCrud.guardar(administrativo);
    }

    public static void editar(Administrativo administrativo) throws Exception {
        AdministrativoCrudBD administrativoCrud = new AdministrativoCrudBD();
        administrativoCrud.actualizar(administrativo);
    }

    public static void eliminar(Long id) throws Exception {
        AdministrativoCrudBD administrativoCrud = new AdministrativoCrudBD();
        administrativoCrud.eliminar(id);
    }

    public static List<Administrativo> listarTodo() throws Exception {
        AdministrativoCrudBD administrativoCrud = new AdministrativoCrudBD();
        return administrativoCrud.listarTodos();
    }
}
