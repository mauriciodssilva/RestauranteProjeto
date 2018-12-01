package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Entidades.ItemCardapio;
import model.dao.util.JPAManager;

public class ItemCardapioDaoImpl extends DAOImpl implements ItemCardapioDao{

	public ItemCardapio buscarPorNome(String nome) {
		ItemCardapio itemCardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemCardapio where nome = :nome");
			itemCardapio = (ItemCardapio) query.getSingleResult();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemCardapio;
	}

	@SuppressWarnings("unchecked")
	public List<ItemCardapio> listarTodos(){
		List<ItemCardapio> itemCardapio = null;
		EntityManager mng = JPAManager.getInstance().getEntityManager();
		try {
			mng.getTransaction().begin();
			Query query = mng.createQuery("FROM ItemCardapio");
			itemCardapio = query.getResultList();
		}catch (Exception e) {
			mng.getTransaction().rollback();
		} finally {
			mng.close();
		}
		return itemCardapio;
	}
}
