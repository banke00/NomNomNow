package interface_adapter.add_business;

import entity.Category;

public class AddBusinessAccountState {
    private String username = "";
    private String usernameError = null;
    private String name = "";
    private String nameError = null;
    private String password = "";
    private String passwordError = null;
    private String address = "";
    private String addressError = null;
    private Category categories = new Category(null, ""); // ?? not sure if this is right
    private Category categoriesError = null;


    public AddBusinessAccountState(AddBusinessAccountState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        name = copy.name;
        nameError = copy.nameError;
        password = copy.password;
        passwordError = copy.passwordError;
        address = copy.address;
        addressError = copy.addressError;
        categories = copy.categories;
        categoriesError = copy.categoriesError;
    }

    public AddBusinessAccountState() {
    }

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressError() {
        return addressError;
    }

    public Category getCategories() {
        return categories;
    }

    public Category getCategoriesError() {
        return categoriesError;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public void setCategoriesError(Category categoriesError) {
        this.categoriesError = categoriesError;
    }



    @Override
    public String toString() {
        return "AddBusinessAccountState{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}