import java.io.*;
import java.util.Scanner;

public class Hesaplama {
    static Scanner genelscanner = new Scanner(System.in);
    //genelscanner klavyeden veri almak için
    void hesaplar() {
        int sayac = 0;
        try {
            //ogrenciler.txt de olanı satır satır terminale yazar
            //Metin dosyasından okuma yapma işlemi
            //BufferReadder: Dosyadan karakterleri tamponlayarak(byte'ları harfe çevirerek) okur
            //BufferReadder da dosya adı doğrudan girilemez, fileReader sınıfı ile oluşturalan nesne kullanılır
            BufferedReader girisAkimi = new BufferedReader(new FileReader("ogrenciler.txt"));
            String satir = null;
            satir = girisAkimi.readLine();
            while (satir != null) {
                sayac++;
                System.out.print(sayac + "=");
                System.out.println("" + satir);
                satir = girisAkimi.readLine();
            }
            girisAkimi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double[] ortalamadizisi = new double[sayac];
        double[] vizedizisi = new double[sayac];
        double[] finaldizisi = new double[sayac];
        //frekans grafiği için alınacak harf sayıları tanımlandı.
        int harfa = 0;
        int harfb = 0;
        int harfc = 0;
        int harfd = 0;
         for (int i = 0; i < sayac; i++) {
            System.out.println("Lütfen " + (i + 1) + ". öğrenci Vize Notunu Giriniz: ");
            double vizenot = genelscanner.nextDouble();
            if (vizenot<0 || vizenot>100)
            {
                System.out.println("Hatalı Not Girişi!");
                System.out.println("Yazma İşlemi Başarıyla Tamamlanamadı!\n");
                break;
            }
            System.out.println("Lütfen " + (i + 1) + ". öğrenci Final Notunu Giriniz: ");
            double finalnot = genelscanner.nextDouble();
            if (finalnot<0 || finalnot>100)
            {
                System.out.println("Hatalı Not Girişi!");
                System.out.println("Yazma İşlemi Başarıyla Tamamlanamadı!\n");
                break;
            }
            else {
                System.out.println("Yazma işlemi başarıyla tamamlandı!\n");
            }

             //Not Hesaplanma İşlemi
            ortalamadizisi[i] = vizenot * 0.4 + finalnot * 0.6;
            vizedizisi[i] = vizenot;
            finaldizisi[i] = finalnot;
            if (ortalamadizisi[i] > 75 & ortalamadizisi[i] <= 100) {
                harfa = harfa + 1;//Frekans grafiği için harf sayısı artımı
            } else if (ortalamadizisi[i] > 50 & ortalamadizisi[i] <= 75) {
                harfb = harfb + 1;
            } else if (ortalamadizisi[i] > 25 & ortalamadizisi[i] <= 50) {
                harfc = harfc + 1;
            } else if (ortalamadizisi[i] > 0 & ortalamadizisi[i] <= 25) {
                harfd = harfd + 1;
            }
        }

        //En yüksek not ortalaması ve en düşük not ortalaması
        double max = ortalamadizisi[0];
        double min = ortalamadizisi[0];
        for (int i = 1; i < sayac; i++) {
            if (ortalamadizisi[i] < min) {
                min = ortalamadizisi[i];
            }
            if (ortalamadizisi[i] > max) {
                max = ortalamadizisi[i];
            }
        }
        System.out.println("-------------------------------");


        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //test.txt dosyasına yazdırma işlemini gerçekleştiriyor
            //FileWriter: Dosyaya Yazdırma
            //BufferedWriter: Tampon bellek görevi görür, bu işlem olmazsa karakterlerimiz direkt byte biçiminde yazılırdı
            fw = new FileWriter("test.txt");
            bw = new BufferedWriter(fw);
            BufferedReader girisAkimi = new BufferedReader(new FileReader("ogrenciler.txt"));
            for (int i = 0; i < sayac; i++) {
                bw.write((girisAkimi.readLine() + " "));
                bw.newLine();
                bw.write((i + 1) + ". Öğrencinin VİZE notu:" + vizedizisi[i]);
                bw.newLine();
                bw.write((i + 1) + ". Öğrencinin FİNAL notu:" + finaldizisi[i]);
                bw.newLine();
                bw.write((i + 1) + ". Öğrenci Ortalaması:" + ortalamadizisi[i]);
                bw.newLine();
                if (ortalamadizisi[i] > 75 & ortalamadizisi[i] <= 100) {
                    bw.write((i + 1) + ". Öğrenci Harflendirmesi:AA---Durumu:Geçti");
                    bw.newLine();
                } else if (ortalamadizisi[i] > 50 & ortalamadizisi[i] <= 75) {
                    bw.write((i + 1) + ". Öğrenci Harflendirmesi:BB---Durumu:Geçti");
                    bw.newLine();
                } else if (ortalamadizisi[i] > 25 & ortalamadizisi[i] <= 50) {
                    bw.write((i + 1) + ". Öğrenci Harflendirmesi:CC---Durumu:Kaldı");
                    bw.newLine();
                } else if (ortalamadizisi[i] > 0 & ortalamadizisi[i] <= 25) {
                    bw.write((i + 1) + ". Öğrenci Harflendirmesi:DD---Durumu:Kaldı");
                    bw.newLine();
                }
                bw.write("--------------------------------");
                bw.newLine();
            }
            girisAkimi.close();
            bw.write("--------------------------------");
            bw.newLine();
            bw.write("En Yüksek Puanlı öğrenci Ortalaması: " + max);
            bw.newLine();
            bw.write("En Düşük Puanlı öğrenci Ortalaması:  " + min);
            bw.newLine();
            bw.write("--------GEÇTİ DURUMDA-------------");
            bw.newLine();
            bw.write("AA Harfi alan öğrenci Sayısı: " + harfa);
            bw.newLine();
            bw.write("BB Harfi alan öğrenci Sayısı: " + harfb);
            bw.newLine();
            bw.write("---------KALDI DURUMDA------------");
            bw.newLine();
            bw.write("CC Harfi alan öğrenci Sayısı: " + harfc);
            bw.newLine();
            bw.write("DD Harfi alan öğrenci Sayısı: " + harfd);
            bw.newLine();
            bw.write("-----------Frekans Grafiği------------");
            bw.newLine();
            //For döngüsü ile her harf sayısı kadar * ekliyor dosyaya yazdırıyor
            bw.write("AA Harf Notu: ");
            for (int i = 0; i < harfa; i++) {
                bw.write('*');

            }
            bw.newLine();
            bw.write("BB Harf Notu: ");
            for (int i = 0; i < harfb; i++) {
                bw.write('*');

            }
            bw.newLine();
            bw.write("CC Harf Notu: ");
            for (int i = 0; i < harfc; i++) {
                bw.write('*');

            }
            bw.newLine();
            bw.write("DD Harf Notu: ");
            for (int i = 0; i < harfd; i++) {
                bw.write('*');

            }
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
