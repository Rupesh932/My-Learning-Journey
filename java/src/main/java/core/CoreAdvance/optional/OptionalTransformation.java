package core.CoreAdvance.optional;

import java.util.Optional;

public class OptionalTransformation {
    public static void main(String[] args) {
        User user = getUser();
        nullCheckHell(user);

        //optional transformation : map
        Optional<User> user1 = getOptionalUser();
        user1.map(User::getAddress)
                .map(Address::getCityName)
                .ifPresentOrElse(
                        (city -> System.out.println("City: " + city)),
                        () -> System.out.println("City Not found")
                );
        // flatMap
        Optional<Optional<Address>> address = ge


    }

    private static void nullCheckHell(User user) {
        if (user != null)
            if (user.getAddress() != null)
                if (user.getAddress().getCityName() != null)
                    System.out.println("City : " + user.getAddress().getCityName());
                else
                    System.out.println("City not found");

            else
                System.out.println("Address not found");

        else
            System.out.println("User not found");


    }

    private static User getUser() {
        Address a = new Address(null);
        return new User(a);
    }

    private static Optional<User> getOptionalUser() {
        Address a = new Address(null);
        User u = new User(a);
        return Optional.of(u);
    }
}

class User {
    private Address address;

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {
    private String cityName;

    public Address(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
class OptionalUser{
    private Optional<Address> address;

    public OptionalUser(Optional<Address> address) {
        this.address = address;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Optional<Address> address) {
        this.address = address;
    }
}

