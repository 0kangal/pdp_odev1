package UzaySimilasyonu;

import java.util.*;

public class App {

	public static void main(String[] args) {
		
		Map<String, Gezegen> gezegenMap = DosyaOkuma.gezegenleriOku("Gezegenler.txt");
        List<UzayAraci> araclar = DosyaOkuma.araclariOku("Araclar.txt", gezegenMap);

        Map<String, UzayAraci> uzayAraciMap = new HashMap<>();
        for (UzayAraci u : araclar) {
            uzayAraciMap.put(u.getAd(), u);
        }

        List<Kisi> kisiler = DosyaOkuma.kisileriOku("Kisiler.txt", uzayAraciMap);

        Simulasyon.simulasyonBaslat(gezegenMap.values(), araclar);
        
	}

}



