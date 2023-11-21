public class main {
  public static void main(String[] args) {
    Date d1 = new Date(28, 2, 2021);
    Date d2 = new Date(28, 2, 2051);
    boolean x = d1.equals(d2);
    System.out.println(x);
    // System.out.println(d1);
  }
}
