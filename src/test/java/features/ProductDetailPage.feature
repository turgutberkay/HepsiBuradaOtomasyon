@ProductPage
Feature: Product Feature

  # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartisabiliriz.
  # Normalde case calismasinde benden istenen case-3. Fakat login olma durumu blocklandıgı icin ve senaryo devam edemedigi icin login olmadan gostermek adına case-2 yi de ekstra olarak yazdım.

  @Case-2
  Scenario Outline: Not Logged User if has not liked a random product before like it
    Given Go To Url "https://hepsiburada.com"
    Then should see Home Page
    When write to "<product>" SearchBox on the Home Page
    When taps to Search Button on the Home Page
    Then should see Not Empty Product List on the Search Page
    When taps to Random Product on the Search Page
    Then should see Product Detail Page
    When taps to Like Button on the Product Detail Page
    Then should see Login Page
    Examples:
     | product    |
     | macbook    |


  @Case-3
  Scenario Outline: Logged User if has not liked a random product before, like it
    Given Go To Url "https://hepsiburada.com"
    Given User Logged In "<email>" "<password>"
    When write to "<product>" SearchBox on the Home Page
    When taps to Search Button on the Home Page
    Then should see Not Empty Product List on the Search Page
    When taps to Random Product on the Search Page
    Then should see Product Detail Page
    When if not clicked before taps to Like Button on the Product Detail Page
    Then if like button now clicked should see message "<message>" on the Product Detail Page
    Examples:
      | email                    | password     | product    | message                 |
      | denemepoc123@gmail.com   | Denemepoc123 | macbook    | Ürün listenize eklendi. |