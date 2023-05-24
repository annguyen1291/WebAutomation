Feature: Selenium Live Project

  Scenario: Project Kickoff!
    Given Go to "http://live.techpanda.org"
    Then Verify title of the page to be "THIS IS DEMO SITE FOR   "
    Given Click on "Mobile" menu
    Then Verify title of the page to be "MOBILE"
    Given In the list of all mobile, select "Sort By" dropdown as " Name "
    Then Verify all products are sorted by name

  Scenario: Next Script!
    Given Go to "http://live.techpanda.org"
    When Click on "Mobile" menu
    And Read the cost of "Sony Xperia" mobile from all mobile page
    And Click on "Sony Xperia" mobile
    And Read the cost of "Sony Xperia" mobile from detailed mobile page
    Then Compare value in and detailed mobile page

  Scenario: Handling Popup Windows!
    Given Go to "http://live.techpanda.org"
    When Click on "Mobile" menu
    And Add "IPhone" to compare
    And Add "Samsung Galaxy" to compare
    And Click on "Compare" button
    Then Verify the pop-up window and check that "IPhone" and "Samsung Galaxy" are reflected in it
    And Close the pop-up window

  Scenario: Account Creation
    Given Go to "http://live.techpanda.org"
    When Click on "Account" button then "Register" menu
    And Fill in new user information
    And Click on "Register" button
    Then Verify registration is done
    When Click on "TV" menu
    And Add "LG LCD" to wishlist
    And Click on "Share Wishlist" button
    And Enter email and share wishlist
    Then Verify wishlist is shared