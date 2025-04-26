package UzaySimilasyonu;

import java.util.ArrayList;
import java.util.List;

public class UzayAraci {

    public enum Durum {
        IMHA,
    	Bekliyor,
        Yolda,
        Vardi
    }

    private String ad;
    private Gezegen cikisGezegeni;
    private Gezegen varisGezegeni;
    private Zaman cikisTarihi;
    private Zaman varisTarihi;
    private int mesafeSaat;
    private Durum durum;
    private List<Kisi> yolcular;
    
    public UzayAraci(String ad, Gezegen cikis, Gezegen varis, Zaman cikisTarihi, int mesafeSaat) {
        this.ad = ad;
        this.cikisGezegeni = cikis;
        this.varisGezegeni = varis;
        this.cikisTarihi = cikisTarihi;
        this.mesafeSaat = mesafeSaat;
        this.varisTarihi = HesaplaVarisTarihi();
        this.durum = Durum.Bekliyor;
        this.yolcular = new ArrayList<>();
    }

    public void yolcuEkle(Kisi kisi) {
        yolcular.add(kisi);
    }

    public void saatIlerle() {
    	if(durum == Durum.IMHA) { return; }
    	
    	for(Kisi yolcu: yolcular) {
    		yolcu.saatIlerle();
    	}
    	
    	if(durum == Durum.Yolda && mesafeSaat > 0) { mesafeSaat--; }
    	
    	durumKontrol();
    	
    }

    private void durumKontrol() {
        if (durum == Durum.IMHA) return;

        if (!YasayanVarMi()) {
            durum = Durum.IMHA;
            return;
        }

        if (this.mesafeSaat == 0) {
            durum = Durum.Vardi;
            return;
        }

        Zaman gezegenTarihi = cikisGezegeni.getGezegendeki_tarih();

        if (gezegenTarihi.smaller(cikisTarihi)) {
            durum = Durum.Bekliyor;
        } else {
            durum = Durum.Yolda;
        }
    }
    
    public void nufusaEkle() {
    	if(durum == Durum.IMHA || durum == Durum.Yolda) { return; }
    	
        Gezegen hedefGezegen = null;

        if (durum == Durum.Bekliyor) {
            hedefGezegen = cikisGezegeni;
        } else if (durum == Durum.Vardi) {
            hedefGezegen = varisGezegeni;
        }

        if (hedefGezegen != null) {
            for (Kisi kisi : yolcular) {
                if (kisi.isYasiyor()) {
                    hedefGezegen.nufusuArtir();
                }
            }
        }
    }
    
    private boolean YasayanVarMi() {
		for (Kisi yolcu : yolcular) {
	        if (yolcu.isYasiyor()) {
	            return true;
	        }
	    }
	    return false;
	}
    
    private Zaman HesaplaVarisTarihi() {
    	int beklemeGunFarki = cikisGezegeni.getGezegendeki_tarih().gunFarki(cikisTarihi);
    	int beklemeSaat = beklemeGunFarki * cikisGezegeni.getGunun_kac_saat_oldugu();
    	int toplamSaat = beklemeSaat + mesafeSaat;
    	
    	int gunSayisi = toplamSaat/varisGezegeni.getGunun_kac_saat_oldugu();
    	
    	Zaman varis = new Zaman(varisGezegeni.getGezegendeki_tarih());
    	
    	for (int i = 0; i < gunSayisi; i++) {
            varis.birGunIlerle();
        }

        return varis;
    	
    }

	// Getter'lar
    public String getAd() { return ad; }
    public Gezegen getCikisGezegeni() { return cikisGezegeni; }
    public Gezegen getVarisGezegeni() { return varisGezegeni; }
    public Zaman getCikisTarihi() { return cikisTarihi; }
    public Zaman getVarisTarihi() { return varisTarihi; }
    public int getMesafeSaat() { return mesafeSaat; }
    public Durum getDurum() { return durum; }
    public List<Kisi> getYolcular() { return yolcular; }
    
}


