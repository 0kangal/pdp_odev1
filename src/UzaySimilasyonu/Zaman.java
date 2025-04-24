package UzaySimilasyonu;

import lombok.Getter;

@Getter
public class Zaman {
    private int yil;
    private int ay;
    private int gun;

    public Zaman(int gun, int ay, int yil) {
        this.gun = gun;
        this.ay = ay;
        this.yil = yil;
    }
    
    
    public Zaman(Zaman other) {
        this.gun = other.gun;
        this.ay = other.ay;
        this.yil = other.yil;
    }

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
    
    public int toplamGunSayisi() {
    	
        int toplamGun = yil * 365;
        toplamGun += (ay - 1) * 30;
        toplamGun += gun;
        
        return toplamGun;
    }
    
    @Override
    public String toString() {
        return gun + "." + ay + "." + yil;
    }
    
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
    
}


