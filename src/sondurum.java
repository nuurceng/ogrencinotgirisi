import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class sondurum {
    void sndrm() {
        try {
            BufferedReader girisAkimi = new BufferedReader(new FileReader("test.txt"));
            String satir = null;
            int sayac = 0;
            satir = girisAkimi.readLine();
            while (satir != null) {
                sayac++;
                System.out.println("" + satir);
                satir = girisAkimi.readLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
//öğrencinin not girişleri ,hesaplanan ortalama, harf durumları ,öğrencinin geçti-kaldı durumu
//en yüksek-en düşük öğrenci ortalamaları, geçti-kaldı durumda olan öğrencilerin sayılarını belirtir....
//kısaca test.txt de satır satır görünenleri terminale yazar....
