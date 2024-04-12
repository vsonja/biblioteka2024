package biblioteka;

import java.util.List;
import java.util.Objects;

/**
 * Predstavlja elektronsku ili stampanu knjigu.
 * 
 * Moze imati autora, naslov, izdavaca, izdanje i ISBN broj.
 * 
 * @author Sonja
 * @since 0.1.0
 *
 */
public class Knjiga {

	/**
	 * Naslov knjige kao String.
	 */
	private String naslov;
	
	/**
	 * ISBN broj knjige koji bi trebalo da ima 9 ili 13 cifara.
	 */
	private long isbn;
	
	/**
	 * Lista autora knjige.
	 * 
	 * Lista moze biti i prazna ili null u slucajevima da je autor knjige nepoznat.
	 */
	private List<Autor> autori;
	
	/**
	 * Naziv izdavaca knjige kao String.
	 */
	private String izdavac;
	
	/**
	 * Izdanje knjige kao ceo broj.
	 */
	private int izdanje;

	/**
	 * Vraca naslov knjige.
	 * 
	 * @return Naslov knjige kao String.
	 */
	public String getNaslov() {
		return naslov;
	}

	/**
	 * Postavlja vrednost atributa naslov.
	 * 
	 * Naslov ne sme biti null niti prazan String.
	 * 
	 * @param naslov Nova vrednost za naslov knjige.
	 * 
	 * @throws NullPointerException Ako se unese null vrednost za naslov.
	 * @throws IllegalArgumentException Ako se unese prazan String kao naslov.
	 */
	public void setNaslov(String naslov) {
		if (naslov == null) {
			throw new NullPointerException("Naslov ne sme biti null");
		}

		if (naslov.isEmpty()) {
			throw new IllegalArgumentException("Naslov ne sme biti prazan");
		}
		
		this.naslov = naslov;
	}

	/**
	 * Vraca ISBN knjige.
	 * 
	 * @return ISBN knjige kao ceo broj.
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Postavlja vrednost za ISBN broj knjige.
	 * 
	 * ISBN broj mora biti veci od nule.
	 * 
	 * @param isbn ISBN broj knjige kao ceo broj koji mora imati 10-13 cifara.
	 * 
	 * @throws IllegalArgumentException Ako se unese ISBN broj koji ima manje od 10 ili vise od 13 cifara.
	 */
	public void setIsbn(long isbn) {
		if (isbn < 1000000000 || isbn > 9999999999999L) {
			throw new IllegalArgumentException("ISBN mora imati bar 10 cifara");
		}
		
		this.isbn = isbn;
	}

	/**
	 * Vraca listu autora knjige.
	 * 
	 * @return Listu sa autorima knjige, ili null ako knjiga nema poznate autore.
	 */
	public List<Autor> getAutori() {
		return autori;
	}

	/**
	 * Postavlja listu sa autorima knjige.
	 * 
	 * Lista ne sme biti null ili prazna ako knjiga nema poznate autore.
	 * 
	 * @param autori Lista sa autorima knjige.
	 */
	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	/**
	 * Vraca naziv izdavacke kuce koja je izdala knjigu.
	 * 
	 * @return Naziv izdavacke kuce za tu knjigu kao String.
	 */
	public String getIzdavac() {
		return izdavac;
	}

	/**
	 * Postavlja vrednost atributa izdavac.
	 * 
	 * @param izdavac Nova vrednost za naziv izdavaca knjige.
	 * 
	 * @throws NullPointerException Ako se unese null vrednost za izdavaca.
	 * @throws IllegalArgumentException Ako se unese prazan String kao izdavac.
	 */
	public void setIzdavac(String izdavac) {
		if (izdavac == null) {
			throw new NullPointerException("Izdavac ne sme biti null");
		}

		if (izdavac.isEmpty()) {
			throw new IllegalArgumentException("Izdavac ne sme biti prazan");
		}
		
		this.izdavac = izdavac;
	}

	/**
	 * Vraca izdanje knjige.
	 * 
	 * @return Izdanje knjige kao ceo broj.
	 */
	public int getIzdanje() {
		return izdanje;
	}

	/**
	 * Postavlja vrednost za izdanje knjige.
	 * 
	 * Broj izdanja mora biti veci od nule.
	 * 
	 * @param izdanje Broj izdanja kao ceo broj.
	 * 
	 * @throws IllegalArgumentException Ako se unese broj izdanja koji je manji od 1.
	 */
	public void setIzdanje(int izdanje) {
		if (izdanje < 1) {
			throw new IllegalArgumentException("Izdanje mora biti 1 ili vece");
		}
		
		this.izdanje = izdanje;
	}

	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", isbn=" + isbn + ", autori=" + autori + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	/**
	 * Izracunava hash code na osnovu ISBN broja.
	 * 
	 * @return Hash code na osnovu ISBN broja.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	/**
	 * Poredi dve knjige preko ISBN broja.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true - Ako je ISBN broj obe knjige isti ili ako je unet isti objekat.</li>
	 * 		<li>false - Ako je unet null objekat ili ako nije klase Knjiga.</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return isbn == other.isbn;
	}

}
