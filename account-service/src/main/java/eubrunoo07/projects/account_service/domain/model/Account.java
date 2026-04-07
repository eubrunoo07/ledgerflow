package eubrunoo07.projects.account_service.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ownerName;
    private BigDecimal balance;

    @Version
    private Long version;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.balance = BigDecimal.ZERO;
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public void deposit(BigDecimal amount){
        validateAmount(amount);
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        validateAmount(amount);
        if(this.balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.balance = this.balance.subtract(amount);
    }

    private void validateAmount(BigDecimal amount){
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Invalid amount.");
        }
    }
}
