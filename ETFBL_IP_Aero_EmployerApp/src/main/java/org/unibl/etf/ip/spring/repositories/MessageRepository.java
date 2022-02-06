package org.unibl.etf.ip.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ip.spring.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
