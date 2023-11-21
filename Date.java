/**
 * Date
 */
public class Date {

  private int _day;
  private int _mount;
  private int _year;

  private final int DEFAULT_DAY = 1;
  private final int DEFAULT_MOUNT = 1;
  private final int DEFAULT_YEAR = 2000;

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
              defaultValues();
            }
          }
          case 4, 6, 9, 11 -> {
            if (day > 0 && day < 31) {
              _day = day;
              System.out.println("month with 30 day");
            } else {
              defaultValues();
            }
          }
          case 2 -> {
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
          }

        }
      } else {
        defaultValues();
      }
    } else {
      defaultValues();
    }

    System.out.println(_day + "." + _mount + "." + _year);

  }

  private void defaultValues() {
    _day = DEFAULT_DAY;
    _mount = DEFAULT_MOUNT;
    _year = DEFAULT_YEAR;
  }

  // checks if the year is a leap year
  private boolean isLeapYear(int y) {
    return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0) ? true : false;
  }

}
