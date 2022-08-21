package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.models.Account;
import com.demo.models.Role;
import com.demo.repositories.AccountRepository;


@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException("Username not found");
		}else {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			for(Role role : account.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new User(account.getUsername(), account.getPassword(), roles);
		}
	}

	@Override
	public Account findByUsername(String username) {
		Account account = accountRepository.findByUsername(username);
		return account;
	}

	@Override
	public Iterable<Account> GetAll() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		
		return accountRepository.findById(id);
	}
	
	
}
