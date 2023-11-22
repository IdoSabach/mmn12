/**
 * Person
 */
public class Person {

  private String _name;
  private String _id;
  Date _dateOfBirth;

  public Person(String name, String id, Date dateOfBirth) {
    if (name == null) {
      _name = "Someone";
    } else {
      _name = name;
    }

    if (id.length() != 9) {
      _id = "000000000";
    } else {
      _id = id;
    }

    _dateOfBirth = new Date(dateOfBirth);
  }

  public Person(Person other) {
    this._name = other._name;
    this._id = other._id;
    this._dateOfBirth = new Date(other._dateOfBirth);
  }

  public String getName() {
    return _name;
  }

  public String getId() {
    return _id;
  }

  public Date getDateOfBirth() {
    return new Date(_dateOfBirth);
  }

  public void setName(String name) {
    if (name == null) {
      _name = "someone";
    } else {
      _name = name;
    }
  }

  public void setId(String id) {
    if (id.length() == 9) {
      _id = id;
    }
  }

  public void setDateOfBirth(Date d) {
    _dateOfBirth = new Date(d);
  }

  public String toString() {
    return "Name: " + _name + "\n" +
        "ID: " + _id + "\n" +
        "Date of birth: " + _dateOfBirth.toString();
  }

  public boolean equals(Person other) {
    if (this._name == other._name &&
        this._id == other._id &&
        this._dateOfBirth.equals(other._dateOfBirth)) {
      return true;
    } else {
      return false;
    }
  }

  public int compareTo(Person other) {
    if (this._dateOfBirth.after(other._dateOfBirth)) {
      return -1;
    } else if (this._dateOfBirth.before(other._dateOfBirth)) {
      return 1;
    } else {
      return 0;
    }
  }
  
}
