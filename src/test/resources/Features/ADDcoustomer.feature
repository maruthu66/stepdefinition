
Feature: Add coustomer in demo site
  Scenario: Add coustomer with hard coded datas
    Given User launches demo telecom site
    And User click on add coustomer button
    When User enter all the fields
    And User click on subit button
    Then User should be displayed coustomer ID is generated or not
