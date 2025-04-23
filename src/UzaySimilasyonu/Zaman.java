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
	
	public boolean equals(Zaman other) {
        return this.gun == other.gun && this.ay == other.ay && this.yil == other.yil;
    }
	
}

