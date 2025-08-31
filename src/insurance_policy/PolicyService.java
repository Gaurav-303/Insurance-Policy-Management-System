package insurance_policy;

import java.time.LocalDate;
import java.util.*;

public class PolicyService {

    private Map<String, Policy> hashMapPolicies = new HashMap<>();
    private Map<String, Policy> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, Policy> treeMapPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMapPolicies.put(policy.getPolicyNumber(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);
        treeMapPolicies.put(policy.getExpiryDate(), policy);
    }
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber);
    }
    public List<Policy> getPoliciesExpiringWithin30Days() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy policy : hashMapPolicies.values()) {
            if (!policy.getExpiryDate().isBefore(today) &&
                    !policy.getExpiryDate().isAfter(limit)) {
                result.add(policy);
            }
        }
        return result;
    }
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyHolder().equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        hashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        linkedHashMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        treeMapPolicies.values().removeIf(p -> p.getExpiryDate().isBefore(today));
    }
    public Collection<Policy> getAllPolicies() {
        return hashMapPolicies.values();
    }

}