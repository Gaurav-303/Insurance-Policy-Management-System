package insurance_policy;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyService system = new PolicyService();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5)));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(25)));

        System.out.println("Retrieve P001: " + system.getPolicyByNumber("P001"));
        System.out.println("Policies expiring within 30 days: " + system.getPoliciesExpiringWithin30Days());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));

        system.removeExpiredPolicies();
        System.out.println("After removing expired policies: " + system.getAllPolicies());
    }
}

