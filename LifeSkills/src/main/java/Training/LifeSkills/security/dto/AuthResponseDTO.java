package Training.LifeSkills.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public  class AuthResponseDTO {
    private String accessToken;
    private String refreshToken;
    private UserDTO user;
}