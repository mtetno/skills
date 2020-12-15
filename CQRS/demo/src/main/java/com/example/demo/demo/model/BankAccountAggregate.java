package com.example.demo.demo.model;


import com.example.demo.demo.command.CreateAccountCommand;
import com.example.demo.demo.command.CreditMoneyCommand;
import com.example.demo.demo.command.DebitMoneyCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class BankAccountAggregate {

    @AggregateIdentifier
    private UUID id;
    private BigDecimal balance;
    private String owner;

    @CommandHandler
    public BankAccountAggregate(CreateAccountCommand command) {

        AggregateLifecycle.apply(new AccountCreatedEvent(command.getId(),command.getInitialBalance(),command.getOwner()));

    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.id = event.getId();
        this.owner = event.getOwner();
        this.balance = event.getInitialBalance();


    }

    @CommandHandler
    public void handle(CreditMoneyCommand command){
        AggregateLifecycle.apply(new MoneyCreditEvent(command.getAccountId(),command.getCreditAmount()));
    }

    @EventSourcingHandler
    public void on(MoneyCreditEvent event){
        this.balance = this.balance.add(event.getAmount());
    }

    @CommandHandler
    public void handle(DebitMoneyCommand command){
        AggregateLifecycle.apply(new MoneyDebitEvent(command.getAccountId(),command.getDebitAmount()));
    }

    @EventSourcingHandler
    public void on(MoneyDebitEvent event) {
        this.balance = this.balance.subtract(event.getAmount());
    }
}
