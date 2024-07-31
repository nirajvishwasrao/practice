package com.Spring_security.default_and_httplogin.Repositeries;

import com.Spring_security.default_and_httplogin.database_tables.Database_table;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface sqltablerepo extends JpaRepository<Database_table, Integer> {
   public Database_table findByUsername(String username);
}
