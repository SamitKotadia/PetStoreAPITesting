
Feature: API get request Testing for PetStore
  As a user
  I want to to be able get pet data from store
  So that I can validate that API functionality
  @getService
  Scenario: Validate weather data with valid data
    Given I have base uri
    When I execute post request to add pet in store
    Then I should see status code as "200"

#  Scenario: Validate weather data with valid data
#    Given I have base uri
#    When I execute get request by pet Id
#    Then I should see status code as "404"

#  Scenario: Validate weather data with valid data
#    Given I have base uri
#    When I execute delete request by pet Id
#    Then I should see status code as "200"
#    And I execute get request by pet Id
#    And I should see status code as "404"

