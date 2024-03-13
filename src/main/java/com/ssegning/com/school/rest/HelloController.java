package com.ssegning.com.school.rest;

import com.ssegning.com.school.model.BaseUserDetail;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// TODO
@ResponseBody
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Secured("ROLE_TEACHER")
    @GetMapping("secured")
    public String saySecure(@AuthenticationPrincipal BaseUserDetail principal) {
        return "say-secure: %s %s".formatted(principal.getName(), principal.getId());
    }

    @PreAuthorize("hasAnyRole('TEACHER', 'GATE_KEEPER')")
    @GetMapping("first")
    public String sayHello(@AuthenticationPrincipal BaseUserDetail principal) {
        return "say-hello: %s %s".formatted(principal.getName(), principal.getId());
    }

    @PreAuthorize("hasAnyRole('CLEANING')")
    @GetMapping("keep-the-gate")
    public String sayClosed(@AuthenticationPrincipal BaseUserDetail principal) {
        return "say-closed: %s %s".formatted(principal.getName(), principal.getId());
    }

}
