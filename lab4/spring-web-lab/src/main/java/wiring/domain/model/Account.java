package wiring.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.requireNonNull;

public class Account {

    private final String number;

    private Account(String number) {
        this.number = requireNonNull(number);
    }

    public static Account of(String number) {
        return new Account(number);
    }

    @JsonProperty
    public String number() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return number.equals(other.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

}
