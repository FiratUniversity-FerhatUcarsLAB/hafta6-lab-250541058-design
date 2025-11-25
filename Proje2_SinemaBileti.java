//AD SOYAD : Burçin AYYILDIZ
//NUMARA : 250541058
//TARİH : 25.11.2025
//AÇIKLAMA : Bu program kullanıcıdan gerekli bilgileri alarak sinema bileti fiyatını hesaplar.
import java.util.Scanner ;
public class sinemaBileti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//gün seçimi
        int gun = 4;
        boolean haftaSonuMu = isWeekend(gun);
        if (haftaSonuMu) {
            System.out.println("Haftosunu");
        } else {
            System.out.println("Haftaiçi");
        }
        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("ÇArşamba");
                break;
            case 4:
                System.out.println("Perşembe");
                break;
            case 5:
                System.out.println("Cuma");
                break;
            case 6:
                System.out.print("Cumartesi");
                break;
            case 7:
                System.out.println("Pazar");
                break;
        }
//saat seçimi
        int saat = 10;
        if (saat < 12) {
            System.out.println("Matine");
        } else {
            System.out.println("Normal");
        }
        boolean matineMi = isMatinee(saat);

        System.out.println("Yaş girin: ");
        int yas = input.nextInt();
//meslek seçimi
        int meslek = 1;
        switch (meslek) {
            case 1:
                System.out.println("Öğrenci");
                break;
            case 2:
                System.out.println("Öğretmen");
                break;
            case 3:
                System.out.println("Diğer");
                break;
        }
//film türü seçimi
        int filmTuru = 2;
        switch (filmTuru) {
            case 1:
                System.out.println("2D");
                break;
            case 2:
                System.out.println("3D");
                break;
            case 3:
                System.out.println("IMAX");
                break;
            case 4:
                System.out.println("4DX");
                break;
        }
//temel fiyat
        double temelFiyat = calculateBasePrice(haftaSonuMu, matineMi);
        System.out.println("Temel fiyat : " + temelFiyat);
//indirimler
        double indirimliFiyat = calculateDiscount(temelFiyat, yas, meslek, gun);
        System.out.println("İndirimli fiyat :" + indirimliFiyat);
        double formatEkstra = getFormatExtra(filmTuru); // Bu satır çalışmalı
        System.out.println("Format ekstra ücreti: " + formatEkstra + " TL");
        double toplamFiyat = calculateFinalPrice(indirimliFiyat, filmTuru); // Bu metot çağrılmalı
        System.out.println("Toplam Bilet Fiyatı: " + toplamFiyat + " TL");
        generateTicketInfo(temelFiyat, indirimliFiyat, toplamFiyat);
    }

    //metotlar
    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7;
    }

    public static boolean isMatinee(int saat) {
        return saat >= 9 && saat <= 12;
    }

    public static double calculateBasePrice(boolean haftaSonuMu, boolean matineMi) {
        if (!haftaSonuMu && matineMi) {
            return 45.00;
        } else if (!haftaSonuMu && !matineMi) {
            return 65.00;
        } else if (haftaSonuMu || matineMi) {
            return 55.00;
        } else {
            return 85.00;
        }
    }

    //BURADA YAPAY ZEKADAN YARDIM ALDIM.
    public static double calculateDiscount(double temelFiyat, int yas, int gun, int meslek) {
        double indirimOrani = 0.0;
        if (yas < 12) {
            indirimOrani = 0.25;
        } else if (yas >= 65) {
            indirimOrani = 0.30;
        }
        if (indirimOrani == 0.0) {
            if (meslek == 1) {
                if (gun >= 1 && gun <= 4) {
                    indirimOrani = 0.20;
                } else if (gun >= 5 && gun <= 7) {
                    indirimOrani = 0.15;
                } else if (meslek == 2) {
                    if (gun == 3) {
                        indirimOrani = 0.35;
                    }
                }
            }
        }
            return temelFiyat * (1.0 - indirimOrani);

        }
        public static double getFormatExtra (int filmTuru) {
            switch (filmTuru) {
                case 1:
                    return 0.0;
                case 2:
                    return 25.0;
                case 3:
                    return 35.0;
                case 4:
                    return 50.0;
                default:
                    return 0.0;
            }
        }
        public static double calculateFinalPrice (double indirimliFiyat,int filmTuru) {
            double formatEkstra = getFormatExtra(filmTuru) ;
            return indirimliFiyat + formatEkstra;
        }
    public static void generateTicketInfo(double temelFiyat, double indirimliFiyat, double finalFiyat) {
        System.out.println("\n---  Bilet Bilgileri ---");
        System.out.println("Temel Ücret (İndirimsiz): " + String.format("%.2f", temelFiyat) + " TL");
        System.out.println("Uygulanan İndirimli Fiyat: " + String.format("%.2f", indirimliFiyat) + " TL");
        System.out.println("Film Formatı Ek Ücreti: " + String.format("%.2f", (finalFiyat - indirimliFiyat)) + " TL");
        System.out.println("--------------------------------");
        System.out.println("**TOPLAM ÖDENECEK FİYAT**: " + String.format("%.2f", finalFiyat) + " TL");
        System.out.println("--------------------------------");
    }

    }
