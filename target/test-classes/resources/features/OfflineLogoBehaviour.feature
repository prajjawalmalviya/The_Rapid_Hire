@OfflineLogoBehaviour
Feature: Verify logo click behavior when offline

  Scenario: Clicking the logo while offline should not refresh the page or show a warning
    Given The User Refresh The Page
    When User disables internet connection
    And User clicks on the website logo
    Then The page should not refresh

