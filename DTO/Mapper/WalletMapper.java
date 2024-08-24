package com.myTask.JavaCode.DTO.Mapper;

import com.myTask.JavaCode.DTO.WalletDTO;
import com.myTask.JavaCode.Model.Wallet;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface WalletMapper {
    WalletDTO toDTO(Wallet wallet);

    WalletDTO toEntity(Wallet wallet);

}
