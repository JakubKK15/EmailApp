public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");

        em1.setAltEmail("js@gmail.com");
        System.out.println(em1.getAltEmail());
        System.out.println(em1);
    }
}

