@HeaderLinkClick
Feature: Verify header link click behavior

  Scenario: Click on Services and Blog header links
  	Given User navigates to "https://therapidhire.com/"
    When  click on "Services" 
    Then  url should be changed
    When  click on "Blog"
