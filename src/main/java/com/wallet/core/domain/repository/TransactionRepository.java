package com.wallet.core.domain.repository;

import com.wallet.core.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.type = 'EXPENSE'")
    BigDecimal sumTotalExpensesByUserId(@Param("userId") Long userId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.type = 'INCOME'")
    BigDecimal sumTotalIncomeByUserId(@Param("userId") Long userId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.type = :type AND t.timestamp BETWEEN :start AND :end")
    BigDecimal sumByUserIdAndTypeAndPeriod(
            @Param("userId") Long userId,
            @Param("type") String type,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
