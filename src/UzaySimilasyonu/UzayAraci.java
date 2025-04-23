package UzaySimilasyonu;

import lombok.Getter;
import java.util.*;

@Getter
public class UzayAraci {

	private	String uzay_araci_adi;
	private Gezegen cikis_gezegeni;
	private Gezegen varis_gezegeni;
	private Zaman cikis_tarihi;
	private int mesafe_saat_olarak;
	private String durum;
	private List<Kisi> yolcular;
	
	public UzayAraci(String uzay_araci_adi, Gezegen cikis_gezegeni, Gezegen varis_gezegeni, Zaman cikis_tarihi, int mesafe_saat_olarak) {
		this.uzay_araci_adi = uzay_araci_adi;
		this.cikis_gezegeni = cikis_gezegeni;
		this.varis_gezegeni = varis_gezegeni;
		this.cikis_tarihi = cikis_tarihi;
		this.mesafe_saat_olarak = mesafe_saat_olarak;
		this.durum = "Bekliyor";
		this.yolcular = new ArrayList<>();
		
	}
	
	public void yolcuEkle(Kisi kisi) {
        yolcular.add(kisi);
    }
	
	public void saatIlerle() {
        
    }
	
	
}

