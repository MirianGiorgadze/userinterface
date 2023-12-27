Feature: Cards Test


  Background:
    Given Navigate to welcome page
    Then  Welcome page is opened

  @ConfigureDriver
  Scenario: Cards are Opened

    When I click cn here link
    Then Card one is opened

    When I fill form using data
      | password  | email | domain |
      | A1q123q1AA| testq | gmail  |
    And Click on drop down opener button
    And Scroll to dotcom button and click
    And Check term checkBox
    And Click on firstcard next button
    Then Second card is opened

    When I click on three checkbox
    And Click upload button
    And Send picture
    And Click on secondcard next button
    Then Third card is opened

  @ConfigureDriver
  Scenario: Hide help form content
    When I click cn here link
    And I click on hide help button
    Then Help form is hidden

  @ConfigureDriver
  Scenario: Close cookie form
    When I click cn here link
    And Click accept cookies button
    Then Cookie form is closed

  @ConfigureDriver
  Scenario: Close cookie form
    When I click cn here link
    Then Timer is started from "00:00"
