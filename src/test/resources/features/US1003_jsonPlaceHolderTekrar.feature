Feature: 
  Scenario: 
    Given Kullanici "jPHBaseUrl" base URL'ini kullanir
    And Path parametreleri icin "posts/88" kullanir
    When POST request icin "Karate","Hazirlik",8 20 bilgileri ile request body olusturur
    Then jPH server a POST request gonderir ve testleri yapmak icin response degerini kaydeder
    And jPH respons'da status degerinin 200