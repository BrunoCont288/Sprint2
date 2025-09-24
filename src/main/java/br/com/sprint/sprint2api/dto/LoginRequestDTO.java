package br.com.sprint.sprint2api.dto;
import lombok.Data;
@Data
public class LoginRequestDTO {
    private String email;
    private String senha;
}