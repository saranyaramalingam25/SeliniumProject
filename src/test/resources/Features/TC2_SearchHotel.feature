@SearchHotel
Feature: Verifying the Adactinhotel search hotel details

  Scenario Outline: Verifying Adactinhotel search page
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three | 1 - One   |

  Scenario Outline: Verifying Adactinhotel search page with mandatory details
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter mandatory details and click on search hotel "<location>","<roomno>","<checkInDate>","<checkoutDate>" and "<adultroom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName  | password | location | roomno    | checkInDate | checkoutDate | adultroom |
      | saranya25 | D03713   | Sydney   | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three |

  Scenario Outline: Verifying Adactinhotel search page with check-in date is greater than check-out date
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel with invalid date error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 31/12/2022  | 30/12/2022   | 3 - Three | 1 - One   |

  Scenario Outline: Verifying Adactinhotel search page without entering any data
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    # And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    And User should search hotels without field details
    Then User should verify after search hotel with an error message "Please Select a Location"

    Examples: 
      | userName  | password |
      | saranya25 | D03713   |
