package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Orders;
import entities.Worker;
import entities.enums.OrdersStatus;
import entities.enums.WorkerLevel;

public class Program {
	public static void main(String args[]) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base salary: ");
		double baseSalary= sc.nextDouble();
		
		Worker worker = new Worker(workerName, 
				WorkerLevel.valueOf(workerLevel), 
				baseSalary, 
				new Department(departmentName)); //Associação entretrabalhador e departamento
		
		System.out.print("\nHow many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("\nEnter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			//LocalDate contractDate = LocalDate.parse(sc.nextLine());
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.print("\nEnter month and yar ro calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("\nName: " + worker.getName());
		
		System.out.println("Department: " + worker.getDepartment().getName());
		
		System.out.println("Income for " + monthAndYear + ": "
		+ String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}

	private static void exemplo() {
		Orders order = new Orders(1080, new Date(), OrdersStatus.PENDING_PAYMENT);

		System.out.println(order);

		OrdersStatus os1 = OrdersStatus.DELIVERED;

		OrdersStatus os2 = OrdersStatus.valueOf("DELIVERED");

		System.out.println(os1 + "\n" + os2);

	}
}
