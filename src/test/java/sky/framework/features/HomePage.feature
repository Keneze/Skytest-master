Feature: Homepage sanity test

  Scenario: Check homepage title and categories
    Given I navigate to skynews homepage
    And I see the homepage banner
    Then I verify the title of the browser tab is 'The Latest News from the UK and Around the World | Sky News'
    And I verify 10 categories are displayed
    And I verify below is list of categories displayed
    | Home           |
    | UK             |
    | World          |
    | Politics       |
    | US             |
    | Ocean Rescue   |
    | Science & Tech |
    | Business       |
    | Ents & Arts    |
    | Offbeat        |


    Scenario: Check focus of selected category
      Given I navigate to skynews homepage
      Then I verify that the default focus point is on 'Home' category
      And I click 'Ocean Rescue' category
      And I verify that the focus is now on Ocean Rescue


    Scenario: Verify the title of a category page
      Given I navigate to skynews homepage
      When I click 'World' category
      Then I verify I am taken to the correct page
    ##  And I verify the page contains "TEXT"

