package com.example.core.web.dto.mapper;

import com.example.common.domain.model.Transaction;
import com.example.core.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {
}
