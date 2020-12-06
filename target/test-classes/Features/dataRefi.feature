Feature: test paramenter refi monthly

@dataDriven_test
  Scenario Outline: Verify monthly payment with the diffrennt input values
    Given  mortgage calculator home page
    When mousehover on Refinance and click RefiCalculator
    And enter input values "<homeValue>", "<downPayment>", "<loanLenght>", "<interestValue>"and click on calculate button
    Then validate the monthly payment "<priceVal>" and return to homepage



    Examples:
    |homeValue|downPayment|loanLenght|interestValue|priceVal|
    |500000| 70000       |25|5| $2,513.74|
    |300000| 30000       |40|6| $1,485.58|





