package application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 3);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();

		System.out.println("Concluded!");
		em.close();
		emf.close();

	}

}
