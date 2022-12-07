package com.example.cinema.util;

import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;
import com.example.cinema.mapper.userrequestdetailmapper.UserMapper;
import com.example.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckImportedData {

    private final CreatePictureUtil createPictureUtil;

    private final UserService userService;

    private final UserMapper userMapper;

    public Optional<ModelMap> checkData(BindingResult bindingResult, MultipartFile multipartFile, ModelMap modelMap) {
        if (bindingResult.hasErrors() || (createPictureUtil.isPictureNotAllowedType(multipartFile))) {
            if (bindingResult.hasErrors()) {
                checkBinding(bindingResult, modelMap);
            }
            if (createPictureUtil.isPictureNotAllowedType(multipartFile)) {
                modelMap.addAttribute("errorMessageFile", "Please choose only image");
            }
            return Optional.of(modelMap);
        }
        return Optional.empty();
    }

    public Optional<ModelMap> checkUserData(BindingResult bindingResult, UserRequestDTO userRequestDTO,
                                            MultipartFile multipartFile, ModelMap modelMap) {
        if (bindingResult.hasErrors() || checkUniqueEmail(userRequestDTO)
                || createPictureUtil.isPictureNotAllowedType(multipartFile)) {
            if (bindingResult.hasErrors()) {
                checkBinding(bindingResult, modelMap);
            }
            if (checkUniqueEmail(userRequestDTO)) {
                modelMap.addAttribute("errorUniqueMessageEmail", "email already exist");
            }
            if (createPictureUtil.isPictureNotAllowedType(multipartFile)) {
                modelMap.addAttribute("errorMessageFile", "Please choose only image");
            }
            return Optional.of(modelMap);
        }
        return Optional.empty();
    }

    private ModelMap checkBinding(BindingResult bindingResult, ModelMap modelMap) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            String[] name = error.getDefaultMessage().split(" ");
            modelMap.addAttribute("errorMessage" + name[1], error.getDefaultMessage());
        }
        return modelMap;
    }

    private boolean checkUniqueEmail(UserRequestDTO userRequestDTO) {
        return userService.checkUniqueEmail(userMapper.map(userRequestDTO));
    }

}