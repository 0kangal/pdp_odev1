package UzaySimilasyonu;

import lombok.Getter;

@Getter
public class Kisi {
	private String isim;
	private int yas;
	private  int kalan_omur;
	private char bulundugu_uzay_aracı_adi;
	private boolean yasiyormu;
	
	
	public Kisi(String isim, int yas, int kalan_omur, char bulundugu_uzay_aracı_adi) {
		this.isim = isim;
		this.yas = yas;
		this.kalan_omur = kalan_omur;
		this.bulundugu_uzay_aracı_adi = bulundugu_uzay_aracı_adi;
		this.yasiyormu = true;
	}
}
