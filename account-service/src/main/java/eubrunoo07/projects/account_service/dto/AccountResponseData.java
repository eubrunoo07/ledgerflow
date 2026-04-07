package eubrunoo07.projects.account_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseData {

    private UUID id;
    private String ownerName;
    private String balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
