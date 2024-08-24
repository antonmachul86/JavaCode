package com.myTask.JavaCode.DTO;

import com.myTask.JavaCode.State.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletOperationDTO {
    @NotNull
    UUID id = UUID.randomUUID();;

    @NotNull
    OperationType operationType;

    @Positive
    BigDecimal amount;
}
