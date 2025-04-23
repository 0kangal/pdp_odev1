package UzaySimilasyonu;
import lombok.Getter;

@Getter
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
	
}

