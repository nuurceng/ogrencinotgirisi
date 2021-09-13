import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nİleri Java Dersi Yönetici Paneline Hoşgeldiniz!\n");

        boolean cikis=false;
        Scanner tara =new Scanner(System.in);
        byte secim=0;
        while (!cikis) {
            System.out.println("***** Öğrenci Not Girişi Menüsü *****");
            System.out.println("1 - Not Girişleri \n2 - Son Durum Hesapla \n3 - Ara \n4 - Öğrenci Ekle \n5 - Çıkış");
            System.out.println(" \nLütfen 1-5 Arası Bir Seçenek Seçiniz : ");
            secim=tara.nextByte();

            switch (secim) {
                case 1:
                    Hesaplama hsp = new Hesaplama();
                    hsp.hesaplar();
                    break;
                case 2:
                    sondurum snd = new sondurum();
                    snd.sndrm();
                    break;
                case 3:
                    Araogrenci ara = new Araogrenci();
                    ara.aranan();
                    break;
                case 4:
                    ogrenciekle ogr = new ogrenciekle();
                    ogr.ekle();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Geçersiz işlem");
                    break;
            }
        }
    }
}
