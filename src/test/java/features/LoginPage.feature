@LoginPage
Feature: LoginPage Feature

    # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.
  @Case-4
  Scenario Outline: User successful login
    Given Go To Url "https://hepsiburada.com"
    Then should see Home Page
    When taps to Login Button on the Home Page
    Then should see Login Page
    When write to "<email>" Email Textbox on the Login Page
    When taps to Login Button Email on the Login Page
    Then should see Password Textbox on the Login Page
    When write to "<password>" Password Textbox on the Login Page
    When taps to Login Button Password on the Login Page
    Then should see Logged In Home Page
    Examples:
      | email                   | password     |
      | denemepoc123@gmail.com  | Denemepoc123 |