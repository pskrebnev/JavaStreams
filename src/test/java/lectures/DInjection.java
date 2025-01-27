package lectures;

import beans.Car;

public class DInjection {
  private Car myCar;  // We need a Database to do some work

  // The database comes from somewhere else. Where? That's not my job, that's
  // the job of whoever constructs me: they can choose which database to use.
  DInjection(Car theCar) {
    this.myCar = theCar;
  }
}
