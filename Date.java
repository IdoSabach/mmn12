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
    System.out.println(_day + "." + _month + "." + _year);
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
    if (_month == 1 || _month == 3 || _month == 5 || _month == 7
        || _month == 8 || _month == 10 || _month == 12) {
      if (day > 0 && day < 32) {
        _day = day;
      }
    } else if (_month == 4 || _month == 6 || _month == 9 || _month == 11) {
      if (day > 0 && day < 31) {
        _day = day;
      }
    } else if (_month == 2) {
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
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12: {
        if (day > 0 && day < 32) {
          _day = day;
          System.out.println("month with 31 day");
        } else {
          defaultValues();
        }
        break;
      }
      case 4:
      case 6:
      case 9:
      case 11: {
        if (day > 0 && day < 31) {
          _day = day;
          System.out.println("month with 30 day");
        } else {
          defaultValues();
        }
        break;
      }
      case 2: {
        if (isLeapYear(year)) {
          if (day > 0 && day < 30) {
            _day = day;
            System.out.println("leap year");
          } else {
            defaultValues();
          }
        } else {
          if (day > 0 && day < 29) {
            _day = day;
            System.out.println(" not leap year");
          } else {
            defaultValues();
          }
        }
        break;
      }
    }
  }

  public boolean equals (Date other){
    if(other == null){
      return false;
    }
    return this._year == other._year && 
           this._month == other._month &&
           this._day == other._day;
  }

}
