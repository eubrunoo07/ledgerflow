package eubrunoo07.projects.account_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewAccount {

    @NotBlank(message = "Owner name is required.")
    private String ownerName;

}
