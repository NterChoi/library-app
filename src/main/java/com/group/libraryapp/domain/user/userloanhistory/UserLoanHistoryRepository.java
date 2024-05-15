package com.group.libraryapp.domain.user.userloanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // select * from user_loan_histroy where book_name = ? and isReturn = ?
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
