package com.arielSoares.WebSystem.resources.DTO;

import com.arielSoares.WebSystem.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
