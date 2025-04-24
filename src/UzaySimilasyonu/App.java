package UzaySimilasyonu;

public class App {

	public static void main(String[] args) {
		Zaman a = new Zaman(24,04,2025);
		Zaman b = new Zaman(8,03,2003);
		Zaman cikis = new Zaman(1,05,2025);

		Gezegen x = new Gezegen("X", 20, a);
		Gezegen y = new Gezegen("Y", 10, b);
		
		UzayAraci arac = new UzayAraci("Arac1", x, y, cikis, 100);

		Kisi kisi = new Kisi("Ali", 30, 1000, arac);
		
		
		arac.yolcuEkle(kisi);

		System.out.println(x.getGezegen_adi()+" "+x.getGezegendeki_tarih()+" "+x.getNufus());
		System.out.println(y.getGezegen_adi()+" "+y.getGezegendeki_tarih()+" "+y.getNufus());

		System.out.println(arac.getAd()+ " "+arac.getDurum()+" "+arac.getCikisGezegeni().getGezegen_adi()
				+" "+arac.getVarisGezegeni().getGezegen_adi()+" "+arac.getMesafeSaat()+" "+arac.getVarisTarihi());
		
		// Her sey duzgun
		// Similasyondaki iterasyonu yapicaksin
		// Ekran ciktisini yapicaksin
	}

}
