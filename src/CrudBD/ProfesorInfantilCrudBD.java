package CrudBD;

import Dominio.ProfesorInfantil;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lm-carlos
 */
public class ProfesorInfantilCrudBD {

    private EntityManagerFactory conexion;

    public ProfesorInfantilCrudBD() {
        conexion = ConexionBD.conectar();
    }

    // GUARDAR
    public void guardar(ProfesorInfantil profesorInfantil) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.persist(profesorInfantil);

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar profesor infantil " + profesorInfantil.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // BUSCAR POR ID
    public ProfesorInfantil buscar(Long id) throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.find(ProfesorInfantil.class, id);
        } catch (Exception e) {
            throw new Exception("Error al buscar profesor infantil con ID " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ACTUALIZAR
    public void actualizar(ProfesorInfantil profesorInfantil) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.merge(profesorInfantil); // Actualiza

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar profesor infantil " + profesorInfantil.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ELIMINAR
    public void eliminar(String id) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            ProfesorInfantil profesorInfantilBuscado = entityManager.find(ProfesorInfantil.class, id);
            if (profesorInfantilBuscado != null) {
                entityManager.remove(profesorInfantilBuscado);
            } else {
                throw new Exception("No se encontró profesor infantil con ID " + id);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar profesor infantil " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // LISTAR TODOS
    public List<ProfesorInfantil> listarTodos() throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.createQuery("SELECT c FROM ProfesorInfantil c", ProfesorInfantil.class)
                                .getResultList();
        } catch (Exception e) {
            throw new Exception("Error al listar profesor infantil: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
