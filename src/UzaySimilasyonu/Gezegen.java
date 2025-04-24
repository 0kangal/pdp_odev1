package UzaySimilasyonu;

public class Gezegen {

	private String gezegen_adi;
	private int gunun_kac_saat_oldugu;
	private Zaman gezegendeki_tarih;
	private int nufus;
	private int saat_sayaci;
	
	public Gezegen(String gezegen_adi, int gunun_kac_saat_oldugu, Zaman gezegendeki_tarih) {
		this.gezegen_adi = gezegen_adi;
		this.gunun_kac_saat_oldugu = gunun_kac_saat_oldugu;
		this.gezegendeki_tarih = gezegendeki_tarih;
		this.nufus = 0;
		this.saat_sayaci = 0;
	}
	
	public void saatIlerle() {
        saat_sayaci++;
        if (saat_sayaci >= gunun_kac_saat_oldugu) {
            gezegendeki_tarih.birGunIlerle();
            saat_sayaci = 0;
        }
    }
	public void nufusuSifirla() {
	    this.nufus = 0;
	}

	public void nufusuArtir() {
	    this.nufus++;
	}
	
	public int getToplamSaat() { return gezegendeki_tarih.toplamGunSayisi()*gunun_kac_saat_oldugu; }

	public String getGezegen_adi() { return gezegen_adi; }
	public int getGunun_kac_saat_oldugu() { return gunun_kac_saat_oldugu; }
	public Zaman getGezegendeki_tarih() { return new Zaman(gezegendeki_tarih); }
	public int getNufus() { return nufus; }
	public int getSaat_sayaci() { return saat_sayaci;}

}