package UzaySimilasyonu;

public class Kisi {
    private String isim;
    private int yas;
    private int kalanOmur; // saat cinsinden
    private UzayAraci bulunduguUzayAraci;
    private boolean yasiyor;

    public Kisi(String isim, int yas, int kalanOmur, UzayAraci bulunduguUzayAraci) {
        this.isim = isim;
        this.yas = yas;
        this.kalanOmur = kalanOmur;
        this.bulunduguUzayAraci = bulunduguUzayAraci;
        this.yasiyor = true;
    }

    public void saatIlerle() {
        if (yasiyor) {
            kalanOmur--;
            if (kalanOmur <= 0) {
                yasiyor = false;
            }
        }
    }

    // Getter'lar
    public String getIsim() { return isim; }
    public int getYas() { return yas; }
    public int getKalanOmur() { return kalanOmur; }
    public UzayAraci getBulunduguUzayAraci() { return bulunduguUzayAraci; }
    public boolean isYasiyor() { return yasiyor; }
}

