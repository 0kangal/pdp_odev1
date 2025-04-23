package UzaySimilasyonu;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class DosyaOkuma {
	
	public static List<Kisi> kisileriOku(String dosyaYolu, Map<String, UzayAraci> uzayAraciMap) {
	    List<Kisi> kisiler = new ArrayList<>();
	    try {
	        List<String> satirlar = Files.readAllLines(Paths.get(dosyaYolu));
	        for (String satir : satirlar) {
	            String[] parcalar = satir.split("#");
	            String isim = parcalar[0];
	            int yas = Integer.parseInt(parcalar[1]);
	            int kalanOmur = Integer.parseInt(parcalar[2]);
	            String uzayAraciAdi = parcalar[3];

	            UzayAraci uzayAraci = uzayAraciMap.get(uzayAraciAdi);
	            if (uzayAraci != null) {
	                Kisi kisi = new Kisi(isim, yas, kalanOmur, uzayAraci);
	                kisiler.add(kisi);
	                uzayAraci.yolcuEkle(kisi); // kişiyi aracın listesine ekle
	            } else {
	                System.out.println("Uyarı: " + isim + " için uzay aracı '" + uzayAraciAdi + "' bulunamadı.");
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Kisiler dosyasi okunurken hata oluştu: " + e.getMessage());
	    }
	    return kisiler;
	}


    public static List<UzayAraci> araclariOku(String dosyaYolu, Map<String, Gezegen> gezegenMap) {
        List<UzayAraci> araclar = new ArrayList<>();
        try {
            List<String> satirlar = Files.readAllLines(Paths.get(dosyaYolu));
            for (String satir : satirlar) {
                String[] parcalar = satir.split("#");
                String adi = parcalar[0];
                Gezegen cikis = gezegenMap.get(parcalar[1]);
                Gezegen varis = gezegenMap.get(parcalar[2]);

                String[] tarih = parcalar[3].split("\\.");
                int gun = Integer.parseInt(tarih[0]);
                int ay = Integer.parseInt(tarih[1]);
                int yil = Integer.parseInt(tarih[2]);
                Zaman cikisTarihi = new Zaman(gun, ay, yil);

                int mesafe = Integer.parseInt(parcalar[4]);

                UzayAraci arac = new UzayAraci(adi, cikis, varis, cikisTarihi, mesafe);
                araclar.add(arac);
            }
        } catch (IOException e) {
            System.out.println("Araclar dosyasi okunurken hata oluştu: " + e.getMessage());
        }
        return araclar;
    }

    public static Map<String, Gezegen> gezegenleriOku(String dosyaYolu) {
        Map<String, Gezegen> gezegenler = new HashMap<>();
        try {
            List<String> satirlar = Files.readAllLines(Paths.get(dosyaYolu));
            for (String satir : satirlar) {
                String[] parcalar = satir.split("#");
                String adi = parcalar[0];
                int saat = Integer.parseInt(parcalar[1]);

                String[] tarih = parcalar[2].split("\\.");
                int gun = Integer.parseInt(tarih[0]);
                int ay = Integer.parseInt(tarih[1]);
                int yil = Integer.parseInt(tarih[2]);

                Zaman zaman = new Zaman(gun, ay, yil);
                Gezegen gezegen = new Gezegen(adi, saat, zaman);
                gezegenler.put(adi, gezegen);
            }
        } catch (IOException e) {
            System.out.println("Gezegenler dosyasi okunurken hata oluştu: " + e.getMessage());
        }
        return gezegenler;
    }
}


