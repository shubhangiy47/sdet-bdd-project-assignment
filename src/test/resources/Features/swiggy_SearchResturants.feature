Feature: Search resturants on swiggy
  I want to search resturants on swiggy web application

  Scenario Outline: Search resturants for a location
    Given I want to go to swiggy web application
    When I want to enter pincode <pincode> in area,street or pincode in area section and select the option from suggested list
    And Click on Search button on next page and enter resturant name <resturantName> in search field
    Then Select the resturant <resturantName> from the displayed options
   	And Add items from the resturant
   	|Raj Kachori|
   	|Rasgulla|
   	|Plain Gulab Jamun|
   	And remove items
   	|Rasgulla|
   	And check pricing

Examples:
	|pincode|resturantName|
	|"208027"|"Mithas"|
