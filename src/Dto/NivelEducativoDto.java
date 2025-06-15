package Dto;

import CrudBD.NivelEducativoCrudBD;
import Dominio.NivelEducativo;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class NivelEducativoDto {
    
    public static NivelEducativo buscar(Long id) {

        NivelEducativoCrudBD nivelEducativoCrud = new NivelEducativoCrudBD();
        try {
            NivelEducativo nivelEducativoBuscado = nivelEducativoCrud.buscar(id);
            return nivelEducativoBuscado;

        } catch (Exception e) {
            return new NivelEducativo();
        }
    }

    public static void guardar(NivelEducativo nivelEducativo) throws Exception {
        NivelEducativoCrudBD nivelEducativoCrud = new NivelEducativoCrudBD();
        nivelEducativoCrud.guardar(nivelEducativo);
    }

    public static void editar(NivelEducativo nivelEducativo) throws Exception {
        NivelEducativoCrudBD nivelEducativoCrud = new NivelEducativoCrudBD();
        nivelEducativoCrud.actualizar(nivelEducativo);
    }

    public static void eliminar(Long id) throws Exception {
        NivelEducativoCrudBD nivelEducativoCrud = new NivelEducativoCrudBD();
        nivelEducativoCrud.eliminar(id);
    }

    public static List<NivelEducativo> listarTodo() throws Exception {
        NivelEducativoCrudBD nivelEducativoCrud = new NivelEducativoCrudBD();
        return nivelEducativoCrud.listarTodos();
    }

}
