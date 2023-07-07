Feature: Sign-up
    As a unregistered user,
    I want to sign-up for an account,
    So that I can use the website

  Scenario: Sign-up form is displayed
    Given the unregistered user is on the Facebook homepage
    When the user clicks on the sign-up button
    Then a sign-up form should be displayed

  Scenario: User is signed up with valid information
    Given the unregistered user is on the sign-up modal
    When the user fills out the form
      | name | last name | email          | password         | day | month   | year | gender             |
      | John | Doe       | test1@test.com | ThisIsAPassw0rd! |   1 | january | 1999 | male               |
      | Yona | Doe       | test2@test.com | ThisIsAPassw0rd! |   1 | january | 1999 | female             |
      | Alex | Doe       | test3@test.com | ThisIsAPassw0rd! |   1 | january | 1999 | other (non-binary) |
    And the user clicks on the sign-up button
    Then the user should be signed up
    And the modal should be closed
    And the user should be redirected to welcome page
    And the user should recieve a confirmation email

  Rule: Validations of the modal

    Background: user is on the sign-up modal
      Given the unregistered user is on the sign-up modal

    Scenario: Sign-up form is not fully fullfilled
      Given the unregistered user is on the sign-up modal
      And the user fills out the form
      When the user empties a field
      And the user clicks on the sign-up button
      Then the user should not be signed up
      And an error message should be displayed in the empty field

    Scenario: Sign-up form is close by clicking on the close button
      Given the unregistered user is on the sign-up modal
      When the user clicks on the close button
      Then the sign-up modal should be closed

    Scenario Outline: Validation on input fields
      When the user fills out the "<field>" field with "<value>"
      And the user focus out of the field
      And the user clicks on the error icon
      Then the user should see the "<error>" error message in the field with the following message
        """
        <message>
        """

      Examples: 
        | field     | value           | message                                                                                       |
        | firstName |             123 | What's your name?                                                                             |
        | lastName  |             123 | What's your last name?                                                                        |
        | email     | NotAnEmail      | Enter a valid email                                                                           |
        | password  | InvalidPassword | Your password should be a combination of letters, numbers, and symbols with at least 8 digits |

    Scenario Outline: Validation on birth date
      When the user select the "<day>" day
      And the user select the "<month>" month
      And the user select the "<year>" year
      And the user clicks on the error icon
      Then the user should see the "<message>" error message in the birth date field with the following message
        """
        <message>
        """

      Examples: 
        | day | month    | year | message                                       |
        |  31 | february | 1999 | Please choose a valid date.                   |
        |  29 | february | 1999 | Please choose a valid date.                   |
        |  31 | november | 1999 | Please choose a valid date.                   |
        |   1 | july     | 2022 | You must be at least 13 years old to sign up. |

  Rule: Validate redirections

    Scenario Outline: Information pages
      Given the unregistered user is on the sign-up modal
      When the user clicks on the "<link>" link
      Then the user should be redirected to the "<url>" page

      Examples: 
        | link                 | url                                        |
        | more info            | https://www.facebook.com/help/             |
        | terms and conditions | https://www.facebook.com/legal/terms       |
        | data policy          | https://www.facebook.com/about/privacy     |
        | cookies policy       | https://www.facebook.com/policies/cookies/ |
