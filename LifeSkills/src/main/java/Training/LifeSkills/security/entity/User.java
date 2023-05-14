package Training.LifeSkills.security.entity;

import Training.LifeSkills.security.enumeration.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nni;
  private String tel;
  private String name;
  private String email;
  private String username;
  private String password;
  private String resetToken;
  private Boolean isDeleted;
  private Boolean isActive;
  private Boolean isVerified;
  private Boolean isTmpPassword;
  private String verificationCode;
  private LocalDate birthDate;
  @Column(name = "user_role")
  @Enumerated(EnumType.STRING)
  private RoleEnum roleEnum;
  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST,
      CascadeType.REFRESH})
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"))
  @Builder.Default
  private Set<Role> roles = new HashSet<>();


  public Set<String> listRoles() {
    return this.roles.stream().map(role -> "ROLE_" + role.getName()).collect(Collectors.toSet());
  }

  public Set<String> listAuthorities() {
    Set<String> authorities = new HashSet<>();
    for(Role role: this.roles) {
      authorities.addAll(role.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
    }
    return authorities;
  }

  public Set<String> listGrantedAuthorities() {
    Set<String> roles = listRoles();
    Set<String> authorities = listAuthorities();
    Set<String> grantedAuthorities = new HashSet<>();
    grantedAuthorities.addAll(roles);
    grantedAuthorities.addAll(authorities);
    return grantedAuthorities;
  }
}
