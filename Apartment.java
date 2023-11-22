/**
 * Apartment
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
      _rentalEndDate = new Date(end);;
    } else {
      _rentalEndDate = end.addYearsToDate(DEFAULT_NUM_FOR_ADD_DATE);
    }

  }

  public Apartment(Apartment other) {
    this._noOfRooms = other._noOfRooms;
    this._area = other._area;
    this._price = other._price;
    this._tenant = new Person(other._tenant);
    this._rentalStartDate = new Date(other._rentalStartDate);
    this._rentalEndDate = new Date(other._rentalEndDate);
  }

  public int getNoOfRooms() {
    return _noOfRooms;
  }

  public double getArea() {
    return _area;
  }

  public double getPrice() {
    return _price;
  }

  public Person getTenant() {
    return new Person(_tenant);
  }

  public Date getRentalStartDate() {
    return new Date(_rentalStartDate);
  }

  public Date getRentalEndDate() {
    return new Date(_rentalEndDate);
  }

  public void setNoOfRooms(int num) {
    if (num <= 0) {
      _noOfRooms = DEFAULT_ROOM;
    } else {
      _noOfRooms = num;
    }
  }

  public void setArea(double area) {
    if (area <= 0) {
      _area = DEFAULT_AREA;
    } else {
      _area = area;
    }
  }

  public void setPrice(double price) {
    if (price <= 0) {
      _price = DEFAULT_PRICE;
    } else {
      _price = price;
    }
  }

  public void setTenant(Person p) {
    _tenant = new Person(p);
  }

  public void setRentalStartDate(Date d) {
    _rentalStartDate = new Date(d);
  }

  public void setRentalEndDate(Date d) {
    if (d.after(getRentalStartDate())) {
      _rentalEndDate = new Date(d);;
    } else {
      _rentalEndDate = d.addYearsToDate(DEFAULT_NUM_FOR_ADD_DATE);
    }
  }

  public String toString() {
    return "Number of rooms: " + _noOfRooms + "\n" + 
           "Area: " + _area + "\n" + 
           "Price: " + _price + " NIS" + "\n" + 
           "Tenant name: " + _tenant.getName() + "\n" + 
           "Rental start date: " + _rentalStartDate.toString() + "\n" + 
           "Rental end date: " + _rentalEndDate.toString();
  }

  public boolean equals(Apartment other){
    if(this._noOfRooms == other._noOfRooms &&
       this._area == other._area &&
       this._price == other._price &&
       this._tenant.equals(other._tenant) &&
       this._rentalStartDate.equals(other._rentalStartDate) &&
       this._rentalEndDate.equals(other._rentalEndDate)){
        return true;
       }else{
        return false;
       }
  }

  public void extendRentalPeriod(int year){
    _rentalEndDate.addYearsToDate(year);
  }

  public int daysLeft(Date d){
    if(d.after(_rentalEndDate)){
      return -1;
    }
    return _rentalEndDate.difference(d);
  }

  public boolean changeTenant(Date startDate, Person candidateTenant, double price) {
    if (candidateTenant.compareTo(getTenant()) < 0 &&
        price >= getPrice() &&
        startDate.before(getRentalEndDate().addYearsToDate(-1))) {
      setTenant(candidateTenant);
      setPrice(price);
      setRentalStartDate(startDate);
      setRentalEndDate(startDate.addYearsToDate(1));
      return true;
    }
    return false;
  }
  

}
