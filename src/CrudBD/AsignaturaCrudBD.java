package CrudBD;

import Dominio.Asignatura;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lm-carlos
 */
public class AsignaturaCrudBD {

    private EntityManagerFactory conexion;

    public AsignaturaCrudBD() {
        conexion = ConexionBD.conectar();
    }

    // GUARDAR
    public void guardar(Asignatura asignatura) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.persist(asignatura);

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar asignatura " + asignatura.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // BUSCAR POR ID
    public Asignatura buscar(Long id) throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.find(Asignatura.class, id);
        } catch (Exception e) {
            throw new Exception("Error al buscar asignatura con ID " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ACTUALIZAR
    public void actualizar(Asignatura asignatura) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.merge(asignatura); // Actualiza

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar asignatura " + asignatura.getId() + ": " + e.getMessage(), e);
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

            Asignatura asignaturaBuscado = entityManager.find(Asignatura.class, id);
            if (asignaturaBuscado != null) {
                entityManager.remove(asignaturaBuscado);
            } else {
                throw new Exception("No se encontró asignatura con ID " + id);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar asignatura " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // LISTAR TODOS
    public List<Asignatura> listarTodos() throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.createQuery("SELECT c FROM Asignatura c", Asignatura.class)
                                .getResultList();
        } catch (Exception e) {
            throw new Exception("Error al listar asignatura: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
