@smoke
  Feature: Main_Features_Hover_Categories |  user can hover on categories
    Scenario: user can hover on anyone of the first three main category and select random sub category
      When user hover on main categories
      And user can select random one of the three sub categories
      Then user redirected to sub category page
