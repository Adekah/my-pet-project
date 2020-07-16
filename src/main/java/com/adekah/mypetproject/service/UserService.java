package com.adekah.mypetproject.service;


import com.adekah.mypetproject.dto.UserDto;
import com.adekah.mypetproject.util.TPage;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}

