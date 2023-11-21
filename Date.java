/**
 * Date
 */
public class Date {

  private int _day;
  private int _mount;
  private int _year;

  public Date(int day, int mount, int year) {
    if (year > 999 && year < 10000) {
      _year = year;
      if (mount > 0 && mount < 13) {
        _mount = mount;
        switch (mount) {
          case 1, 3, 5, 7, 8, 10, 12 -> {
            if (day > 0 && day < 32) {
              _day = day;
              System.out.println("month with 31 day");
            } else {
              _day = 1;
              _mount = 1;
              _year = 2000;
            }
          }
          case 4, 6, 9, 11 -> {
            if (day > 0 && day < 31) {
              _day = day;
              System.out.println("month with 30 day");
            } else {
              _day = 1;
              _mount = 1;
              _year = 2000;
            }
          }
          case 2 -> {
            if (isLeapYear(year)) {
              if (day > 0 && day < 30) {
                _day = day;
                System.out.println("leap year");
              } else {
                _day = 1;
                _mount = 1;
                _year = 2000;
              }
            } else {
              if (day > 0 && day < 29) {
                _day = day;
                System.out.println(" not leap year");
              } else {
                _day = 1;
                _mount = 1;
                _year = 2000;
              }
            }
          }

        }
      } else {
        _day = 1;
        _mount = 1;
        _year = 2000;
      }
    } else {
      _day = 1;
      _mount = 1;
      _year = 2000;
    }

    System.out.println(_day + "." + _mount + "." + _year);

  }

  // checks if the year is a leap year
  private boolean isLeapYear(int y) {
    return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? true : false;
  }

}
