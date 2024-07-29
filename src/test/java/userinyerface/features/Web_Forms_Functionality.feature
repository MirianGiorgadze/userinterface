@allure.label.owner:MirianGiorgadze
Feature: Web_Forms_Functionality


#  Background:


  Scenario: Check if delete button appears and disappears
    Given I Navigate to Main page
    Then Main Page is displayed
    And I click on file upload link
    Then Upload page is opened
    When I click the choose file button
    And I upload file
    And I click the upload button
    Then File upload page is opened
    And There is File Uploaded message with name of "Koshi.jpg"

