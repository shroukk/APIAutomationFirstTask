@smoke
Feature: Bored API Activity Verification

  Scenario Outline: Verify the API response code and schema
    Given user makes a GET request to "<URL>"
    Then user should receive a 200 status code
    And the response should match the expected schema

    Examples:
      | URL                                   |
      | https://www.boredapi.com/api/activity |
