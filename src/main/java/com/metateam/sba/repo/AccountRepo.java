package com.metateam.sba.repo;

import com.metateam.sba.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Integer> {
}
