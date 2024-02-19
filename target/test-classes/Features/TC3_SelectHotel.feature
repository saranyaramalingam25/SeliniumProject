@SelectHotel
Feature: Verifying the Adactinhotel select hotel details

  Scenario Outline: Verifying Adactinhotel select hotel page
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify after select hotel success message "Book A Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three | 1 - One   |

  Scenario Outline: Verifying Adactinhotel select hotel without selecting radio button
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should not select hotel radio button and click continue
    Then User should verify after select hotel with an error message "Please Select a Hotel"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three | 1 - One   |
