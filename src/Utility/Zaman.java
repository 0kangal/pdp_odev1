package Utility;

public class Zaman {
    private int yil;
    private int ay;
    private int gun;

    public Zaman(int gun, int ay, int yil) {
        this.gun = gun;
        this.ay = ay;
        this.yil = yil;
    }
    
    // Kopya yapıcı metod: Bir diğer Zaman objesini kopyalar	
    public Zaman(Zaman other) {
        this.gun = other.gun;
        this.ay = other.ay;
        this.yil = other.yil;
    }
    
    // Bir gün ilerletir: Gün değeri 30'u geçerse ayı, ay değeri 12'yi geçerse yılı bir artırır
    public void birGunIlerle() {
        gun++;
        if (gun > 30) {
            gun = 1;
            ay++;
            if (ay > 12) {
                ay = 1;
                yil++;
            }
        }
    }
    
    @Override
    public String toString() {
        return gun + "." + ay + "." + yil;
    }
    
    // Diğer bir Zaman objesi ile karşılaştırarak bu zamanın daha küçük olup olmadığını kontrol eder
    public boolean smaller(Zaman other) {
    	if (this.yil < other.yil) {
            return true;
        } else if (this.yil == other.yil) {
            if (this.ay < other.ay) {
                return true;
            } else if (this.ay == other.ay) {
                return this.gun < other.gun;
            }
        }
        return false;
    }
    
    // Bu zaman ile diğer zaman arasındaki gün farkını döndürür
    public int gunFarki(Zaman other) {
        return Math.abs(this.toplamGunSayisi() - other.toplamGunSayisi());
    }
    
    // Zamanı gün cinsinden toplamaya yarar: yıl * 365 + ay * 30 + gün
    public int toplamGunSayisi() {
    	
        int toplamGun = yil * 365;
        toplamGun += (ay - 1) * 30;
        toplamGun += gun;
        
        return toplamGun;
    }
    
}


