package Entity;
import java.util.*;


public class BankDetails {

    private String name;
    private long accountNumber;
    private String accountType;
    private String dob;
    private String emailId;
    private long phoneNumber;
    private long balance;
    private String address;
   private String password;

    public BankDetails(long accountNumber, String name, String accountType, String dob, String emailId, long phoneNumber, long balance, String address, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        this.dob = dob;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.address = address;
        this.password = password;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankDetails() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", dob='" + dob + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
