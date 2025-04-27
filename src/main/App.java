package main;

import java.io.*;
import java.util.*;

import Utility.DosyaOkuma;
import UzaySimilasyonu.Gezegen;
import UzaySimilasyonu.Simulasyon;
import UzaySimilasyonu.UzayAraci;

public class App {

	public static void main(String[] args) {
		
		InputStream gezegenlerStream = App.class.getClassLoader().getResourceAsStream("resources/Gezegenler.txt");
		InputStream araclarStream = App.class.getClassLoader().getResourceAsStream("resources/Araclar.txt");
		InputStream kisilerStream = App.class.getClassLoader().getResourceAsStream("resources/Kisiler.txt");

		Map<String, Gezegen> gezegenMap = DosyaOkuma.gezegenleriOku(gezegenlerStream);
		List<UzayAraci> araclar = DosyaOkuma.araclariOku(araclarStream, gezegenMap);

		Map<String, UzayAraci> uzayAraciMap = new HashMap<>();
		for (UzayAraci u : araclar) {
		    uzayAraciMap.put(u.getAd(), u);
		}

		DosyaOkuma.kisileriOku(kisilerStream, uzayAraciMap);

		Simulasyon.simulasyonBaslat(gezegenMap.values(), araclar);

        
	}

}



