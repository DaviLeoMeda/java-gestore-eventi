package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.println("Evento: ");
            String eventoTitle = scanner.nextLine();
            
            System.out.println("Concerto: ");
            String concertoTitle = scanner.nextLine();

            System.out.println("Data: ");
            String dataStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Num Posti disponibili: ");
            int numeroPostiTotali = Integer.parseInt(scanner.nextLine());
            
            System.out.println("Inserisci l'ora: ");
            String oraStr = scanner.nextLine();
            LocalTime ora = LocalTime.parse(oraStr, DateTimeFormatter.ofPattern("HH:mm"));
            
            System.out.println("Prezzo: ");
            BigDecimal prezzo = new BigDecimal(scanner.nextLine());

            
            Evento ev1 = new Evento(eventoTitle, data, numeroPostiTotali);
            
            Concerto esong1 = new Concerto(concertoTitle, data, numeroPostiTotali, ora, prezzo);
            
            
            System.out.println("Evento:");
            System.out.println(ev1.toString());

            
            System.out.println("Vuoi effettuare delle prenotazioni? (y/n)");
            String risposta = scanner.nextLine().toLowerCase();
            
            while (risposta.equals("y")) {
                try {
                	ev1.prenota();
                    System.out.println("Prenotazione effettuata con successo.");
                } catch (Exception e) {
                    System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                }

                System.out.println("Vuoi effettuare un'altra prenotazione? (y/n)");
                risposta = scanner.nextLine().toLowerCase();
            }

            
            System.out.println("Numero di posti prenotati: " + ev1.getNumPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (ev1.getNumPostiPrenotati() - ev1.getNumPostiPrenotati()));

            
            System.out.println("Vuoi disdire dei posti? (y/n)");
            risposta = scanner.nextLine().toLowerCase();

            while (risposta.equals("y")) {
                try {
                	ev1.annulla();
                    System.out.println("Disdetta effettuata con successo.");
                } catch (Exception e) {
                    System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
                }

                System.out.println("Vuoi effettuare un'altra disdetta? (Sì/No)");
                risposta = scanner.nextLine().toLowerCase();
            }

            
            System.out.println("Numero di posti prenotati: " + ev1.getNumPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (ev1.getNumPostiPrenotati() - ev1.getNumPostiPrenotati()));
            
            
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
	}
}