
Feature:Beymen alışveriş sitesi fonksiyonel otomasyon test adımlarını uygulamak.

 User Story: Kullanıcı Beymen alışveriş sitesinde arama motoruna kelime ekleyebilmeli, silebilmeli , ürün seçebilmeli
 , ürün doğrulaması ve raporlamasını yapabilmelidir.
@wip
 Scenario:Kullanıcı "Beymen"e-ticaret alışveriş sitesi otomasyon test adımlarını gerçekleştirebilmeli ve doğrulamalı.
  Given Kullanıcı beymen anasayfasında.
  When  Kullanıcı arama motoruna tıklar ve şort yazar.
  And   Kullanıcı arama motorundaki kelimeyi siler.
  And   Kullanıcı arama motoruna gömlek yazar ve klavyeden ENTER butonuna tıklar.
  And   Kullanıcı ürün seçer ve ürüne tıklar.
  And   Kullanıcı ürünün bedenini seçip sepete ekle butonuna tıklar.
  Then  Ürün sayfasındaki ürünün fiyatıyla sepetteki ürünün fiyatını doğrulama
  And   Ürün adeti artırılır ve doğrulanır.
  And   Ürün silinir ve silindiği doğrulanır.



