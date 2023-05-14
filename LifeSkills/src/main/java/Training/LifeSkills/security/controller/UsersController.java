package Training.LifeSkills.security.controller;


import Training.LifeSkills.security.dto.UserDTO;
import Training.LifeSkills.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsersController {

  private final UserService userService;

  @PostMapping
  public UserDTO save(@RequestBody  UserDTO userDTO) {
    return userService.save(userDTO);
  }

  @GetMapping
  public List<UserDTO> findAll() {
    return userService.findAll();
  }

  @PostMapping("/activate")
  public void activateUsers(@RequestBody Set<Long> ids) {
    userService.activateUsers(ids);
  }

  @PostMapping("/deactivate")
  public void deactivateUsers(@RequestBody Set<Long> ids) {
    userService.deactivateUsers(ids);
  }

  @PostMapping("/add-roles/{userId}")
  public void addRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
    userService.addRoles(userId, roleIds);
  }

  @PostMapping("/remove-roles/{userId}")
  public void removeRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
    userService.removeRoles(userId, roleIds);
  }

  @PostMapping("/update-password")
  public void updatePassword() {
    //TODO
  }

  @GetMapping("/{username}")
  public UserDTO findByUsername(@PathVariable  String username) {
    return userService.findByUsername(username);
  }

  @GetMapping("/connected-user")
  public UserDTO getConnectedUser() {
    return userService.getConnectedUser();
  }

  @PostMapping("/find-users-by-role")
  public List<UserDTO> findUsersByRole(@RequestParam("userRole") String userRole) {
    return userService.findAllByUserRole(userRole);
  }

  @PostMapping("/delete-user")
  public boolean deleteUserById(@RequestParam("userId") Long userId) {
   return userService.deleteUserById(userId);
  }

}
