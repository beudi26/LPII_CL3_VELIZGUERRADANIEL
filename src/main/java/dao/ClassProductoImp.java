package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProducto;
import model.TblProductocl3;

public class ClassProductoImp implements IProducto{

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(producto);
		System.out.println("Producto registrado correctamente");
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void ActualizarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarProducto(TblProductocl3 producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TblProductocl3> ListarProducto() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL3_VELIZGUERRADANIEL");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<TblProductocl3> listado = em.createQuery("SELECT p FROM TblProductocl3 p",TblProductocl3.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listado;
	}

}
