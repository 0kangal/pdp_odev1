package UzaySimilasyonu;

import java.util.*;

public class Simulasyon {
	
	public static void simulasyonBaslat(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
        boolean tamamlandi = false;

        while (!tamamlandi) {
        	

            // 3. Nüfusları yeniden hesapla
            nufuslariHesapla(gezegenler, araclar);

            // 4. Ekranı güncelle (her saat)
            ekraniGuncelle(gezegenler, araclar);
            
            // 1. Gezegenlerin saati ilerlesin
            for (Gezegen g : gezegenler) {
                g.saatIlerle();
            }

            // 2. Uzay araçları ilerlesin (içinde kişileri de ilerletiyor)
            for (UzayAraci u : araclar) {
                u.saatIlerle();
            }

            // 5. Tüm araçlar "Vardi" ya da "IMHA" olduysa döngüyü bitir
            tamamlandi = araclar.stream().allMatch(a ->
                a.getDurum() == UzayAraci.Durum.Vardi || a.getDurum() == UzayAraci.Durum.IMHA
            );

            // 6. 0.5 saniye beklet (görsel takip için)
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Simülasyon bittiğinde final ekranı
        nufuslariHesapla(gezegenler, araclar);
        ekraniGuncelle(gezegenler, araclar);
        System.out.println("\n--- Simülasyon Tamamlandı ---");
    }
	
	public static void ekraniGuncelle(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
	    System.out.print("\033[H\033[2J"); // Konsol temizleme
	    System.out.flush();

	    List<Gezegen> gezegenList = new ArrayList<>(gezegenler);

	    System.out.println("\nGezegenler:");

	    // Başlık satırı
	    System.out.printf("%-15s", ""); // Sol boşluk
	    for (Gezegen g : gezegenList) {
	        System.out.printf("%-15s", "--- " + g.getGezegen_adi() + " ---");
	    }
	    System.out.println();

	    // Tarihler satırı
	    System.out.printf("%-15s", "Tarih");
	    for (Gezegen g : gezegenList) {
	        System.out.printf("%-15s", g.getGezegendeki_tarih());
	    }
	    System.out.println();

	    // Nüfuslar satırı (ortalı yazmak için)
	    System.out.printf("%-12s", "Nüfus");
	    for (Gezegen g : gezegenList) {
	        String nufusStr = String.valueOf(g.getNufus());
	        int totalWidth = 15;
	        int padding = (totalWidth - nufusStr.length()) / 2;
	        String format = "%" + (padding + nufusStr.length()) + "s";
	        System.out.printf(format + "%-" + (totalWidth - (padding + nufusStr.length())) + "s", nufusStr, "");
	    }
	    System.out.println("\n");

	    System.out.println("Uzay Araçları:");
	    System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s%n", "Araç Adı", "Durum", "Çıkış", "Varış", "Hedefe Kalan Saat", "Hedefe Varacağı Tarih");

	    for (UzayAraci a : araclar) {
	        String ad = a.getAd();
	        String durum = a.getDurum().toString(); // Artık olduğu gibi kullanıyoruz
	        String cikis = a.getCikisGezegeni().getGezegen_adi();
	        String varis = a.getVarisGezegeni().getGezegen_adi();
	        String kalanSaat = durum.equalsIgnoreCase("İmha") ? "--" : String.valueOf(a.getMesafeSaat());
	        String varisTarihi = durum.equalsIgnoreCase("İmha") ? "--" : a.getVarisTarihi().toString();

	        System.out.printf("%-10s %-10s %-10s %-10s %-20s %-20s%n", ad, durum, cikis, varis, kalanSaat, varisTarihi);
	    }

	    
	}


	
	public static void nufuslariHesapla(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
		
        for (Gezegen gezegen : gezegenler) {
            gezegen.nufusuSifirla();
        }
        
        for (UzayAraci arac : araclar) {
            arac.nufusaEkle();
        }
    }

}


