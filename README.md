# Java SOLID Principles: Code Examples - Incorrect vs. Corrected Implementations

![Java - JDK 17.0.7 LTS](https://img.shields.io/static/v1?label=Java&message=JDK+17.0.7+LTS&color=%23007396)

_"Bad"_ Package represents code violating a S.O.L.I.D principle, and _"Good"_ showcases code adhering to a S.O.L.I.D principle.

## Single Responsibility Principle:

#### BAD package:

**Classes**:

1.	**QuestionQuiz**: This class is created to hold the Question, Answer, and Options details. The object of this class represents a single logical Question-Answer present within a Quiz.

2.	**Quiz**: This class is the main manager class, which manages all quiz operations, which include the following functionalities:

-	_loadQuestions_: This is responsible for loading the multiple Quiz Questions and Answers.
-	_displayQuestion_: This function takes in user input corresponding to each Question, option and calculates the score. This helps users to attempt the quiz.
-	_getPercentage_: This function calculates the percentage score obtained by the user after successfully completing the quiz.
-	_getLettergrade_: This is responsible for calculating the letter grade of the quiz attempted successfully by the user based on the percentage obtained.
-	displayResult: This is responsible for displaying the Quiz’s final result after the user answers all questions completely.
-	_saveResult_: This function has the responsibility to save the user’s quiz result to a file, with all the attributes defining that quiz.

#### GOOD package:

**Classes**:

1.	**QuestionQuiz**: This class is created to hold the Question, Answer, and Options details. The object of this class represents a single logical Question-Answer present within a Quiz.

2.	**QuizLoadData**: This class is responsible for loading the Quiz Questions and Answers from a data repository. (In my scenario I have instantiated the questionQuiz objects and created the Quiz)

3.	**QuizManager**: This class is responsible for prompting the user to attempt a quiz by displaying Questions and options to the user. Additionally, it is also responsible for displaying performance results to users by communicating with the QuizEvaluator instance.

4.	**QuizEvaluator**: This class is responsible for handling the Grading, and performance evaluation aspects of the successfully attempted quiz. 

5.	**QuizSaveResultsToDisk**: This class is responsible for saving the user’s grades and quiz performance to file.


#### Why is this BAD/Violating Single Responsibility Principle?
The reason for this is that the class named: ‘Quiz’, has methods defined which is responsible for multiple tasks. The Single Responsibility Principle (SRP) states each class should fulfil only one responsibility. In this case, the Quiz class is responsible for:
1.	Loading or retrieval of Quiz question answers from the data repository.
2.	Displaying (console prompts and display) and functionality to Attempt Quiz
3.	Calculating Grades and Evaluating Quiz Results Performance
4.	Saving Results to file in the directory.
Hence, clearly, this is a violation of SRP. To fulfill the SRP the single Quiz class needs to be split or divided across multiple classes, such that each class fulfills a single responsibility. Let’s have a look below at the Corrected scenario.

___

## Open Closed Principle:

#### BAD package:

**Classes**:

1.	**RestaurantMenuItem**: This class stores a Menu Item detail, like the item’s name, price and its type (which is item cuisine or item type).

2.	**RestaurantOrder**: This class represents the order of the customer, which holds the different menu items ordered by the customer. It has functions for adding menu Items in a List of menu items, generating the total order bill amount with tax applied to it.


#### GOOD package:

**Interfaces**:

1.	**IRestaurantOrder**: Interface which holds the information about a standard order. In my case, it has two functions. First is the generation of the order’s total bill amount, second is to display the invoice. Moreover, this class can be implemented by concrete classes to further extend functionalities.

**Classes**:

1.	**RestaurantMenuItem**: This class stores a Menu Item detail, like the item’s name, price and its type (which is basically item cuisine or item type).

2.	**RestaurantOrder**: This class represents the standard basic restaurant order bill with tax calculation functionality. This class implements the interface IRestaurantOrder. 

3.	**SpecialOfferRestaurantOrder**: This class represents the extension of the standard basic Order bill, with cashback discount functionality included in it. This class also implements the interface IRestaurantOrder. The cashback logic is included inside the overridden generateTotalOrderBillAmount function from the interface.

#### Why is this BAD/Violating Open Closed Principle?
The reason why this is violating the open-closed principle is because if I want to introduce a new feature, including weekly or festival day discounts or occasional cashback on certain menu item orders or limited-time coupons on customer dining. Then in this scenario based on the above class, it is not possible to incorporate these features, and it is not possible to add order-related features as well without modifying the existing class code base (which is the class named: RestaurantOrder), which violates the open-closed principle (OCP) as it is open for modification and greatly increases the risk of introducing bugs into the code base. As OCP says the software entities should be open for extension but closed for modification. [3] This can be corrected by creating a standard Restaurant Order Interface contract, and then extending the new features like special offer orders, and coupon orders by implementing this Restaurant order interface.
___

## Liskov Substituition Principle:

#### BAD package:

**Classes**:

1.	**EventSesion**: This is a class which represents a single simple logical session of an event. An example for this to understand is: I can have a session called “Introduction to IBM HR managers” as the first session of a business conference event called “IBM showcase”.

2.	**Event**: This class represents the event entity, having multiple event sessions inside it for different event Types. It has the functionality of generating an event schedule based on the event type.


#### GOOD package:

**Classes**:

1.	**EventSesion**: This is a class which represents a single simple logical session common for any event.

2.	**Exhibition**: This concrete class represents the cultural or technical Exhibition event entity type. This class extends the abstract class Event. This class has a custom implementation for the generateSchedule method specific to the Exhibition entity. 

3.	**Conference**: This concrete class represents the business Conference event entity type. This class extends the abstract class Event. This class has a custom implementation for the generateSchedule method specific to a Conference entity. 

4.	**Concert**: This concrete class represents the Musical or DJ Concert event entity type. This class extends the abstract class Event. This class has a custom implementation for the generateSchedule method specific to the Concert entity. 


#### Why is this BAD/Violating Liskov Substitution Principle?
The reason why this code example scenario violates LSP is because the method generateSchedule in the Event class checks the type of event and then performs the action based on the event type. This violates the LSP the specific behaviour is assumed based on the event type. Moreover, adding a new event type for example: Technical and Meditation ‘Workshops’ would require the modification of the generateSchedule method in the Event class, which violates the Liskov Substitution principle.

___

## Interface Segregation Principle:

#### BAD package:

**Interface**:

1.	**Spacecraft**: This interface is responsible for creating the blueprint of a standard spacecraft. This includes method signatures for launch, fly, land, collectSamples, analyzeSamples, communicate, locateSampleSource. 

**Classes**:

1.	**SpaceXRover**: This concrete class represents the Rover spacecraft of spaceX. This class implements the interface Spacecraft and overrides the method for implementing the Rover-specific functionalities.

2.	**SpaceXStarship**: This concrete class represents the Starship spacecraft of spaceX. This class implements the interface Spacecraft and overrides the method for implementing the Starship rocket spacecraft-specific functionalities.

#### GOOD package:

**Interfaces**:

1.	**BasicSpacecraft**: This interface includes the basic functionality or methods defining a basic spacecraft. This includes functions to: launch, fly, and land a spacecraft.

2.	**ExplorerSpacecraft**: This interface includes the functionality performed by a spacecraft that is responsible for exploration. Currently, this includes methods for locating sample mineral sources. 

3.	**AnalyzingEngineSpacecraft**: This interface includes additional advanced functionality of a spacecraft to perform analysis. The methods in this interface include: collecting samples and a method to analyzeSamples.

4.	**CommunicationSpacecraft**: This interface is responsible for the different communication functionalities that a spacecraft may include. Currently, it has a method called communicate, which is for communicating with Earth. For a more extensive scenario, it can also include a communication method for communicating between Rovers or Starships or even for communicating coordination messages among spacecraft.

**Classes**:

1.	**SpaceXRover**: This concrete class represents the Rover spacecraft of spaceX. This class implements the interfaces BasicSpacecraft, CommunicationSpacecraft, and ExplorerSpacecraft. It implements a BasicSpacecraft interface so the rover can have the basic functionalities for movement in space. It implements CommunicationSpacecraft because it needs to send messages to Earth about resource locations. Lastly, it implements ExplorerSpacecraft because it needs to find or explore new resource locations. This exploration is done only by Rover and not by Starship.

2.	**SpaceXStarship**: This concrete class represents the Starship spacecraft of spaceX. This class implements the interfaces BasicSpacecraft, AnalyzingEngineSpacecraft, and CommunicationSpacecraft. The reason for implementing BasicSpacecraft and CommunicationSpacecraft is so that Starship has basic movement and communication capabilities respectively. Lastly, the reason for implementing AnalyzingEngineSpacecraft is that Starship can collect samples from a location, and analyze them. This analysis is done only by Starship and not Rover.


#### Why is this BAD/Violating Interface Segregation Principle?

The reason why this example is violating ISP is that there are few methods in the Spacecraft interface which are not needed to be implemented by all the spacecraft. In this specific example, Rover is not responsible for collecting and analyzing samples. Hence when the Rover class implements this interface it has to compulsorily override these methods which are not a part of the Rover concrete class. Similarly with Starship whose responsibility is to collect and analyze samples but NOT locate sample sources, thus again a method is being implemented which it does not use or represent that concrete class. Hence, violating the ISP. 
The solution to this is to segregate the single common interface Spacecraft into multiple specific interfaces. 

___

## Dependency Inversion Principle:


#### BAD package:

**Classes**:

1.	**PaymentTransaction**: This class includes the basic Payment Transfer Transaction details like the date and time of when the transaction occurred, transaction ID, the amount transferred, transaction remarks, and payment status.

2.	**SBIPaymentAgent**: This class represents the State Bank of India (SBI) bank-specific agent implementation, which utilizes PaymentTransaction for storing, tracking and managing transactions. The methods include initiating interac money transfers, processing payment transfers, refunding payment transfers, displaying transaction history, total money transfers processed in a day, and the number of payments processed in a day.

3.	**PaymentGateway**: This can be considered as the main Payment Gateway controller which controls the different payment agents for payment transfer on the e-commerce platform. Currently, in my example, I have taken a single payment agent for payment tracking by agent.


#### GOOD package:

**Interfaces**:

1.	**PaymentManager**: This is the interface which has the common functionalities that each Payment Agent should possess in order to perform the action on transactions.

**Classes**:

1.	**PaymentTransaction**: This class represents the single logical payment transaction unit. This includes basic Payment Transfer Transaction details like the date time of when the transaction occurred, transaction ID, the amount transferred, transaction remarks, and payment status.

2.	**SBIPaymentAgent**: This class represents the State Bank of India (SBI) bank-specific agent implementation, which utilizes PaymentTransaction for storing, tracking and managing transactions. This class implements the PaymentManager interface for implementing the agent-specific logic for transaction processing. The methods include initiating interac money transfers, processing payment transfers, refunding payment transfers, displaying transaction history, total money transfers processed in a day, and the number of payments processed in a day.

3.	**PaymentGateway**: This can be considered as the main Payment Gateway controller which controls the different payment agents for payment transfer on the e-commerce platform. Here, the Payment Agent is injected via its constructor.


#### Why is this BAD/Violating Dependency Inversion Principle?
The reason this example violates DIP is because the concrete class “PaymentGateway” is highly dependent on the “SBIPaymentAgent” concrete class, which creates tight coupling among these classes. Moreover, when looking at the implementation for handling the agent-specific payment transfer functions, All of these functions are invoked on the specific PaymentAgent class object. 
Hence, This violates DIP, as DIP states that the high-level and low-level modules should depend on abstractions and not on actual concrete modules. 
To solve this issue an interface for Payment Agents can be created which has the basic functionalities which are common across all the payment agents. Then each of the concrete agent classes can implement this interface and override the methods with their agent-specific payment transfer logic. 


___
___
