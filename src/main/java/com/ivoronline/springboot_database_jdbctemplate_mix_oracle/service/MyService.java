package com.ivoronline.springboot_database_jdbctemplate_mix_oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private JdbcTemplate jdbcTemplate;

  //=========================================================================================================
  // PREPARED STATEMENT
  //=========================================================================================================
  public int preparedStatement(String name, Integer age) {

    //CREATE STATEMENTS
    String statements = " BEGIN                                                           "+
                        "   INSERT INTO PERSON (NAME, AGE) VALUES (?, ?);                 "+
                        "   UPDATE      PERSON SET NAME = 'John New' WHERE name = 'John'; "+
                        " END;                                                            ";

    //EXECUTE STATEMENT
    return jdbcTemplate.update(
        statements
      , new Object[] { name, 3 }
    );

  }

  //=========================================================================================================
  // CONCATENATE
  //=========================================================================================================
  public int concatenate(String name, Integer age) {

    //CREATE STATEMENTS
    String statements = " BEGIN                                                           "+
                        "   INSERT INTO PERSON (NAME, AGE) VALUES ( '"+name+"',"+age+") ; "+
                        "   UPDATE      PERSON SET NAME = 'John New' WHERE name = 'John'; "+
                        " END;                                                            ";

    //EXECUTE STATEMENT
    return jdbcTemplate.update(statements);

  }

}
