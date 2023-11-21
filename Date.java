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
        } else {
          defaultValues();
        }
        break;
      }
      case 2: {
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
    System.out.println(num1);
    int num2 = calculateDate(other._day, other._month, other._year);
    System.out.println(num2);
    int num = Math.abs(num1-num2);
    return num;
  }

  public String toString(){
    String str;
    if(this._day < 10 && this._month<10){
      str = "0"+this._day +"/"+"0"+this._month+"/"+this._year;
    }else if(this._day < 10){
      str = "0"+this._day +"/"+this._month+"/"+this._year;
    }else if(this._month<10){
      str = this._day +"/"+"0"+this._month+"/"+this._year;
    }else{
      str = this._day +"/"+this._month+"/"+this._year;
    }
    return str;
  }

}
