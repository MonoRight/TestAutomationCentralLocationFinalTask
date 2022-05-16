Feature: FinalTask BBC1 testing functionality
  As a User
  I want to test few functions of the site
  So that I can be sure that site works correctly

  Scenario Outline: Check main article on the site
    Given User opens "<homePage>" page
    When User clicks 'News' button
    Then User checks that main <index> article contains '<text>'
    Examples:
      | homePage             | index | text                                                        |
      | https://www.bbc.com/ | 0     | Ukraine troops reach Russian border near Kharkiv - governor |

  Scenario Outline: Check first <count> secondary articles
    Given User opens "<homePage>" page
    When User clicks 'News' button
    Then User checks first <count> articles in "<order>"
    Examples:
      | homePage             | count | order                                                                                                                                                                                                                                           |
      | https://www.bbc.com/ | 5     | The children's camp that became an execution ground;Names of US supermarket shooting victims released;Biden: We must work together to address hate;Lunar eclipse creates rare super blood Moon;Over a million Covid cases feared in North Korea |

  Scenario Outline: Check first <count> secondary articles
    Given User opens "<homePage>" page
    And User clicks 'News' button
    And User copies 'Coronavirus' selection text
    And User clicks 'Search' button
    And User insert copied text to 'Search' field
    When User clicks 'Search request' button
    Then User checks that <index> article contains "<text>"
    Examples:
      | homePage             | index  | text                                           |
      | https://www.bbc.com/ | 0      | Ministers give coronavirus restrictions update |

  Scenario Outline: Check sending story with correct data
    Given User opens "<homePage>" page
    And User clicks 'News' button
    And User clicks 'Coronavirus' selection
    And User clicks <index> 'Your Coronavirus Stories' selection
    And User clicks 'How to share with BBC News' article
    And User closes pop up window
    And User fills form with data: story - "<story>", name - "<name>", email - "<email>", contact number - "<number>", location - "<location>"
    And User clicks on checkBox 'I accept the Terms of Service'
    When User clicks 'Submit' button
    Then User checks result of sending story, it must contain "<firstParagraph>" and "<secondParagraph>"
    Examples:
      | homePage             | index | story                                                         | name   | email                    | number       | location      | firstParagraph                                                                                               | secondParagraph                                                                       |
      | https://www.bbc.com/ | 0     | Sorry for interruption, it's just testing form for project:^) | Dmytro | gmailtestemail@gmail.com | 123123123123 | Ukraine, Kyiv | Hey Dmytro, thanks for asking your question: ;Sorry for interruption, it's just testing form for project:^); | If we're able to investigate it further, we'll email you at gmailtestemail@gmail.com. |

  Scenario Outline: Check sending story with empty data
    Given User opens "<homePage>" page
    And User clicks 'News' button
    And User clicks 'Coronavirus' selection
    And User clicks <index> 'Your Coronavirus Stories' selection
    And User clicks 'How to share with BBC News' article
    And User closes pop up window
    And User fills form with data: story - "<story>", name - "<name>", email - "<email>", contact number - "<number>", location - "<location>"
    When User clicks 'Submit' button
    Then User checks that error messages displayed: error story empty field - "<errorStory>", error name empty field - "<errorName>", error acceptance terms - "<errorTerms>"
    Examples:
      | homePage             | index | story   | name    | email   | number  | location | errorStory     | errorName           | errorTerms       |
      | https://www.bbc.com/ | 0     |         |         |         |         |          | can't be blank | Name can't be blank | must be accepted |

  Scenario Outline: Check sending story with invalid email
    Given User opens "<homePage>" page
    And User clicks 'News' button
    And User clicks 'Coronavirus' selection
    And User clicks <index> 'Your Coronavirus Stories' selection
    And User clicks 'How to share with BBC News' article
    And User closes pop up window
    And User fills form with data: story - "<story>", name - "<name>", email - "<email>", contact number - "<number>", location - "<location>"
    And User clicks on checkBox 'I accept the Terms of Service'
    When User clicks 'Submit' button
    Then User checks error "<message>" because of invalid email
    Examples:
      | homePage             | index | story                                             | name   | email          | number       | location      | message                  |
      | https://www.bbc.com/ | 0     | Sorry for interruption, its just testing form :^) | Dmytro | incorrectemail | 123123123123 | Ukraine, Kyiv | Email address is invalid |