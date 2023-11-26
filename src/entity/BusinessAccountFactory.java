package entity;

public class BusinessAccountFactory implements BusinessAccountFactoryInterface{
    @Override
    public BusinessAccount create(String username, String name, String password, String address, String categories) {

        return new BusinessAccount(username, name, password, address, categories);
    }
}