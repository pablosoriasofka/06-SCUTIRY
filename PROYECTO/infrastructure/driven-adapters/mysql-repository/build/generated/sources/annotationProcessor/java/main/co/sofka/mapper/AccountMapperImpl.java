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
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toAccount(AccountEntity model) {
        if ( model == null ) {
            return null;
        }

        Account account = new Account();

        if ( model.getId() != null ) {
            account.setId( String.valueOf( model.getId() ) );
        }
        if ( model.getNumber() != null ) {
            account.setNumber( String.valueOf( model.getNumber() ) );
        }
        account.setAmount( model.getAmount() );
        account.setCreatedAt( model.getCreatedAt() );
        account.setCustomer( customerEntityToCustomer( model.getCustomer() ) );

        return account;
    }

    @Override
    public List<Account> toAccounts(List<AccountEntity> cardModels) {
        if ( cardModels == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( cardModels.size() );
        for ( AccountEntity accountEntity : cardModels ) {
            list.add( toAccount( accountEntity ) );
        }

        return list;
    }

    @Override
    public AccountEntity toAccountModel(Account card) {
        if ( card == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        if ( card.getId() != null ) {
            accountEntity.setId( Long.parseLong( card.getId() ) );
        }
        if ( card.getNumber() != null ) {
            accountEntity.setNumber( Integer.parseInt( card.getNumber() ) );
        }
        accountEntity.setAmount( card.getAmount() );
        accountEntity.setCustomer( customerToCustomerEntity( card.getCustomer() ) );
        accountEntity.setCreatedAt( card.getCreatedAt() );

        return accountEntity;
    }

    protected Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( customerEntity.getId() != null ) {
            customer.setId( String.valueOf( customerEntity.getId() ) );
        }
        customer.setUsername( customerEntity.getUsername() );
        customer.setAccounts( toAccounts( customerEntity.getAccounts() ) );
        customer.setPwd( customerEntity.getPwd() );

        return customer;
    }

    protected List<AccountEntity> accountListToAccountEntityList(List<Account> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountEntity> list1 = new ArrayList<AccountEntity>( list.size() );
        for ( Account account : list ) {
            list1.add( toAccountModel( account ) );
        }

        return list1;
    }

    protected CustomerEntity customerToCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        if ( customer.getId() != null ) {
            customerEntity.setId( Long.parseLong( customer.getId() ) );
        }
        customerEntity.setUsername( customer.getUsername() );
        customerEntity.setPwd( customer.getPwd() );
        customerEntity.setAccounts( accountListToAccountEntityList( customer.getAccounts() ) );

        return customerEntity;
    }
}
