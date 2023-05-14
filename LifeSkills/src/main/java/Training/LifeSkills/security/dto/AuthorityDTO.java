package Training.LifeSkills.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDTO {

  private Long id;
  private String name;
//  @EqualsAndHashCode.Exclude
//  @ToString.Exclude
//  @JsonIgnore
//  private Set<RoleDTO> roles;
}
