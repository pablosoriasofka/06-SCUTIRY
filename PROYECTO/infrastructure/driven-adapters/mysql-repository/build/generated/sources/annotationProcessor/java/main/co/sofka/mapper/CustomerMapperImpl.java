package co.sofka.mapper;

import co.sofka.Account;
import co.sofka.Customer;
import co.sofka.data.entity.AccountEntity;
import co.sofka.data.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T18:06:48-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.12 (Ubuntu)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerEntity model) {
        if ( model == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( model.getId() != null ) {
            customer.setId( String.valueOf( model.getId() ) );
        }
        customer.setUsername( model.getUsername() );
        customer.setAccounts( accountEntityListToAccountList( model.getAccounts() ) );
        customer.setPwd( model.getPwd() );

        return customer;
    }

    @Override
    public List<Customer> toCustomers(List<CustomerEntity> cardModels) {
        if ( cardModels == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( cardModels.size() );
        for ( CustomerEntity customerEntity : cardModels ) {
            list.add( toCustomer( customerEntity ) );
        }

        return list;
    }

    @Override
    public CustomerEntity toCustomerModel(Customer card) {
        if ( card == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        if ( card.getId() != null ) {
            customerEntity.setId( Long.parseLong( card.getId() ) );
        }
        customerEntity.setUsername( card.getUsername() );
        customerEntity.setAccounts( accountListToAccountEntityList( card.getAccounts() ) );
        customerEntity.setPwd( card.getPwd() );

        return customerEntity;
    }

    protected Account accountEntityToAccount(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        Account account = new Account();

        account.setCreatedAt( accountEntity.getCreatedAt() );
        account.setCustomer( toCustomer( accountEntity.getCustomer() ) );
        if ( accountEntity.getId() != null ) {
            account.setId( String.valueOf( accountEntity.getId() ) );
        }
        if ( accountEntity.getNumber() != null ) {
            account.setNumber( String.valueOf( accountEntity.getNumber() ) );
        }
        account.setAmount( accountEntity.getAmount() );

        return account;
    }

    protected List<Account> accountEntityListToAccountList(List<AccountEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Account> list1 = new ArrayList<Account>( list.size() );
        for ( AccountEntity accountEntity : list ) {
            list1.add( accountEntityToAccount( accountEntity ) );
        }

        return list1;
    }

    protected AccountEntity accountToAccountEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        if ( account.getId() != null ) {
            accountEntity.setId( Long.parseLong( account.getId() ) );
        }
        if ( account.getNumber() != null ) {
            accountEntity.setNumber( Integer.parseInt( account.getNumber() ) );
        }
        accountEntity.setAmount( account.getAmount() );
        accountEntity.setCustomer( toCustomerModel( account.getCustomer() ) );
        accountEntity.setCreatedAt( account.getCreatedAt() );

        return accountEntity;
    }

    protected List<AccountEntity> accountListToAccountEntityList(List<Account> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountEntity> list1 = new ArrayList<AccountEntity>( list.size() );
        for ( Account account : list ) {
            list1.add( accountToAccountEntity( account ) );
        }

        return list1;
    }
}
