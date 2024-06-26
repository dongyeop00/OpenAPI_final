package com.dongyeop.dbp_api.Service.User;

import com.dongyeop.dbp_api.DTO.User.UserDTO;
import com.dongyeop.dbp_api.DTO.User.UserLoginDTO;
import com.dongyeop.dbp_api.Entity.User.UserCheckboxValueEntity;
import com.dongyeop.dbp_api.Entity.User.UserEntity;
import com.dongyeop.dbp_api.Repository.User.UserCheckboxValueRepository;
import com.dongyeop.dbp_api.Repository.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCheckboxValueRepository userCheckboxValueRepository;

    @Transactional
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserNickname(userDTO.getUserNickname());
        userEntity.setUserEmail(userDTO.getUserEmail());
        userEntity.setUserPassword(userDTO.getUserPassword());
        userEntity.setUserGender(userDTO.getUserGender());

        List<UserCheckboxValueEntity> userCheckboxValueEntities = userDTO.getSelectedValues().stream().map(value ->{
            UserCheckboxValueEntity userCheckboxValueEntity = new UserCheckboxValueEntity();
            userCheckboxValueEntity.setValue(value);
            userCheckboxValueEntity.setUser(userEntity);
            return userCheckboxValueEntity;
        }).collect(Collectors.toList());

        userEntity.setUserCheckboxValueEntityList(userCheckboxValueEntities);
        userRepository.save(userEntity);
    }

    public UserLoginDTO login(UserLoginDTO userDTO) {
        //회원이 입력한 이메일로 db에서 조회
        Optional<UserEntity> byUserEmail = userRepository.findByUserEmail(userDTO.getUserEmail());

        //이메일이 존재할 경우
        if(byUserEmail.isPresent()){
            UserEntity userEntity = byUserEmail.get(); //해당 데이터 가져옴
            if(userEntity.getUserPassword().equals(userDTO.getUserPassword())){ //로그인 비밀번호와 데이터와 일치하면
                UserLoginDTO dto = UserDTO.toUserLoginDTO(userEntity);
                System.out.println("로그인 성공");
                return dto;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public UserDTO findById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            return UserDTO.toUserDTO(optionalUserEntity.get());
        }else{
            return null;
        }
    }

    public List<UserCheckboxValueEntity> findValueById(Long id) {
        List<UserCheckboxValueEntity> userCheckboxValueDTO = userCheckboxValueRepository.findByUserId(id);
        return userCheckboxValueDTO;
    }


}

