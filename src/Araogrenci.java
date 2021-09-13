import java.io.*;
import java.util.Scanner;

public class Araogrenci {
    void aranan() {
        int sayac = 0;
        //ogrenciler.txt de olan satır satır terminale yazar...
        try {
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
        System.out.println("-----------------------------");
        //arama işlemi yapmaktadır...
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Hangi sıradaki öğrenciyi arıyorsunuz:");
            String c = input.next();
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(c))
                    System.out.println(line);
            }
            //satır boş değilse oku sonra aranan satırı doldur ve satırı ekrana yaz....
            System.out.println("-----------------------------");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
