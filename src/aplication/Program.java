package aplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter car rental data: ");
		System.out.print("Car model: ");
		String carModel = scan.nextLine();
		System.out.print("car removal date (dd/MM/yyyy HH:mm): ");
		LocalDateTime start = LocalDateTime.parse(scan.nextLine(), dtf);
		System.out.print("Car return date (dd/MM/yyyy HH:mm): ");
		LocalDateTime finish = LocalDateTime.parse(scan.nextLine(), dtf);

		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.println();
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = scan.nextDouble();
		System.out.print("Enter price per day: ");
		Double pricePerDay = scan.nextDouble();

		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(carRental);

		System.out.println();

		System.out.println("INVOICE: ");
		System.out.println("Basic Payment: " + carRental.getInvoice().getBasicPayment());
		System.out.println("Tax: " + carRental.getInvoice().getTax());
		System.out.println("Total payment: " + carRental.getInvoice().getTotalPayment());
		
		scan.close();
	}
}
