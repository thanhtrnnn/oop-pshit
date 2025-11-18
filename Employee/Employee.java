package Employee;

public abstract class Employee implements IEmployee {
    private String name;
    private int paymentPerHour;
    public Employee(String name, int paymentPerHour) {
        setName(name);
        setPaymentPerHour(paymentPerHour);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPaymentPerHour() {
        return paymentPerHour;
    }
    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }
    public abstract int calculateSalary();
}
