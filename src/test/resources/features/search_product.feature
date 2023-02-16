Feature: Search a product feature
#  Background:
#    Given user is logged in

    @smoke
    Scenario: Verify that the user can able to search a product
      Given the user navigates to the home page
      When the user enter the product name
      Then the product results should be displayed

#    Scenario Outline: Successful login with valid credentials
#      Given user is on home page
#      When the user navigates to the login page
#      And user enters "<username>" and "<password>"
#      Then message displayed login successfully
#      Examples:
#        | username  | password |
#        |testuser_1 | Test@123 |
#        |testuser_2 | Test@133 |
