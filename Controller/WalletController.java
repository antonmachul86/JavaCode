package com.myTask.JavaCode.Controller;

import com.myTask.JavaCode.DTO.WalletDTO;
import com.myTask.JavaCode.DTO.WalletOperationDTO;
import com.myTask.JavaCode.Service.WalletService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletController {
    final WalletService walletService;

    @PostMapping("/api/v1/wallet")
    public WalletDTO performWalletTransaction(@Validated @RequestBody WalletOperationDTO walletOperationDTO) {
        return walletService.operation(walletOperationDTO);
    }

    @GetMapping("/api/v1/wallets/{WALLET_UUID}")
    public WalletDTO getWallet(@PathVariable("WALLET_UUID") UUID walletUUID) {
        return walletService.getWalletInfo(walletUUID);
    }
}
