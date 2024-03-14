package za.co.bbd.beanquizrestapi.service;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import za.co.bbd.beanquizrestapi.converter.UserConverter;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.entity.UserEntity;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.UserRepository;
import za.co.bbd.beanquizrestapi.web.RequestInterceptor;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Value("${okta.oauth2.issuer}")
    private String auth0Url;

    private JSONObject getUserDetailsFromToken() {
        String token = RequestInterceptor.token
                .orElseThrow(
                        () -> new BusinessException("Missing Access Token", HttpStatus.UNAUTHORIZED)
                );

        try {
            HttpResponse<JsonNode> jsonResponse = Unirest
                    .get(auth0Url + "userinfo")
                    .header("Authorization", token)
                    .asJson();

            if (jsonResponse.isSuccess()) {
                return jsonResponse.getBody().getObject();
            }

            throw new BusinessException(jsonResponse.getStatusText(), HttpStatus.valueOf(jsonResponse.getStatus()));

        } catch (Exception e) {
            throw new BusinessException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public UserDTO getUser() {
        JSONObject userDetails = getUserDetailsFromToken();
        return userConverter.convertEntityToDTO(userRepository.findUserEntityByEmail(userDetails.getString("email")));
    }

    public void createUser() {
        JSONObject userDetails = getUserDetailsFromToken();

        String email = userDetails.getString("email");
        String username = userDetails.getString("nickname");

        UserEntity userEntity = userRepository.findUserEntityByEmail(email);

        if (Objects.equals(null, userEntity)) {
            userEntity = new UserEntity();
            userEntity.setEmail(email);
            userEntity.setUsername(username);
            userRepository.save(userEntity);
        }
    }

    public void updateUsername(Integer userID, String username) {
        UserEntity userEntity = userRepository.findById(userID).orElseThrow(() -> new BusinessException("Unable to find user.", HttpStatus.NOT_FOUND));
        userEntity.setUsername(username);
        userRepository.save(userEntity);
    }
}
