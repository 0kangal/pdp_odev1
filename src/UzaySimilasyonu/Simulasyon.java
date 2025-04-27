package UzaySimilasyonu;

import java.util.*;

public abstract class Simulasyon {
	
	public static void simulasyonBaslat(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
        boolean tamamlandi = false;

        while (!tamamlandi) {
        	
            nufuslariHesapla(gezegenler, araclar);
            
            ekraniGuncelle(gezegenler, araclar);
            
            for (Gezegen g : gezegenler) { g.saatIlerle(); }

            for (UzayAraci u : araclar) { u.saatIlerle(); }

            tamamlandi = araclar.stream().allMatch(a ->a.getDurum() == UzayAraci.Durum.Vardi || a.getDurum() == UzayAraci.Durum.IMHA);

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Simülasyon bittiğinde final ekranı
        nufuslariHesapla(gezegenler, araclar);
        clearConsole();
        ekraniGuncelle(gezegenler, araclar);
        System.out.println("\n--- Simülasyon Tamamlandı ---");
    }
	
	private static void ekraniGuncelle(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
	    clearConsole();

	    List<Gezegen> gezegenList = new ArrayList<>(gezegenler);

	    // Sort gezegenList alphabetically by Gezegen_adi
	    gezegenList.sort(Comparator.comparing(Gezegen::getGezegen_adi));

	    System.out.println("\nGezegenler:");

	    // Başlık satırı
	    System.out.printf("%-15s", ""); // Sol boşluk
	    for (Gezegen g : gezegenList) {
	        System.out.printf("%-15s", "--- " + g.getGezegen_adi() + " ---");
	    }
	    System.out.println();

	    // Tarihler satırı (using 12-character width for dates)
	    System.out.printf("%-15s", "Tarih");
	    for (Gezegen g : gezegenList) {
	        String dateStr = g.getGezegendeki_tarih().toString();
	        // Limit date to 12 characters width
	        System.out.printf("%-15s", String.format("%-15s", dateStr));
	    }
	    System.out.println();

	    // Nüfuslar satırı (using 10-character width for population)
	    System.out.printf("%-15s", "Nüfus");
	    for (Gezegen g : gezegenList) {
	        String nufusStr = String.valueOf(g.getNufus());
	        // Keep population within 10 characters width
	        System.out.printf("%-15s", String.format("%-15s", nufusStr));
	    }
	    System.out.println("\n");

	    System.out.println("Uzay Araçları:");
	    System.out.printf("%-15s %-15s %-15s %-15s %-25s %-25s%n", "Araç Adı", "Durum", "Çıkış", "Varış", "Hedefe Kalan Saat", "Hedefe Varacağı Tarih");

	    for (UzayAraci a : araclar) {
	        String ad = a.getAd();
	        String durum = a.getDurum().toString(); // Artık olduğu gibi kullanıyoruz
	        String cikis = a.getCikisGezegeni().getGezegen_adi();
	        String varis = a.getVarisGezegeni().getGezegen_adi();
	        String kalanSaat = durum.equalsIgnoreCase("İmha") ? "--" : String.valueOf(a.getMesafeSaat());
	        String varisTarihi = durum.equalsIgnoreCase("İmha") ? "--" : a.getVarisTarihi().toString();

	        System.out.printf("%-15s %-15s %-15s %-15s %-25s %-25s%n", ad, durum, cikis, varis, kalanSaat, varisTarihi);
	    }
	}





	private static void clearConsole() {
	    try {
	        String os = System.getProperty("os.name").toLowerCase();

	        if (os.contains("win")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (Exception e) {
	    	
	        }
	    }
	
	private  static void nufuslariHesapla(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
		
        for (Gezegen gezegen : gezegenler) {
            gezegen.nufusuSifirla();
        }
        
        for (UzayAraci arac : araclar) {
            arac.nufusaEkle();
        }
    }

}


