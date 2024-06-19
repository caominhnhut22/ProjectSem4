package prjS4.ProjectSem4.securities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prjS4.ProjectSem4.entities.Roles;
import prjS4.ProjectSem4.securities.service.IRoleService;

import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Roles> getRoleById(@PathVariable String id) {
        Optional<Roles> role = roleService.findById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles createdRole = roleService.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Roles> updateRole(@PathVariable String id, @RequestBody Roles roleDetails) {
        Optional<Roles> existingRoleOptional = roleService.findById(id);
        if (existingRoleOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        Roles existingRole = existingRoleOptional.get();
        existingRole.setRoleNum(roleDetails.getRoleNum()); // Cập nhật các thông tin khác cần thiết của role
        
        Roles updatedRole = roleService.save(existingRole);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRole(@PathVariable String id) {
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Roles> findByRoleNum(@RequestParam Integer roleNum) {
        Roles role = roleService.findByRoleNum(roleNum);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}