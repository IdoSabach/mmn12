/**
 * Date
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

  public Date(Date other) {
    this._day = other._day;
    this._month = other._month;
    this._year = other._year;
  }

  public int getDay() {
    return _day;
  }

  public int getMonth() {
    return _month;
  }

  public int getYear() {
    return _year;
  }

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

  public void setMonth(int month) {
    if (month > 0 && month < 13) {
      _month = month;
    }
  }

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

  // checks if the year is a leap year
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

  public boolean equals(Date other) {
    if (other == null) {
      return false;
    }
    return this._year == other._year &&
        this._month == other._month &&
        this._day == other._day;
  }

  public boolean before(Date other) {
    if (this._year < other._year) {
      return true;
    } else if (this._month < other._month) {
      return true;
    } else if (this._day < other._day) {
      return true;
    } else {
      return false;
    }
  }

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

  public int difference(Date other) {
    int num1 = calculateDate(this._day, this._month, this._year);
    int num2 = calculateDate(other._day, other._month, other._year);
    int num = Math.abs(num1 - num2);
    return num;
  }

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

  public Date addYearsToDate(int num) {
    Date newDate = new Date(this._day, this._month, this._year);
    newDate._year += num;
    if (this._month == FEBRUARY && this._day == 29 && !isLeapYear(newDate._year)) {
      newDate._day = 28;
    }
    return newDate;
  }

}

