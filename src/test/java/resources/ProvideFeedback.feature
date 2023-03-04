Feature: Provide feedback to Jupiter Toys

  Background:
    Given If you wish to submit a feedback
    When I navigate to "http://jupiter.cloud.planittesting.com" URL
    When I click Contact Option
    
  Scenario: Submit feedback without filling required fields
    Then I submit the feedback form without filling mandatory fields
    Then I validate the errors appear on the screen
    And I close the browser
  
  Scenario Outline: Provide feedback to Jupiter Toys
    When I provide the forename as <forename>
    And I provide the email as <email> 
    And I provide the message as <message>
    Then I click on Submit button
    And I validate the feedback has been submitted successfully
    And I close the browser
    
    Examples:
    | forename  | email | message |
    | "abc"     | "abc@gmail.com" | "Thank you for the wonderful toys" | 
    | "ghj"     | "ghj@gmail.com" | "the product looks impressive" | 
    | "hjk"     | "ghj@gmail.com" | "the product has a good quality" | 
    | "yui"     | "ghj@gmail.com" | "my kids love the toys" | 
    | "yui"     | "ghj@gmail.com" | "Thanks much it recieved om time" | 
    