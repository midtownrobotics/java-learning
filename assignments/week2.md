## Week 2 - Car Garage

Your objective is to let a user enter information about each car they own (they may own more than one) and let them do things with whatever car they want to do things with (they may do things with one car, then switch to a different car and do things with that car)

The flow will look something like this:

* Ask the user how many cars he/she has
* For each car, ask them the make, model and color of the car
* Once the user has entered information for each car, display a list of the cars to the user, and let them choose which car to "use"
* For the car they decided to "use", give them the following options:
 * Start the car: changes the car status from "not started" to "started"
 * Stop the car: changes the car status from "started" to "not started"
 * Accelerate: increases the current speed of the car by 5mph
 * Brake: this decreases the current speed of the car by 1mph
 * Print Info: print all the information about the car, i.e. its make, model, color, whether it's started and its current speed

Business rules:

* A car cannot accelerate unless it's started
* A car cannot brake if it's not moving
* A car cannot accelerate past 85mph
* A car that's already started cannot be started again
* A car that's already stopped cannot be stopped again

Note: when I say "cannot" above, it means when the user tries to perform that action, you should display a message to them explaining why that action cannot be taken

### Extras

Integrate polymorphism into this assignment. We haven't discussed polymorphism yet, but if you want to experiment, give it a shot. You will have three sub-classes that extend Car (as described below).

* Create three different sub-classes for the Car class:
 * MiniVan: this type of car is slow and only accelerates by 3mph when you accelerate
 * OldCar: this type of car doesn't start very well and only starts after the third try. Anything before that results in an error message displayed to the user saying "Your car did not start, please try again later"
 * SportsCar: this type of car is fast and accelerates by 10mph when you accelerate. It also has better brakes, so it slows down by 5mph whenever you brake
* When you ask the user about their car(s), ask them the type of car each car is and instantiate the right type at runtime.

Integrate ascii animations into this assignment:

* When a chooses to print information about their car, display an animation of a car moving across the screen
* Make this animation go faster or slower depending on the car's current speed at the time that the animation is displayed
