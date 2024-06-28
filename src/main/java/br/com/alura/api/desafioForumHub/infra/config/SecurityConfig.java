//package br.com.alura.api.desafioForumHub.infra.config;
//
//
//public class SecurityConfig {
//
//    @Value("${jwt.public.key}")
//    private RSAPublicKey publicKey;
//    @Value("${jwt.private.key}")
//    private RSAPrivateKey privateKey;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        //liberar rota pública
//                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
//                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
//                        .anyRequest().authenticated())
//                .csrf(csrf -> csrf.disable())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withPublicKey(publicKey).build();
//    }
//
//    @Bean
//    public JwtEncoder jwtEncoder() {
//        JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(privateKey).build();
//        var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//        return new NimbusJwtEncoder(jwks);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}