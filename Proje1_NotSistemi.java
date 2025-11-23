//AD SOYAD : Burçin AYYILDIZ
//NUMARA : 250541058
//TARİH : 24.11.2025
//AÇIKLAMA:Bu program öğrencinin dersten geçip geçmediğini, harf notunu, bütünleme hakkının olup olmadığını açıklar.//



import java.util.Scanner ;
public class NotSİstemi {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("===ÖĞRENCİ BİLGİ SİSTEMİ===");
        System.out.println("Vize notunuzu Girin :");
        int vizeNotu = input.nextInt();
        System.out.println("Final notunuzu girin : ");
        int finalNotu = input.nextInt();
        System.out.println("Ödev notunuzu girin : ");
        int odevNotu = input.nextInt();
        System.out.println("Not ortalamanız : " + calculateAverage(vizeNotu, finalNotu, odevNotu));
        double notOrtalamasi = calculateAverage(vizeNotu, finalNotu, odevNotu);
        System.out.println("Geçme durumu : " + isPassingGrade(notOrtalamasi));
        boolean gectiMi = isPassingGrade(notOrtalamasi);
        System.out.println("Harf notu : " + getLetterGrade(notOrtalamasi));
        char harfNotu = getLetterGrade(notOrtalamasi);
        System.out.println("Onur listesinde mi? : " + isHonorList(notOrtalamasi,vizeNotu,finalNotu,odevNotu )) ;
        boolean onurListesi = isHonorList(notOrtalamasi,vizeNotu,finalNotu,odevNotu) ;
        System.out.println("Bütünleme durumu : " + hasRetakeRight(notOrtalamasi)) ;
        boolean butunleme = hasRetakeRight(notOrtalamasi) ;

        if (isPassingGrade(notOrtalamasi)) {
            System.out.println("GEÇTİ");
        } else {
            System.out.println("KALDI");
        }
    }

    public static double calculateAverage(int vizeNotu, int finalNotu, int odevNotu) {
        return (vizeNotu * 0.3) + (finalNotu * 0.4) + (odevNotu * 0.3);
    }

    public static boolean isPassingGrade(double notOrtalalamasi) {
        final double gecmeNotu = 50.00;
        return notOrtalalamasi >= gecmeNotu;
    }

    public static char getLetterGrade(double notOrtalamasi) {
        if (notOrtalamasi > 90 && notOrtalamasi <= 100) {
            return 'A';
        } else if (notOrtalamasi > 80 && notOrtalamasi <= 89) {
            return 'B';
        } else if (notOrtalamasi > 70 && notOrtalamasi <= 79) {
            return 'C';
        } else if (notOrtalamasi > 60 && notOrtalamasi <= 69) {
            return 'D';
        } else {
            return 'F';
        }

    }
    public static boolean isHonorList (double notOrtalamasi,int vizeNotu, int finalNotu, int odevNotu) {
        boolean ortalama = notOrtalamasi >= 85 ;
        boolean hicbirNot = vizeNotu >70 && finalNotu>70 && odevNotu>70 ;
        return ortalama && hicbirNot ;
    }
    public static boolean hasRetakeRight (double notOrtalamasi) {
        return notOrtalamasi >= 40 && notOrtalamasi < 50 ;
        }
        
}
