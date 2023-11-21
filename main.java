public class main {
  public static void main(String[] args) {
    Date d1 = new Date(1, 1, 2000);
    Date d2 = new Date(1, 1, 2001);
    boolean x = d1.equals(d2);
    System.out.println(x);
    boolean y1 = d1.before(d2);
    boolean y2 = d1.after(d2);
    System.out.println(y1);
    System.out.println(y2);
    int num = d1.difference(d2);
    System.out.println(num);
    System.out.println(d1.toString());
    System.out.println(d1);
  }
}
