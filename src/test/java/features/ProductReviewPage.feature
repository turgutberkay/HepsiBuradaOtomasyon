@ProductReviewPage
Feature: ProductReview Feature

  # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.

  @Case-1
  Scenario Outline: Not Logged User like a random product comment
    Given Go To Url "https://hepsiburada.com"
    Then should see Home Page
    When write to "<product>" SearchBox on the Home Page
    When taps to Search Button on the Home Page
    Then should see Not Empty Product List on the Search Page
    When taps to Random Product on the Search Page
    Then should see Product Detail Page
    When taps to Review Tab on the Product Detail Page
    Then should see Product Reviews on the Product Detail Page
    When taps to Sorting Module on the Product Detail Page
    Then should see Sorting Options on the Product Detail Page
    When taps to "<sortingOption>" on the Product Detail Page
    Then should see Product Review Page
    When taps to "<thumbsOption>" thumbs from "<thumbsNumber>" Review on the Product Review Page
    Then should see "<thumbsNumber>" Thank You Text from Review on the Product Review Page
    Examples:
      | product | sortingOption         | thumbsOption | thumbsNumber |
      | iphone  | En yeni değerlendirme | thumbsUp     | 4            |
