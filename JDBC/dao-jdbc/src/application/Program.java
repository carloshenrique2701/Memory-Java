package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ===\n");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment===\n");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for (Seller s : sellers) {
			System.out.println(s);
		}
		
		System.out.println("\n=== Test 3: seller findAll===\n");
		sellers = sellerDao.findAll();
		for (Seller s : sellers) {
			System.out.println(s);
		}

		System.out.println("\n=== Test 4: seller insert===\n");
		Seller newSeller = new Seller(null, "Thania", "thania@gmail.com", new Date(), 2400.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n=== Test 5: seller update===\n");
		seller = sellerDao.findById(1);
		seller.setName("Wagner Dantes");
		sellerDao.update(seller);
		System.out.println("Updated!");

		System.out.println("\n=== Test 6: seller delete===\n");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Deleted!");
		
		sc.close();
		
	}

}
