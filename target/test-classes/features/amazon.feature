@amazon
  Feature:
    Scenario:
      Given Amazon sitesine giddily
      Then Kullanici Arama kutucuğuna “glasses” kelimesi girer ve arama yapar
      Then Kullanici Arama kutucuguna girilen “glasses” kelimesini siler
      Then Kullanici Arama kutucuguna “sun glasses” kelimesini girer ve enter tusuna basar
      Then Kullanici sonuca göre sergilenen urunlerden rastgele bir urunu secer
      Then Secilen urunun fiyati 400TL den fazlaysa, arama ekranina geri donulur,"250tl 500tl" fiyat araligi secilir ve tekrar aranir. Ilk secenek secilir
      Then Kullanici seçilen urunu sepete ekler
      Then Kullanici urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugunu karsilastirir
      #Then Kullanici adet arttirarak urun adedinin 2 oldugunu dogrular


