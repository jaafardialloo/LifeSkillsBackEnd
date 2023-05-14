package Training.LifeSkills.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

  private Long id;
  private String tel;
  private String nni;
  private String username;
  private String email;
  private String name;
  private String password;
  private String resetToken;
  private String verificationCode;
  private Boolean isDeleted;
  private Boolean isActive;
  private Boolean isVerified;
  private Boolean isTmpPassword;
  private String roleEnum;
}
