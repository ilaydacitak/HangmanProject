package hangmangame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ilaydacitak
 */
public class HangmanGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // KULLANICIDAN İSİM SOYİSİM ALINIR:
        Scanner input = new Scanner( System.in ) ;
        System.out.println("İSİM SOYİSİM GİRİNİZ: ");
        String a = input.next();
        //25 KELİMEYE SAHİP BİR DİZİDEN RASTGELE BİR KELİME SEÇİLİR:
        String[] words = new String[25];
      
        words [0] = "siyah";
        words [1] = "beyaz";
        words [2] = "gri";
        words [3]= "kirmizi";
        words [4] = "pembe";
        words [5] = "mavi";
        words [6] = "mor";
        words [7] = "lila";
        words [8] = "bej";
        words [9] = "fume"; 
        words [10] = "bordo";
        words [11] = "turkuaz";
        words [12]= "yesil";
        words [13] = "sari";
        words [14] = "nude";
        words [15] = "kahverengi";
        words [16] = "ekru";
        words [17] = "turuncu";
        words [18] = "fildisi";
        words [19] = "kralice";
        words [20] = "ilayda";
        words [21] = "citak";
        words [22] = "sevgi";
        words [23] = "saygi";
        words [24] = "sunmak";
        
           
        Random rastgele = new Random();
        int kacinciEleman = rastgele.nextInt(words.length);
         //KONTROL AMAÇLI YAZDIRIP BAKTIK
        System.out.println("Rastgele seçilen kelime: " + words[kacinciEleman]);
        
        //KELİMEDEKİ HARF SAYISININ İKİ KATI KADAR DENEME YAPMA HAKKI VARDIR 
        // 2 KEZ TÜM KELİMEYİ DENEME HAKKI VARDIR
        int deneme_hakki = 2*words[kacinciEleman].length();
        int deneme_hakki_tum_kelime = 2;
        
        //KONTROL AMAÇLI YAZDIRIP BAKTIK 
        System.out.println("deneme yapma hakkı: "+deneme_hakki) ;
        System.out.println("tüm kelimeyi deneme hakkı: "+deneme_hakki_tum_kelime);
        
        //ÇİZGİ DİZİSİ OLUSTURDUK
        char [] cizgi_dizisi = new char [words[kacinciEleman].length()];
        for (int t = 0; t < cizgi_dizisi.length; t++ ){
           
            cizgi_dizisi[t] = '-';
        }
        
        
        int tekrar_oyna = 1;
        boolean kazandi = false;
        
        while((deneme_hakki > 0 || deneme_hakki_tum_kelime > 0) && tekrar_oyna == 1)
        {
            int secim = -1;
             // SEÇİM YAPMASI İÇİN KULLANICIYA SORULUR
            if(deneme_hakki > 0 && deneme_hakki_tum_kelime > 0){
                System.out.println("Harf tahmini icin 1, kelime icin 0 a basiniz");
                Scanner harf_kelime = new Scanner (System.in);
                secim = harf_kelime.nextInt();
            }
           // SADECE HARF DENEME HAKKI VAR DEMEKTİR 
            else if(deneme_hakki > 0 && deneme_hakki_tum_kelime == 0)
            {
                
                secim = 1;
            }
             // SADECE KELİME DENEME HAKKI VAR DEMEKTİR
            else if(deneme_hakki == 0 && deneme_hakki_tum_kelime > 0)
            {
                secim = 0;
            }
             // HARF TAHMİNİNİ SEÇMİSSE 
            if(secim == 1 && deneme_hakki > 0){
                Scanner harf_tahmini = new Scanner (System.in);
                System.out.println("HARF TAHMİNİ TAHMİN YAPINIZ: ");
                String x = harf_tahmini.next(); 
                char ch = x.charAt(0); // tahmiN
                deneme_hakki -= 1;

                for (int q = 0 ; q<words[kacinciEleman].length(); q++){
                    if (ch == words[kacinciEleman].charAt(q)){
                        cizgi_dizisi[q]=ch;
                        String asdf = String.copyValueOf(cizgi_dizisi);

                        System.out.println(cizgi_dizisi);
                        if(asdf.equals(words[kacinciEleman])){
                            System.out.println("SONUCU BULDUNUZ");
                            kazandi= true;
                            break;
                        }
                    }   
                }

            }
            // KELİME TAHMİNİNİ SEÇMİSSE
            else if(secim == 0 && deneme_hakki_tum_kelime > 0)
            {
                Scanner kelime_tahmini = new Scanner (System.in);
                String tahmin_edilen_kelime = kelime_tahmini.next();

                if(tahmin_edilen_kelime.equals(words[kacinciEleman]))
                {
                    System.out.println("Sonucu Buldunuz");
                    kazandi = true;
                }

                else{
                    deneme_hakki_tum_kelime -= 1;
                    System.out.println("KALAN KELİME DENEME HAKKI: "+deneme_hakki_tum_kelime);
                }
            }
            
            // İKİ DURUMDA DA SONUCU BULMUŞ İSE
            if(kazandi == true){
                System.out.println("Tekrar Oynamak Istermisiniz? 1 evet, 0 hayır");
                kazandi = false;
                Scanner tekrar_girisi = new Scanner(System.in);
                tekrar_oyna = tekrar_girisi.nextInt();
                
                // TEKRAR OYNAMAK İSTİYORSA YENİ KELİME VE DENEME HAKKI TANIMLANMASI GEREKİR
                if (tekrar_oyna == 1)
                {
                    rastgele = new Random();
                    kacinciEleman = rastgele.nextInt(words.length);
                     //KONTROL AMAÇLI YAZDIRIP BAKTIK
                    System.out.println("Rastgele seçilen kelime: " + words[kacinciEleman]);

                    //KELİMEDEKİ HARF SAYISININ İKİ KATI KADAR DENEME YAPMA HAKKI VARDIR 
                    deneme_hakki = 2*words[kacinciEleman].length();
                    deneme_hakki_tum_kelime = 2;

                    //KONTROL AMAÇLI YAZDIRIP BAKTIK 
                    System.out.println("deneme yapma hakkı: "+deneme_hakki) ;

                    //ÇİZGİ DİZİSİ 
                    cizgi_dizisi = new char [words[kacinciEleman].length()];
                    for (int t = 0; t < cizgi_dizisi.length; t++ ){

                        cizgi_dizisi[t] = '-';
                    }
                }
            }
            // TUM HAKLARINI KULLANMASI DURUMUNDA
            else if(deneme_hakki == 0 && deneme_hakki_tum_kelime == 0)
            {
                System.out.println("Oyunu Kaybettiniz");
                System.out.println("Tekrar Oynamak Istermisiniz? 1 evet, 0 hayır");
                Scanner tekrar_girisi = new Scanner(System.in);
                tekrar_oyna = tekrar_girisi.nextInt();
                
                
            // TEKRAR OYNAMAK İSTİYORSA YENİ KELİME VE DENEME HAKKI TANIMLANMASI GEREKİR
            if (tekrar_oyna == 1)
            {
                rastgele = new Random();
                kacinciEleman = rastgele.nextInt(words.length);
                 //KONTROL AMAÇLI YAZDIRIP BAKTIK
                System.out.println("Rastgele seçilen kelime: " + words[kacinciEleman]);

                //KELİMEDEKİ HARF SAYISININ İKİ KATI KADAR DENEME YAPMA HAKKI VARDIR 
                deneme_hakki = 2*words[kacinciEleman].length();
                deneme_hakki_tum_kelime = 2;

                //KONTROL AMAÇLI YAZDIRIP BAKTIK 
                System.out.println("deneme yapma hakkı: "+deneme_hakki) ;

                // ÇİZGİ DİZİSİ
                cizgi_dizisi = new char [words[kacinciEleman].length()];
                for (int t = 0; t < cizgi_dizisi.length; t++ ){

                    cizgi_dizisi[t] = '-';
                }
            }
            }
            
            
            
            
        
        // WHİLE SON PARANTEZ
        }
    }
    
}
