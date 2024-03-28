package tec.escola.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tec.escola.api.domain.usuario.DadosAutentication;
import tec.escola.api.domain.usuario.Usuario;
import tec.escola.api.infra.security.DadosTokenJwt;
import tec.escola.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AltenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutentication dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJwt = tokenService.GerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
    }
}
