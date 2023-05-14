package Training.LifeSkills.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "app_role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @ManyToMany(mappedBy = "roles", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnore
  private Set<User> users;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "roles_authorities",
      joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "authority_id", referencedColumnName = "id"))
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  @JsonIgnoreProperties("roles")
  private Set<Authority> authorities;
}
