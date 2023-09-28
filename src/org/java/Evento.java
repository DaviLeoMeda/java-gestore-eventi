package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int numPostiTotale;
	private int numPostiPrenotati;
	
	public Evento(String titolo, LocalDate data, int numPostiTotale) throws Exception {
		setTitolo(titolo);
		setData(data);
		setNumPostiTotale(numPostiPrenotati);
		setNumPostiPrenotati(0);
	}
	
	public Evento(String titolo, String data, int numPostiTotale) throws Exception {
		setTitolo(titolo);
		setData(data);
		setNumPostiTotale(numPostiPrenotati);
		setNumPostiPrenotati(0);
	}
	


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		
		if(data.isBefore(LocalDate.now()))
			throw new Exception("Non puoi prenotare per un evento già avvenuto");
		
		this.data = data;
	}
	
public void setData(String data) throws Exception {
		
		LocalDate tmpData = LocalDate.parse(data);
		System.out.println("tmp data: " + tmpData);
	}

	public int getNumPostiTotale() {
		
		return numPostiTotale;
	}

	private void setNumPostiTotale(int numPostiTotale) throws Exception {
		
		if(numPostiTotale <= 0)
			throw new Exception("Non puoi prenotare in negativo");
		
		
		this.numPostiTotale = numPostiTotale;
	}

	public int getNumPostiPrenotati() {
		return numPostiPrenotati;
	}

	private void setNumPostiPrenotati(int numPostiPrenotati) {
		this.numPostiPrenotati = numPostiPrenotati;
	}
	
	public void prenota() throws Exception {
		if(numPostiPrenotati >= numPostiTotale || getData().isBefore(LocalDate.now()))
			throw new Exception ("Posti non più disponibili per questa data, ci spiace");
		
		numPostiPrenotati++;
	}
	
	public void annulla() throws Exception {
		
		if(numPostiPrenotati == 0 || getData().isBefore(LocalDate.now()))
			throw new Exception ("Non risultano posti prenotati per quella data");
		
		numPostiPrenotati--;
	}
	
	@Override
	public String toString() {
		
		return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + getTitolo();
	}
	
	
	
	
	
	
	
	
}
