package Pruebas.Crud;

import CrudBD.AlumnoCrudBD;
import Dominio.Alumno;
import java.util.List;

/**
 *
 * @author lm-carlos
 */
public class AlumnoPrueba {
    
    public static void agregarAlumno (String nombre, String apellido, String password, String email) {
        AlumnoCrudBD alumnoCrudBD = new AlumnoCrudBD();
        
        try {
            Alumno nuevoAlumno = new Alumno(nombre, apellido, password, email);
            alumnoCrudBD.guardar(nuevoAlumno);
            
        } catch (Exception e) {
            System.err.println("ERROR: \n"+e.getMessage());
        }
    }
    
        public static void listarTodosAlumnos () {
        AlumnoCrudBD alumnoCrudBD = new AlumnoCrudBD();
        
        try {
            List<Alumno> alumnos = alumnoCrudBD.listarTodos();
            
            System.out.println(alumnos);
            
        } catch (Exception e) {
            System.err.println("ERROR: \n"+e.getMessage());
        }
    }

}
