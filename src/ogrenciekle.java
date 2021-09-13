import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ogrenciekle {
    void ekle() {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Lütfen öğrenciyi Giriniz: ");
            String ekle = scanner1.nextLine();
            File file = new File("ogrenciler.txt");//dosya nesnesi
            if (!file.exists()) { // dosya zaten var mı
                file.createNewFile();//yoksa dosyayı oluştur...
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write("\n"+ekle);
            System.out.println("--------------Öğrenci eklenmiştir------------ ");
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//dosyaya önceden eklenen satırları silmeden yeni öğrenci ekleme işlemi.....
