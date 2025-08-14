@HeaderNavigation
Feature: Verify header navigation and logo visibility

  Scenario: Logo and navigation menu are visible
  	Given User navigates to "https://therapidhire.com/"
    Then Website logo should be visible
    When Website logo should be clickable
    And The following menu items should be visible
      | We Are      |
      | Services    |
      | Technology  |
      | Blog        |
      | Our Work    |

  Scenario: Click on links in HeaderNavigation Links
  	Given User navigates to "https://therapidhire.com/"  	
    When Links should be visible
    Then click on links one by one
