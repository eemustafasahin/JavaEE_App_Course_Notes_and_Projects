###   IntelliJ vs Eclipse Proje yapısı

#### Intellij'deki proje Eclipse'de workspace'e karşılık gelir. Yine IntelliJ'deki modül kavramı eclipse'de proje kavramına karşılık gelir.

**IntelliJ:** _Project    --> Modules_

**Eclipse:**  _Workspace  --> Project_

Üç şekilde jar dosyası oluşturulması gösterilecektir. İlk olarak IntelliJ IDE ile daha sonrasında Eclipse IDE ile ve en sonunda maven ile IDE'lerden bağımsız olarak jar dosyası 
nasıl oluşturulur anlatılacaktır. Birbirine bağlı jar dosyalarının oluşturulması ile ilgili ayrıntılar daha sonra ele alınacaktır.

### IntellJ ile Jar Dosyası Oluşturmak

1. Öncelikler Libraries adında bir Proje (Eclips'te buna workspace denir) oluşturalım. Ve bu projeyi IntelliJ,Eclipse ve Maven olarak alt dizinlere ayıralım ki daha sonraki örnekler
bu dizinler altında gerçekleştirilebilsin. Library olarak JavaSampleBasic isimli projedeki util sınıflarını örnek olarak kullanacağız.

![jar1](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/Jar1.png)

![jar2](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar2.png)

2. Şimdi IntelliJ üzerinden yeni bir proje açalım ve yukarıda oluşturduğumuz dizine Libraries adında açacağımız projemizi (Eclipse de buna workspace denildiğini hatırlayınız)
ekleyelim.

![jar1](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar3.png)

![jar2](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar4.png)

![jar5](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar5.png)

![jar6](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar6.png)

3. Sıra geldi Açtığımız proje içine yeni bir modüle eklemeye (Eclipse'de buna proje denilir).Şimdilik bizim Utility sınıflarını ekleyeceğiz. Modül açtıktan sonra src altına yeni 
paketimizi ve buna bağlı olan utility sınıflarını ekleyebiliriz. Bu sınıfları daha önce yazmış olduğumuzd JavaSampleBasic projemizden alacağız.

![jar7](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar7.png)

![jar8](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar8.png)

![jar9](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar9.png)

![jar10](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar10.png)

4. Genel olarak IntelliJ ortamında herhangi bir projenin sonucunda ortaya çıkan ürüne artifact denir. Bizim pojemiz olan _libraries_ için bu artifact jar dosyası olacaktır. Bu 
ürünü başka yerlere taşıyıp kullanacağız. Bunun için File --> project structure --> artifact kısmına gelip (+) kısmından jar artifact seçip from modules with dependicies seçeriz.
Karşımıza modüller çıkacaktır. Ve biz Hangi modülden bir jar dosyası oluşturmak istiyorsak o modülü seçeriz. Şu an için UtilLib modülünü seçeceğiz. Ve isimlendirmeyi sanki bir 
paket oluşturmuş gibi verebiliriz. Ne de olsa jar dosyaları bir nevi paketlerin ziplenmiş hali gibidir.  Bu işlemleri yaptıktan sınra Build -> build artifacts --> build yaparak 
ürünümüzü hazır hale getiririz.

![jar11](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar11.png)

![jar12](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar12.png)

![jar13](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar13.png)

5. IntelliJ ile oluşturduğumuz jar dosyalarını bir araya toplamak için Libraries --> IntelliJ --> Libraries2'nin yanına bir jar dizini açıyoruz ve artık yeni jar dosyalarını 
oraya ekleyebiliriz. 

![jar14](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar14.png)

6. Artık jar dosyamız hazır olduğuna göre bizim util paketinden jar dosyası olarak çıktı aldığımız sınıfları silip jar dosyasını yani kütüphaneyi kullanmanın vakti geldi. Bunun
için ise öncelikle proje ile jar dosyalarımız birlikte taşınabilir olsun diye JavaSampleBasic projemiz içine yeni libs dizini açıp bu proje içinde kullanmak istediğimiz kütüphane
lerini buraya ekleyebiliriz. Yani sonuçta jars dosyası bütün jar dosyalarını tutar çalışmak istediğiniz proje ise o projeye ait jar dosyalarını tutar. Projeyi taşıdığınızda eğer
jar dosyaları değişmemişse o proje ile birlikte jar dosyaları da taşınabilmiş olur.

![jar15](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar15.png)

7. Şimdi bu projede oluşturduğumuz kütüphaneyi kullanma işlemi kaldı. Bunun için File --> proje structure --> Libraries --> (+) --> Java --> (Kullanılacak library dizini). 
Bu kısımda aynı zamanda hangi modüllerin bu kütüphaneyi kullanacağını da seçmeliyiz. Şu an için tek bir modülümüz olduğu için onu seçiyoruz.

![jar16](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar16.png)

8. Sonunda kütüphanemiz kullanıma hazır olduğu için Util paketindeki sınıfları artık kütüphane üzerinden kullanabiliriz.

![jar17](https://github.com/eemustafasahin/images/blob/master/IntellJ_JarFileImages/jar17.png)

