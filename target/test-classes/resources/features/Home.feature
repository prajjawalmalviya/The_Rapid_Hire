
@HomePage
Feature: Verify Home Page functionality of TheRapidHire Website
	
  Scenario: User opens the home page 
  	Given User Lunch Broweser    
    When User navigates to "https://therapidhire.com/"
    Then Accept All The Cookies 
    Then Home page should be displayed
    And Page title should be "TheRapidHire-Software Development | IT outsourcing Company"
    And "All Information" link should be visible
 	 
  		 
