package com.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.models.Account;
import com.demo.models.Role;
import com.demo.repositories.AccountRepository;

public interface AccountService extends UserDetailsService {
	public Account save(Account account);
	public Account findByUsername(String username);
	public Iterable<Account> GetAll();
	public Account findById(int id);
}
