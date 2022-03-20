package fr.vocaltech.spring.reactiveweb.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.vocaltech.spring.reactiveweb.security.CustomUserPrincipal;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
    @GetMapping(
            path = "/username",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String userDetails(Authentication authentication) throws JsonProcessingException {
        System.out.println("---> [SecurityController] auth name: " + authentication.getName());

        CustomUserPrincipal customUserPrincipal = (CustomUserPrincipal) authentication.getPrincipal();

        System.out.println("---> [SecurityController] principal username: " + customUserPrincipal.getUsername());
        System.out.println("---> [SecurityController] principal authorities: " + customUserPrincipal.getAuthorities());

        String res = new ObjectMapper().writeValueAsString(customUserPrincipal);
        System.out.println("json: " + res);

        return res;
    }
}
