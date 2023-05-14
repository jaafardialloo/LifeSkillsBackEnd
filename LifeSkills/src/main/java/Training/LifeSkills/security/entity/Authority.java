package Training.LifeSkills.security.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_authority")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;
  @ManyToMany(mappedBy = "authorities", cascade = CascadeType.DETACH)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Set<Role> roles;
}
