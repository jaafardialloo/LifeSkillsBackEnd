package Training.LifeSkills.security.controller;

import Training.LifeSkills.security.dto.RoleDTO;
import Training.LifeSkills.security.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public RoleDTO save(RoleDTO roleDTO) {
        return roleService.save(roleDTO);
    }

    @GetMapping
    public List<RoleDTO> findAll() {
        return roleService.findAll();
    }

}
