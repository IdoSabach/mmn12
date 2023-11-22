/**
 * The Person class represents a person with a name, ID, and date of birth.
 */
public class Person {

   private String _name;
   private String _id;
   Date _dateOfBirth;

   /**
    * Constructs a new Person object with the specified name, ID, and date of birth.
    *
    * @param name        The name of the person. If null, the default name is set to "Someone".
    * @param id          The ID of the person. If the length is not 9, the default ID is set to "000000000".
    * @param dateOfBirth The date of birth of the person.
    */
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

   /**
    * Constructs a new Person object that is a copy of the specified Person object.
    *
    * @param other The Person object to copy.
    */
   public Person(Person other) {
      this._name = other._name;
      this._id = other._id;
      this._dateOfBirth = new Date(other._dateOfBirth);
   }

   /**
    * Gets the name of the person.
    *
    * @return The name of the person.
    */
   public String getName() {
      return _name;
   }

   /**
    * Gets the ID of the person.
    *
    * @return The ID of the person.
    */
   public String getId() {
      return _id;
   }

   /**
    * Gets the date of birth of the person.
    *
    * @return The date of birth of the person.
    */
   public Date getDateOfBirth() {
      return new Date(_dateOfBirth);
   }

   /**
    * Sets the name of the person.
    *
    * @param name The new name of the person. If null, the default name is set to "someone".
    */
   public void setName(String name) {
      if (name == null) {
         _name = "someone";
      } else {
         _name = name;
      }
   }

   /**
    * Sets the ID of the person.
    *
    * @param id The new ID of the person. If the length is not 9, the ID is not updated.
    */
   public void setId(String id) {
      if (id.length() == 9) {
         _id = id;
      }
   }

   /**
    * Sets the date of birth of the person.
    *
    * @param d The new date of birth.
    */
   public void setDateOfBirth(Date d) {
      _dateOfBirth = new Date(d);
   }

   /**
    * Returns a string representation of the person.
    *
    * @return The string representation of the person.
    */
   public String toString() {
      return "Name: " + _name + "\n" +
              "ID: " + _id + "\n" +
              "Date of birth: " + _dateOfBirth.toString();
   }

   /**
    * Checks if the current person is equal to another person.
    *
    * @param other The person to compare.
    * @return True if the persons are equal, false otherwise.
    */
   public boolean equals(Person other) {
      return this._name.equals(other._name) &&
              this._id.equals(other._id) &&
              this._dateOfBirth.equals(other._dateOfBirth);
   }

   /**
    * Compares the current person's date of birth with another person's date of birth.
    *
    * @param other The person to compare.
    * @return -1 if the current person's date of birth is after the other person's,
    *         1 if it's before, and 0 if they are equal.
    */
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

