package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	   private LocalTime ora;
	   private BigDecimal prezzo;
	   
	   public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
	        super(titolo, data, numeroPostiTotali);
	        this.ora = ora;
	        this.prezzo = prezzo;
	    }
	   
	   public LocalTime getOra() {
	        return ora;
	    }

	    public void setOra(LocalTime ora) {
	        this.ora = ora;
	    }
	    
	    public BigDecimal getPrezzo() {
	        return prezzo;
	    }

	    public void setPrezzo(BigDecimal prezzo) {
	        this.prezzo = prezzo;
	    }
	    
	    public String getDataOraFormattata() {
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        DateTimeFormatter oraFormatter = DateTimeFormatter.ofPattern("HH:mm");

	        return getData().format(dateFormatter) + " " + ora.format(oraFormatter);

	    }
	    
	    public String getPrezzoFormattato() {
	        return prezzo.setScale(2).toString() + "€";
	    }

	    @Override
	    public String toString() {
	        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
	    }
}