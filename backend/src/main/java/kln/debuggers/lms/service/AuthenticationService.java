package kln.debuggers.lms.service;

import lombok.RequiredArgsConstructor;
import kln.debuggers.lms.dto.JwtAuthenticationResponse;
import kln.debuggers.lms.dto.SignInRequest;
import kln.debuggers.lms.dto.SignUpRequest;
import kln.debuggers.lms.entity.Employee;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public interface AuthenticationService {

        private final EmployeeService employeeService;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public JwtAuthenticationResponse signUp(SignUpRequest request) {

            var employee = Employee.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Employee.Role.ROLE_USER)
                    .build();

            employeeService.create(employee);

            var jwt = jwtService.generateToken(employee);
            return new JwtAuthenticationResponse(jwt);
        }

        public JwtAuthenticationResponse signIn(SignInRequest request) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            ));

            var employee = employeeService
                    .employeeDetailsService()
                    .loadUserByUsername(request.getUsername());

            var jwt = jwtService.generateToken(employee);
            return new JwtAuthenticationResponse(jwt);
        }


}
