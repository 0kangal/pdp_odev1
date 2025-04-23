package UzaySimilasyonu;

import lombok.Getter;

@Getter
public class Kisi {
	private String isim;
	private int yas;
	private  int kalan_omur; //hour
	private UzayAraci bulunduguUzayAraci;
	private boolean yasiyormu;
	
	
	public Kisi(String isim, int yas, int kalan_omur, UzayAraci bulunduguUzayAraci) {
		this.isim = isim;
		this.yas = yas;
		this.kalan_omur = kalan_omur;
		this.bulunduguUzayAraci = bulunduguUzayAraci;
		this.yasiyormu = true;
	}
	
	public void saatIlerle() {
        if (yasiyormu) {
            kalan_omur--;
            if (kalan_omur <= 0) {
                yasiyormu = false;
            }
        }
    }
}

