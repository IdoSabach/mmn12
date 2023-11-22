/**
 * The Date class represents a date in the Gregorian calendar.
 */
public class Date {

  private int _day;
  private int _month;
  private int _year;

  private final int DEFAULT_DAY = 1;
  private final int DEFAULT_month = 1;
  private final int DEFAULT_YEAR = 2000;

  private final int JANUARY = 1;
  private final int FEBRUARY = 2;
  private final int MARCH = 3;
  private final int APRIL = 4;
  private final int MAY = 5;
  private final int JUNE = 6;
  private final int JULY = 7;
  private final int AUGUST = 8;
  private final int SEPTEMBER = 9;
  private final int OCTOBER = 10;
  private final int NOVEMBER = 11;
  private final int DECEMBER = 12;

  /**
   * Constructs a new Date object with the specified day, month, and year.
   *
   * @param day   The day of the month (1-31).
   * @param month The month (1-12).
   * @param year  The year (1000-9999).
   */
  public Date(int day, int month, int year) {
    if (year > 999 && year < 10000) {
      _year = year;
      if (month > 0 && month < 13) {
        _month = month;
        switchCaseFunc(day, month, year);
      } else {
        defaultValues();
      }
    } else {
      defaultValues();
    }
  }

  /**
   * Constructs a new Date object that is a copy of the specified Date object.
   *
   * @param other The Date object to copy.
   */
  public Date(Date other) {
    this._day = other._day;
    this._month = other._month;
    this._year = other._year;
  }

  /**
   * Gets the day of the month.
   *
   * @return The day of the month.
   */
  public int getDay() {
    return _day;
  }

   /**
   * Gets the month.
   *
   * @return The month.
   */
  public int getMonth() {
    return _month;
  }

  /**
   * Gets the year.
   *
   * @return The year.
   */
  public int getYear() {
    return _year;
  }

  /**
   * Sets the day of the month.
   *
   * @param day The new day of the month.
   */
  public void setDay(int day) {
    if (_month == JANUARY || _month == MARCH || _month == MAY || _month == JULY || _month == AUGUST || _month == OCTOBER || _month == DECEMBER) {
      if (day > 0 && day < 32) {
        _day = day;
      }
    } else if (_month == APRIL || _month == JUNE || _month == SEPTEMBER || _month == NOVEMBER) {
      if (day > 0 && day < 31) {
        _day = day;
      }
    } else if (_month == FEBRUARY) {
      if (isLeapYear(_year)) {
        if (day > 0 && day < 30) {
          _day = day;
        }
      } else {
        if (day > 0 && day < 29) {
          _day = day;
        }
      }

    }
  }

  /**
   * Sets the month.
   *
   * @param month The new month.
   */
  public void setMonth(int month) {
    if (month > 0 && month < 13) {
      _month = month;
    }
  }

  /**
   * Sets the year.
   *
   * @param year The new year.
   */
  public void setYear(int year) {
    if (year > 999 && year < 10000) {
      _year = year;
    }
  }

  private void defaultValues() {
    _day = DEFAULT_DAY;
    _month = DEFAULT_month;
    _year = DEFAULT_YEAR;
  }

   /**
   * Checks if the current year is a leap year.
   *
   * @param y The year to check.
   * @return True if it's a leap year, false otherwise.
   */
  private boolean isLeapYear(int y) {
    return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? true : false;
  }

  private void switchCaseFunc(int day, int month, int year) {
    switch (month) {
      case JANUARY:
      case MARCH:
      case MAY:
      case JULY:
      case AUGUST: 
      case OCTOBER:
      case DECEMBER: {
        if (day > 0 && day < 32) {
          _day = day;
        } else {
          defaultValues();
        }
        break;
      }
      case APRIL:
      case JUNE:
      case SEPTEMBER:
      case NOVEMBER: {
        if (day > 0 && day < 31) {
          _day = day;
        } else {
          defaultValues();
        }
        break;
      }
      case FEBRUARY: {
        if (isLeapYear(year)) {
          if (day > 0 && day < 30) {
            _day = day;
          } else {
            defaultValues();
          }
        } else {
          if (day > 0 && day < 29) {
            _day = day;
          } else {
            defaultValues();
          }
        }
        break;
      }
    }
  }

  /**
   * Compares the current date with another date for equality.
   *
   * @param other The date to compare.
   * @return True if the dates are equal, false otherwise.
   */
  public boolean equals(Date other) {
    if (other == null) {
      return false;
    }
    return this._year == other._year &&
        this._month == other._month &&
        this._day == other._day;
  }

  /**
 * Checks if the current date is before another date.
 *
 * @param other The date to compare.
 * @return True if the current date is before the specified date, false otherwise.
 */
public boolean before(Date other) {
  if (this._year < other._year) {
    return true;
  } else if (this._year == other._year && this._month < other._month) {
    return true;
  } else if (this._year == other._year && this._month == other._month && this._day < other._day) {
    return true;
  } else {
    return false;
  }
}

  /**
 * Checks if the current date is after another date.
 *
 * @param other The date to compare.
 * @return True if the current date is after the specified date, false otherwise.
 */
  public boolean after(Date other) {
    return !before(other);
  }

  // computes the day number since the beginning of the Christian counting of
  // years
  private int calculateDate(int day, int month, int year) {
    if (month < 3) {
      year--;
      month = month + 12;
    }
    return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
  }

  /**
 * Calculates the difference in days between the current date and another date.
 *
 * @param other The date to calculate the difference with.
 * @return The absolute difference in days.
 */
  public int difference(Date other) {
    int num1 = calculateDate(this._day, this._month, this._year);
    int num2 = calculateDate(other._day, other._month, other._year);
    int num = Math.abs(num1 - num2);
    return num;
  }


  /**
   * Returns a string representation of the date in the format "dd/mm/yyyy".
   *
   * @return The string representation of the date.
   */
  public String toString() {
    String str;
    if (this._day < 10 && this._month < 10) {
      str = "0" + this._day + "/" + "0" + this._month + "/" + this._year;
    } else if (this._day < 10) {
      str = "0" + this._day + "/" + this._month + "/" + this._year;
    } else if (this._month < 10) {
      str = this._day + "/" + "0" + this._month + "/" + this._year;
    } else {
      str = this._day + "/" + this._month + "/" + this._year;
    }
    return str;
  }

  /**
   * Adds the specified number of years to the current date and returns a new Date object.
   *
   * @param num The number of years to add.
   * @return A new Date object representing the updated date.
   */
  public Date addYearsToDate(int num) {
    Date newDate = new Date(this._day, this._month, this._year);
    newDate._year += num;
    if (this._month == FEBRUARY && this._day == 29 && !isLeapYear(newDate._year)) {
      newDate._day = 28;
    }
    return newDate;
  }

}

