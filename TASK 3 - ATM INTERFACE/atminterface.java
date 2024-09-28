    import java.util.InputMismatchException;
    import java.util.Scanner;

    // Class to represent the user's bank account
    class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Initial balance cannot be negative.");
            }
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited $" + amount);
            } else {
                System.out.println("Invalid deposit amount. Must be greater than zero.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
            } else if (amount <= 0) {
                System.out.println("Invalid withdrawal amount. Must be greater than zero.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }

    // Class to represent the ATM machine
    class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void start() {
            boolean running = true;
            while (running) {
                displayMenu();
                System.out.print("Choose an option: ");
                int choice = getValidIntInput();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private int getValidIntInput() {
            while (true) {
                try {
                    return scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }

        private double getValidDoubleInput() {
            while (true) {
                try {
                    return scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }

        private void checkBalance() {
            System.out.println("Your current balance is: $" + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter the amount to deposit: ");
            double amount = getValidDoubleInput();
            account.deposit(amount);
        }

        private void withdraw() {
            System.out.print("Enter the amount to withdraw: ");
            double amount = getValidDoubleInput();
            account.withdraw(amount);
        }
    }

    // Main class to run the ATM program
    public class ATMInterface {
        public static void main(String[] args) {
            try {
                BankAccount account = new BankAccount(1000.0); // Initial balance of $1000
                ATM atm = new ATM(account);
                atm.start();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
