/**
 * The Apartment class represents an apartment with details such as the number
 * of rooms, area, price, tenant, and rental dates.
 */
public class Apartment {

  private int _noOfRooms;
  private double _area;
  private double _price;
  Person _tenant;
  Date _rentalStartDate;
  Date _rentalEndDate;

  private final int DEFAULT_ROOM = 3;
  private final int DEFAULT_NUM_FOR_ADD_DATE = 1;
  private final double DEFAULT_AREA = 80;
  private final double DEFAULT_PRICE = 5000;

  /**
   * Constructs a new Apartment object with the specified details.
   *
   * @param room   The number of rooms in the apartment. If less than or equal to
   *               0, the default is set to 3.
   * @param area   The area of the apartment. If less than or equal to 0, the
   *               default is set to 80.
   * @param price  The price of the apartment. If less than or equal to 0, the
   *               default is set to 5000.
   * @param tenant The tenant of the apartment.
   * @param start  The rental start date.
   * @param end    The rental end date. If before the start date, a default end
   *               date is set.
   */
  public Apartment(int room, double area, double price, Person tenant, Date start, Date end) {
    if (room <= 0) {
      _noOfRooms = DEFAULT_ROOM;
    } else {
      _noOfRooms = room;
    }

    if (area <= 0) {
      _area = DEFAULT_AREA;
    } else {
      _area = area;
    }

    if (price <= 0) {
      _price = DEFAULT_PRICE;
    } else {
      _price = price;
    }

    _tenant = new Person(tenant);
    _rentalStartDate = new Date(start);

    if (end.after(start)) {
      _rentalEndDate = new Date(end);
    } else {
      _rentalEndDate = end.addYearsToDate(DEFAULT_NUM_FOR_ADD_DATE);
    }
  }

  /**
   * Constructs a new Apartment object that is a copy of the specified Apartment
   * object.
   *
   * @param other The Apartment object to copy.
   */
  public Apartment(Apartment other) {
    this._noOfRooms = other._noOfRooms;
    this._area = other._area;
    this._price = other._price;
    this._tenant = new Person(other._tenant);
    this._rentalStartDate = new Date(other._rentalStartDate);
    this._rentalEndDate = new Date(other._rentalEndDate);
  }

  /**
   * Gets the number of rooms in the apartment.
   *
   * @return The number of rooms.
   */
  public int getNoOfRooms() {
    return _noOfRooms;
  }

  /**
   * Gets the area of the apartment.
   *
   * @return The area of the apartment.
   */
  public double getArea() {
    return _area;
  }

  /**
   * Gets the price of the apartment.
   *
   * @return The price of the apartment.
   */
  public double getPrice() {
    return _price;
  }

  /**
   * Gets the tenant of the apartment.
   *
   * @return The tenant of the apartment.
   */
  public Person getTenant() {
    return new Person(_tenant);
  }

  /**
   * Gets the rental start date.
   *
   * @return The rental start date.
   */
  public Date getRentalStartDate() {
    return new Date(_rentalStartDate);
  }

  /**
   * Gets the rental end date.
   *
   * @return The rental end date.
   */
  public Date getRentalEndDate() {
    return new Date(_rentalEndDate);
  }

  /**
   * Sets the number of rooms in the apartment.
   *
   * @param num The new number of rooms. If less than or equal to 0, the default
   *            is set to 3.
   */
  public void setNoOfRooms(int num) {
    if (num <= 0) {
      _noOfRooms = DEFAULT_ROOM;
    } else {
      _noOfRooms = num;
    }
  }

  /**
   * Sets the area of the apartment.
   *
   * @param area The new area. If less than or equal to 0, the default is set to
   *             80.
   */
  public void setArea(double area) {
    if (area <= 0) {
      _area = DEFAULT_AREA;
    } else {
      _area = area;
    }
  }

  /**
   * Sets the price of the apartment.
   *
   * @param price The new price. If less than or equal to 0, the default is set to
   *              5000.
   */
  public void setPrice(double price) {
    if (price <= 0) {
      _price = DEFAULT_PRICE;
    } else {
      _price = price;
    }
  }

  /**
   * Sets the tenant of the apartment.
   *
   * @param p The new tenant.
   */
  public void setTenant(Person p) {
    _tenant = new Person(p);
  }

  /**
   * Sets the rental start date.
   *
   * @param d The new rental start date.
   */
  public void setRentalStartDate(Date d) {
    _rentalStartDate = new Date(d);
  }

  /**
   * Sets the rental end date.
   *
   * @param d The new rental end date. If before the start date, a default end
   *          date is set.
   */
  public void setRentalEndDate(Date d) {
    if (d.after(getRentalStartDate())) {
      _rentalEndDate = new Date(d);
    } else {
      _rentalEndDate = d.addYearsToDate(DEFAULT_NUM_FOR_ADD_DATE);
    }
  }

  /**
   * Returns a string representation of the apartment.
   *
   * @return The string representation of the apartment.
   */
  public String toString() {
    return "Number of rooms: " + _noOfRooms + "\n" +
        "Area: " + _area + "\n" +
        "Price: " + _price + " NIS" + "\n" +
        "Tenant name: " + _tenant.getName() + "\n" +
        "Rental start date: " + _rentalStartDate.toString() + "\n" +
        "Rental end date: " + _rentalEndDate.toString();
  }

  /**
   * Checks if the current apartment is equal to another apartment.
   *
   * @param other The apartment to compare.
   * @return True if the apartments are equal, false otherwise.
   */
  public boolean equals(Apartment other) {
    if (this._noOfRooms == other._noOfRooms &&
        this._area == other._area &&
        this._price == other._price &&
        this._tenant.equals(other._tenant) &&
        this._rentalStartDate.equals(other._rentalStartDate) &&
        this._rentalEndDate.equals(other._rentalEndDate)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Extends the rental period by the specified number of years.
   *
   * @param year The number of years to extend the rental period.
   */
  public void extendRentalPeriod(int year) {
    if (year <= 0) {
      return;
    }
    Date newEndDate = _rentalEndDate.addYearsToDate(year);
    _rentalEndDate = new Date(newEndDate);
  }

  /**
   * Calculates the number of days left until the specified date.
   *
   * @param d The date to calculate the days left until.
   * @return The number of days left. If the specified date is after the rental
   *         end date, returns -1.
   */
  public int daysLeft(Date d) {
    if (d.after(_rentalEndDate)) {
      return -1;
    }
    return _rentalEndDate.difference(d);
  }

  /**
   * Changes the tenant, rental start date, and price of the apartment if
   * conditions are met.
   *
   * @param startDate       The new rental start date.
   * @param candidateTenant The new tenant.
   * @param price           The new price.
   * @return True if the tenant is changed, false otherwise.
   */
  public boolean changeTenant(Date startDate, Person candidateTenant, double price) {
    if (candidateTenant.getDateOfBirth().after(getTenant().getDateOfBirth()) &&
        price >= getPrice() &&
        startDate.difference(this._rentalEndDate)<90) {
      setTenant(candidateTenant);
      setPrice(price);
      setRentalStartDate(startDate);
      setRentalEndDate(startDate.addYearsToDate(1));
      return true;
    }

    return false;

  }

}
