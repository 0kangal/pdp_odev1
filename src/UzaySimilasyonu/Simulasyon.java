package UzaySimilasyonu;

import java.util.*;

public class Simulasyon {
	
	
	public static void nufuslariHesapla(Collection<Gezegen> gezegenler, List<UzayAraci> araclar) {
		
        for (Gezegen gezegen : gezegenler) {
            gezegen.nufusuSifirla();
        }
        
        for (UzayAraci arac : araclar) {
            arac.nufusaEkle();
        }
    }

}
