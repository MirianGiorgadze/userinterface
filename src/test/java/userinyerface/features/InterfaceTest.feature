Feature: Interface Test


  Background:
    Given Navigate to welcome page
    Then  Welcome page is opened

  @ConfigureDriver
  Scenario: Cards are Opened

    When I click on here link
    Then Card one is opened
    When I fill form using data:
      | Password  | A1q123q1AA|
      | Email     | testq     |
      | Domain    | gmail     |
      | Tld       | .com      |

    And Check term checkBox
    And Click on first card next button
    Then Second card is opened

    When I click on three checkbox
    And Click upload button
    And Send picture
    And Click on second card next button
    Then Third card is opened

  @ConfigureDriver
  Scenario: Hide help form content
    When I click on here link
    And I click on hide help button
    Then Help form is hidden

  @ConfigureDriver
  Scenario: Close cookie form
    When I click on here link
    And Click accept cookies button
    Then Cookie form is closed

  @ConfigureDriver
  Scenario: Close cookie form
    When I click on here link
    Then Timer is started from the value stored in json path '/startTime'
