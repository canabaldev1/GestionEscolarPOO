package CrudBD;

import Dominio.Aula;
import Infraestructura.Configuracion.BD.ConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 *
 * @author lm-carlos
 */
public class AulaCrudBD {

    private EntityManagerFactory conexion;

    public AulaCrudBD() {
        conexion = ConexionBD.conectar();
    }

    // GUARDAR
    public void guardar(Aula aula) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.persist(aula);

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al guardar aula " + aula.getId() + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // BUSCAR POR ID
    public Aula buscar(Long id) throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.find(Aula.class, id);
        } catch (Exception e) {
            throw new Exception("Error al buscar aula con ID " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // ACTUALIZAR
    public void actualizar(Aula aula) throws Exception {
        EntityManager entityManager = null;
        EntityTransaction transaccion = null;

        try {
            entityManager = conexion.createEntityManager();
            transaccion = entityManager.getTransaction();
            transaccion.begin();

            entityManager.merge(aula); // Actualiza

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al actualizar aula " + aula.getId() + ": " + e.getMessage(), e);
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

            Aula aulaBuscado = entityManager.find(Aula.class, id);
            if (aulaBuscado != null) {
                entityManager.remove(aulaBuscado);
            } else {
                throw new Exception("No se encontró aula con ID " + id);
            }

            transaccion.commit();
        } catch (Exception e) {
            if (transaccion != null && transaccion.isActive()) {
                transaccion.rollback();
            }
            throw new Exception("Error al eliminar aula " + id + ": " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    // LISTAR TODOS
    public List<Aula> listarTodos() throws Exception {
        EntityManager entityManager = null;

        try {
            entityManager = conexion.createEntityManager();
            return entityManager.createQuery("SELECT c FROM Aula c", Aula.class)
                                .getResultList();
        } catch (Exception e) {
            throw new Exception("Error al listar aula: " + e.getMessage(), e);
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
