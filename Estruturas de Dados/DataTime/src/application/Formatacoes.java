package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Formatacoes {
public static void main(String args[]) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		//Para formatar um Instant é necessário falar o fuso horário
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
		
		
		LocalDate d04 = LocalDate.parse("2026-02-26");
		LocalDateTime d05 = LocalDateTime.parse("2026-02-26T01:30:26");
		Instant d06 = Instant.parse("2026-02-26T01:30:26Z");
		Instant d07 = Instant.parse("2026-02-26T01:30:26-03:00");
		
		
		System.out.println("d04 = " + d04.format(fmt1) + "\n");
		
		System.out.println("d05 = " + fmt1.format(d05) + "\n");
		System.out.println("d05 = " + fmt2.format(d05) + "\n");
		System.out.println("d05 = " + fmt4.format(d05) + "\n");
		
		System.out.println("d06 = " + fmt3.format(d06) + "\n");
		System.out.println("d06 = " + fmt5.format(d06) + "\n");
		System.out.println("d07 = " + d07 + "\n");
		
		
	}
}
