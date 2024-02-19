@BookHotel
Feature: Verifying the Adactinhotel Book hotel details

  Scenario Outline: Verifying Adactinhotel Book hotel by selecting all fields
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify after select hotel success message "Book A Hotel"
    And User should enter all fields "<firstName>","<lastName>" and "<address>"
      | Credit Card No   | Credit Card Type | Expiry Month | Expiry Date | CVV Number |
      | 1234567890987654 | VISA             | January      |        2022 |        123 |
      | 4561237891593578 | Master Card      | February     |        2022 |        435 |
      | 7418529631237894 | American Express | November     |        2022 |        897 |
      | 7894712358461265 | others           | December     |        2022 |        549 |
    Then User should Verify after booking Success Message "Booking Confirmation"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom | firstName | lastName | address  |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three | 1 - One   | Priyanka  | Kamaraj  | Ambattur |

  Scenario Outline: Verifying Adactinhotel Book hotel page Without Selecting any fields
    Given User is on the Adactinhotel page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login success message "Hello saranya25!"
    And User should enter valid data and click on the search hotel page "<location>","<hotels>","<roomType>","<roomno>","<checkInDate>","<checkoutDate>","<adultroom>" and "<childroom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should select hotel name and click continue
    Then User should verify after select hotel success message "Book A Hotel"
    And User should click book now button without Selecting any fields
    Then User should Verify related Error Messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName  | password | location | hotels      | roomType | roomno    | checkInDate | checkoutDate | adultroom | childroom |
      | saranya25 | D03713   | Sydney   | Hotel Creek | Standard | 3 - Three | 30/12/2022  | 31/12/2022   | 3 - Three | 1 - One   |
