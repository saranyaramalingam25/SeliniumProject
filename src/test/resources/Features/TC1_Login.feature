@Login
Feature: Verifying the Adactinhotel login details

  Scenario Outline: Verifying Adactinhotel login with valid data
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"

    Examples: 
      | userName  | password |
      | saranya25 | D03713   |

  Scenario Outline: Verifying Adactinhotel login using Enter
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>" with Enter key
    Then User should verify after login success message "Hello saranya25!"

    Examples: 
      | userName  | password |
      | saranya25 | D03713   |

  Scenario Outline: Verifying Adactinhotel login with Invalid data
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login with invalid data error message contains "Invalid Login"

    Examples: 
      | userName  | password |
      | saranya25 | D03713   |
