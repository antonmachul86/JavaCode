package com.myTask.JavaCode.DTO.Mapper;


import com.myTask.JavaCode.DTO.WalletDTO;
import com.myTask.JavaCode.DTO.WalletOperationDTO;
import com.myTask.JavaCode.Model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface WalletOperationMapper {
    WalletOperationDTO toDto(Wallet wallet);

    @Mappings({
            @Mapping(target = "balance", ignore = true)
    })
    Wallet toEntity(WalletOperationDTO dto);
}
