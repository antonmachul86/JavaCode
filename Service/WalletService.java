package com.myTask.JavaCode.Service;

import com.myTask.JavaCode.DTO.Mapper.WalletMapper;
import com.myTask.JavaCode.DTO.WalletDTO;
import com.myTask.JavaCode.DTO.WalletOperationDTO;
import com.myTask.JavaCode.Model.Wallet;
import com.myTask.JavaCode.Repository.WalletRepository;
import com.myTask.JavaCode.State.OperationType;
import com.myTask.JavaCode.execeptions.InsufficientFundsException;
import com.myTask.JavaCode.execeptions.WalletNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletService {
    final WalletRepository walletRepository;
    final WalletMapper walletMapper;

    public WalletDTO getWalletInfo(UUID walletID) {
        return walletRepository.findById(walletID)
                .map(walletMapper::toDTO)
                .orElseThrow(() -> new RuntimeException());
    }

    @Transactional()
    public WalletDTO operation(WalletOperationDTO walletOperationDTO) {
        BigDecimal amount = walletOperationDTO.getAmount();
        OperationType operationType = walletOperationDTO.getOperationType();
        UUID walletID = walletOperationDTO.getId();

        return switch (operationType) {
            case DEPOSIT -> adjustWalletBalance(walletID, amount);
            case WITHDRAW -> adjustWalletBalance(walletID, amount);
        };
    }

    private WalletDTO adjustWalletBalance(UUID walletID, BigDecimal amount) {
        Wallet existingWallet = walletRepository.findById(walletID)
                .orElseThrow(() -> new WalletNotFoundException(walletID));

        BigDecimal adjustedAmount = existingWallet.getBalance().add(amount);
        if (adjustedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException(existingWallet.getBalance(), walletID);
        }
        existingWallet.setBalance(adjustedAmount);
        existingWallet = walletRepository.save(existingWallet);
        return walletMapper.toDTO(existingWallet);
    }
}
