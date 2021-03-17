Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    And User checks bag icon visibility
    And User checks wishList icon visibility
    And User checks my account icon visibility
    And User checks footer visibility
    Examples:
      | homePage                      |
      |   https://www.asos.com/       |

  Scenario Outline: Check add product to bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens first product
    And User chooses size of the product
    And User clicks on add to bag button
    Then User checks that the number of products in bag is '<numberOfProducts>'
    Examples:
      | homePage              | keyword | numberOfProducts |
      | https://www.asos.com/ | skirt   | 1                |

  Scenario Outline: Check Signing In
    Given User opens '<homePage>' page
    And User checks my account icon visibility
    And User clicks on my account icon
    And User checks account dropdown visibility
    And User clicks sign in button
    And User checks that page title is '<signInTitle>'
    And User checks username field visibility
    And User checks password field visibility
    And User checks sign in button visibility
    When User enters '<email>' into username field
    And User enters '<password>' into password field
    And User clicks on sign in button
    And User clicks on my account icon
    And User checks account dropdown visibility
    And User checks greeting visibility
    Then User checks that the message says '<greeting>'
    Examples:
      | homePage                | signInTitle     | email                    | password              | greeting |
      | https://www.asos.com/   | ASOS \| Sign in | sasha440024@gmail.com    | sashasherstyuk        | Hi Саша  |

  Scenario Outline: Check adding to wish list
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses size of the product
    When User clicks on add to wish list button
    And User goes to wish list page
    Then User checks that the number of products in list is '<numberOfProducts>'
    Examples:
      | homePage              | keyword | numberOfProducts     |
      | https://www.asos.com/ | 1838961 | 1 item               |


  Scenario Outline: Check moving items from wish list to shopping bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses size of the product
    And User clicks on add to wish list button
    And User goes to wish list page
    And User checks that the number of products in list is '<numberOfProductsInList>'
    When User clicks move to bag button
    And User checks that no items message is displayed
    And User sees added to bag popup
    Then User checks that the number of products in bag is '<numberOfProducts>'
    Examples:
      | homePage              | keyword | numberOfProductsInList     | numberOfProducts |
      | https://www.asos.com/ | 1838961 | 1 item                     | 1                |

  Scenario Outline: Check adding product to bag and proceeding to bag page
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User chooses size of the product
    And User clicks on add to bag button
    And User sees added to bag popup
#    And User checks that pup up message says '<message>'
    And User checks that the number of products in bag is '<numberOfProducts>'
    When User clicks on checkout button
    And User checks username field visibility
    And User checks password field visibility
    And User checks sign in button visibility
    When User enters '<email>' into username field
    And User enters '<password>' into password field
    And User clicks on sign in button
    Then User checks that the page title is '<checkoutTitle>'

    Examples:
      | homePage              | keyword | message                                     | numberOfProducts     | email                    | password              | checkoutTitle    |
      | https://www.asos.com/ | 1838961 | It's in the bag - We'll hold it for an hour | 1                    | sasha440024@gmail.com    | sashasherstyuk        | ASOS \| Checkout |

  Scenario Outline: Try checkout from Bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User opens first product
    And User chooses size of the product
    And User clicks on add to bag button
    And User checks that the number of products in bag is '<numberOfProducts>'
    And User clicks on bag icon
    And User sees bag dropdown
    When User clicks on view bag button
    And User checks that the page title is '<shoppingBagTitle>'
    Then User checks that the heading says '<title>'
    And User clicks checkout button
    And User enters '<email>' into username field
    And User enters '<password>' into password field
    And User clicks on sign in button
    And User checks that page title is '<checkoutTitle>'

    Examples:
      | homePage              | keyword | numberOfProducts | shoppingBagTitle     | title  | email                 | password       | checkoutTitle    |
      | https://www.asos.com/ | skirt   | 1                | Shopping Bag \| ASOS | MY BAG | sasha440024@gmail.com | sashasherstyuk | ASOS \| Checkout |

  Scenario Outline: Open brand page
    Given User opens '<womenHomePage>' page
    And User makes sure that logo list is visible
    When User clicks on selected brand
    Then User checks that the page title is '<pageTitle>'
    Examples:
      | womenHomePage                    | pageTitle                                        |
      | https://www.asos.com/women/ | Topshop \| Shop Topshop Jeans, Dresses & Tops \| ASOS |

  Scenario Outline: Check the work of footer
    Given User opens '<homePage>' page
    And User scrolls to footer
    And User checks footer visibility
    When User clicks on about us
    Then User checks that page title is '<aboutUsTitle>'
    Examples:
      | homePage              | aboutUsTitle                                                    |
      | https://www.asos.com/ | ASOS \| Designer Clothes \| Womens Clothing \| Womens Fashion   |